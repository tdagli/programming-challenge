package de.exxcellent.challenge.util;

import de.exxcellent.challenge.type.FileConfiguration;
import de.exxcellent.challenge.type.SupportedFileTypeEnum;
import de.exxcellent.challenge.type.csv.DelimiterEnum;
import de.exxcellent.challenge.util.intf.FileReaderUtilInf;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class FootballUtil {

    public static String getTeamWithSmallestGoalSpread(FileConfiguration fileConfiguration) throws IOException {
        return SpreadUtil.getSmallestSpread(fileConfiguration, 5, 6);
    }
}
