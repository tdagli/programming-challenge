package de.exxcellent.challenge.util;

import de.exxcellent.challenge.type.SupportedFileTypeEnum;
import de.exxcellent.challenge.type.csv.DelimiterEnum;
import de.exxcellent.challenge.util.intf.FileReaderUtilInf;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class WeatherUtil {

    public static String getDayWithSmallestTempSpread(String fileName, DelimiterEnum delimiter, SupportedFileTypeEnum supportedFileTypeEnum) throws IOException {
        FileReaderUtilInf fileReader = FileReaderUtil.getFileReaderUtilByFileType(supportedFileTypeEnum);
        AtomicInteger smallestTempSpread = new AtomicInteger(Integer.MAX_VALUE);
        AtomicReference<String> dayWithSmallestTempSpread = new AtomicReference<>();
        fileReader.iterateOverFileWithoutHeaders(fileName, delimiter, (values) -> {
            int maxTemperature = Integer.parseInt(values[1]);
            int minTemperature = Integer.parseInt(values[2]);
            int tempSpread = SpreadUtil.getSpread(maxTemperature, minTemperature);
            if (tempSpread < smallestTempSpread.get()) {
                smallestTempSpread.set(tempSpread);
                dayWithSmallestTempSpread.set(values[0]);
            }
        });
        return dayWithSmallestTempSpread.get();
    }
}
