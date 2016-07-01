package ru.appsfactory.fonttextview;

import android.app.Application;
import android.content.res.AssetManager;
import android.graphics.Typeface;

import java.util.HashMap;

/**
 * Created by magomed on 03/05/16.
 */

public class FontFabric {
    final public static String FONT_ROUBLE_NAME = "rouble2.ttf";

    private static final HashMap<String, Typeface> sTypefaceCache = new HashMap<>();

    public static Typeface getTypeface(AssetManager assetManager,String path) {
        if (!sTypefaceCache.containsKey(path)) {
            Typeface tf = Typeface.createFromAsset(assetManager, path);
            sTypefaceCache.put(path, tf);
        }
        return sTypefaceCache.get(path);
    }
}
