package ru.appsfactory.fonttextview.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;

import ru.appsfactory.fontPath.fonttextviews.R;
import ru.appsfactory.fonttextview.FontFabric;

/**
 * Created by magomed on 26/05/16.
 */
public class FontButton extends RoubleButton {
    private String fontPath;

    public FontButton(Context context) {
        super(context);
        init(context, null);
    }

    public FontButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public FontButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public FontButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        setPaintFlags(getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);
        attachParams(context, attrs);
        setTypeFace();
    }

    private void attachParams(Context context, AttributeSet attrs) {
        if (attrs == null)
            return;
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.TextView,
                0, 0);
        try {
            this.fontPath = a.getString(R.styleable.TextView_fontPath);
        } finally {
            a.recycle();
        }
    }

    private void setTypeFace() {
        if (!TextUtils.isEmpty(fontPath) && !isInEditMode())
            setTypeface(FontFabric.getTypeface(getContext().getAssets(), fontPath));
    }

    public void setFont(String fontPath) {
        this.fontPath = fontPath;
        setTypeFace();
    }
}
