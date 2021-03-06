package com.github.gundabadec.fonttextviews.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v7.widget.AppCompatButton;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.Button;

import com.github.gundabadec.fonttextviews.FontFabric;
import com.github.gundabadec.fonttextviews.TypefaceSpan2;

/**
 * Created by magomed on 07/06/16.
 */
public class RoubleButton extends AppCompatButton {
    public RoubleButton(Context context) {
        super(context);
    }

    public RoubleButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RoubleButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        if (!TextUtils.isEmpty(text)) {
            SpannableStringBuilder resultSpan = new SpannableStringBuilder(text);
            for (int i = 0; i < resultSpan.length(); i++) {
                if (resultSpan.charAt(i) == '\u20BD') {
                    TypefaceSpan2 roubleTypefaceSpan = new TypefaceSpan2(FontFabric.getTypeface(getContext().getAssets(), FontFabric.FONT_ROUBLE_NAME));
                    resultSpan.setSpan(roubleTypefaceSpan, i, i + 1, 0);
                }
            }
            super.setText(resultSpan, type);
        } else
            super.setText(text, type);
    }
}
