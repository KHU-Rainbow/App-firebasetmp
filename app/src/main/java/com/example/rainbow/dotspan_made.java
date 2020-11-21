package com.example.rainbow;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.LineBackgroundSpan;

/**
 * Span to draw a dot centered under a section of text
 */
public class dotspan_made implements LineBackgroundSpan {

    /**
     * Default radius used
     */
    public static final float DEFAULT_RADIUS = 3;

    private final float radius;
    private final int color;

    public dotspan_made() {
        this.radius = DEFAULT_RADIUS;
        this.color = 0;
    }

    public dotspan_made(int color) {
        this.radius = DEFAULT_RADIUS;
        this.color = color;
    }

    public dotspan_made(float radius) {
        this.radius = radius;
        this.color = 0;
    }

    public dotspan_made(float radius, int color) {
        this.radius = radius;
        this.color = color;
    }

    @Override
    public void drawBackground(
            Canvas canvas, Paint paint,
            int left, int right, int top, int baseline, int bottom,
            CharSequence charSequence,
            int start, int end, int lineNum
    ) {
        int oldColor = paint.getColor();
        if (color != 0) {
            paint.setColor(color);
        }
        canvas.drawCircle((left + right) / 2, bottom + radius, radius, paint);
        paint.setColor(oldColor);
    }
}