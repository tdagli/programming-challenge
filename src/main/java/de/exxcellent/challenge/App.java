package de.exxcellent.challenge;

import de.exxcellent.challenge.type.FileConfiguration;
import de.exxcellent.challenge.type.SupportedFileTypeEnum;
import de.exxcellent.challenge.type.csv.DelimiterEnum;
import de.exxcellent.challenge.util.CSVUtil;
import de.exxcellent.challenge.util.FootballUtil;
import de.exxcellent.challenge.util.WeatherUtil;

import java.io.IOException;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    public static String resourcesPath = "src/main/resources/de/exxcellent/challenge/";

    /**
     * This is the main entry method of your program.
     *
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        FileConfiguration weatherFileConfiguration = new FileConfiguration("weather.csv", DelimiterEnum.COMMA, SupportedFileTypeEnum.CSV);
        FileConfiguration footballFileConfiguration = new FileConfiguration("football.csv", DelimiterEnum.COMMA, SupportedFileTypeEnum.CSV);

        try {
            String dayWithSmallestTempSpread = WeatherUtil.getDayWithSmallestTempSpread(weatherFileConfiguration);
            System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String teamWithSmallestGoalSpread = FootballUtil.getTeamWithSmallestGoalSpread(footballFileConfiguration);
            System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
