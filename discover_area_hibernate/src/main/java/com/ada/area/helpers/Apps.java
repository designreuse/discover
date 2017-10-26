package com.ada.area.helpers;

public class Apps {
    public static void main(String[] args) {
        String geo = "1|11590057.96,4489812.75;11590057.96,4489812.75|11590057.96,4489812.75;";
        String[] xx = geo.split("|");
        geo = geo.split("\\|")[2];
        geo = geo.substring(0, geo.length() - 1);
        String[] geox = geo.split(",");
        System.out.println(geox[0] + "," + geox[1]);

        double x = Double.parseDouble(geox[0]) / 20037508.34 * 180;
        double y = Double.parseDouble(geox[1]) / 20037508.34 * 180;

        System.out.println(x + "," + y);


    }
}
