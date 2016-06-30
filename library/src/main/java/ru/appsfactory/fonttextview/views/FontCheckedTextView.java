package ru.appsfactory.fonttextview.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;

import ru.appsfactory.font.fonttextviews.R;
import ru.appsfactory.fonttextview.Font;
import ru.appsfactory.fonttextview.FontFabric;

/**
 * Created by magomed on 26/05/16.
 */
public class FontCheckedTextView extends RoubleCheckedTextView {
    private Font font;

    public FontCheckedTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        setPaintFlags(getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);
        attachParams(context, attrs);
        setTypeFace();
    }


    public FontCheckedTextView(Context context) {
        super(context);
        attachParams(context, null);
    }

    private void attachParams(Context context, AttributeSet attrs) {
        if (attrs == null)
            return;
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.TextView,
                0, 0);

        try {
            int fontIndex = a.getInteger(R.styleable.TextView_font, -1);
            if (fontIndex != -1)
                font = Font.valueOf(fontIndex);
        } finally {
            a.recycle();
        }
    }

    private void setTypeFace() {
        if (font != null)
            setTypeface(FontFabric.getTypeface(getContext().getAssets(), font.getName()));
    }

    public void setFont(Font font) {
        this.font = font;
        setTypeFace();
    }
}
