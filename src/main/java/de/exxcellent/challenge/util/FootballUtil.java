package de.exxcellent.challenge.util;

import de.exxcellent.challenge.type.SupportedFileTypeEnum;
import de.exxcellent.challenge.type.csv.DelimiterEnum;
import de.exxcellent.challenge.util.intf.FileReaderUtilInf;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class FootballUtil {

    public static String getTeamWithSmallestGoalSpread(String fileName, DelimiterEnum delimiter, SupportedFileTypeEnum supportedFileTypeEnum) throws IOException {
        FileReaderUtilInf fileReader = FileReaderUtil.getFileReaderUtilByFileType(supportedFileTypeEnum);
        AtomicInteger smallestGoalSpread = new AtomicInteger(Integer.MAX_VALUE);
        AtomicReference<String> teamWithSmallestGoalSpread = new AtomicReference<>();
        fileReader.iterateOverFileWithoutHeaders(fileName, delimiter, (values) -> {
            int goals = Integer.parseInt(values[5]);
            int goalsAllowed = Integer.parseInt(values[6]);
            int goalSpread = SpreadUtil.getSpread(goals, goalsAllowed);
            if (goalSpread < smallestGoalSpread.get()) {
                smallestGoalSpread.set(goalSpread);
                teamWithSmallestGoalSpread.set(values[0]);
            }
        });
        return teamWithSmallestGoalSpread.get();
    }
}
