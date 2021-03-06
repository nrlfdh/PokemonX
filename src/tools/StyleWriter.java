package tools;

import javafx.scene.layout.BorderStrokeStyle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StyleWriter {

    private static double radii,
            borderWidths;
    private static String color;
    private static String tmpBSS;


    public static void writeStyles(String color, String borderStrokeStyle, double radii, double borderWidths) {
        String line = color + "\n" + borderStrokeStyle + "\n" + radii + "\n" + borderWidths;
        Writer.writer(line, "userStyle", false);
    }

    public static void setFields() {
        String path = System.getProperty("user.home") + "/PokemonX/userStyle.txt";
        System.out.println(path);

        try {
            Scanner sc = new Scanner(new FileInputStream(path));
            color = sc.nextLine();
            tmpBSS = sc.nextLine();
            radii = Double.valueOf(sc.nextLine());
            borderWidths = Double.valueOf(sc.nextLine());
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    public static Double getRadii() {
        return radii;
    }

    public static Double getBorderWidths() {
        return borderWidths;
    }


    public static String getColor() {
        return color;
    }

    public static BorderStrokeStyle getBorderStrokeStyle() {
        switch (tmpBSS) {
            case "BorderStrokeStyle.SOLID":
                return BorderStrokeStyle.SOLID;
            case "BorderStrokeStyle.DASHED":
                return BorderStrokeStyle.DASHED;
            case "BorderStrokeStyle.DOTTED":
                return BorderStrokeStyle.DOTTED;
            case "BorderStrokeStyle.NONE":
                return BorderStrokeStyle.NONE;
            default:
                return BorderStrokeStyle.SOLID;
        }
    }
}
