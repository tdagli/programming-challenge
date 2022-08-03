package de.exxcellent.challenge.util;

public class SpreadUtil {
    public static int getSpread(int first, int second) {
        int spread = first - second;
        //need to flip negative value to find closest to 0
        return spread < 0 ? spread * -1 : spread;
    }
}
