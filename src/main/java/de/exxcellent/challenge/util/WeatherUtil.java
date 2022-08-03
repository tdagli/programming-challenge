package de.exxcellent.challenge.util;

import de.exxcellent.challenge.type.FileConfiguration;

import java.io.IOException;

public class WeatherUtil {

    public static String getDayWithSmallestTempSpread(FileConfiguration fileConfiguration) throws IOException {
        return SpreadUtil.getSmallestSpread(fileConfiguration, 1, 2);
    }
}
