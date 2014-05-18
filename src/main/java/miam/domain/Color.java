package miam.domain;

import com.google.common.base.Strings;
import com.sun.deploy.util.StringUtils;

/**
 * Created by ismael on 12/05/14.
 */
public enum Color {
    RED("red"),
    BLUE("blue"),
    GREEN("green"),
    VIOLET("purple");

    private String color;

    Color(String color) {
        this.color = color;
    }

    public static Color valueOfString(String color) {
        return Color.valueOf(color.toUpperCase());
    }
}
