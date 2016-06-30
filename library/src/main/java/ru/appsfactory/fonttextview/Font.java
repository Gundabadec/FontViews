package ru.appsfactory.fonttextview;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by magomed on 26/05/16.
 */
public class Font {
    final public static String FONT_YANUSC_NAME = "YanusC.otf";
    final public static String FONT_PFDINTEXTCOMPRO_NAME = "PFDinTextCompPro-Regular.ttf";
    final public static String FONT_OPEN_SANS_NAME = "OpenSans-Regular.ttf";
    final public static String FONT_TTPROSTO_SANS_NAME = "TTProstoSans-Bold.otf";

    final public static Font FONT_YANUSC = new Font(FONT_YANUSC_NAME, 0);
    final public static Font FONT_PFDINTEXTCOMPRO = new Font(FONT_PFDINTEXTCOMPRO_NAME, 1);
    final public static Font FONT_OPEN_SANS = new Font(FONT_OPEN_SANS_NAME, 2);
    final public static Font FONT_TTPROSTO_SANS = new Font(FONT_TTPROSTO_SANS_NAME, 3);

    private static Map<Integer, Font> map = new HashMap<>();

    static {
        map.put(0, FONT_YANUSC);
        map.put(1, FONT_PFDINTEXTCOMPRO);
        map.put(2, FONT_OPEN_SANS);
        map.put(3, FONT_TTPROSTO_SANS);
    }

    private String name;
    private int index;

    public Font(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public static Font valueOf(int index) {
        return map.get(index);
    }

    public String getName() {
        return name;
    }


}
