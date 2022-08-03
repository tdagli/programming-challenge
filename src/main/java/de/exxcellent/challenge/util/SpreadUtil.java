package de.exxcellent.challenge.util;

import de.exxcellent.challenge.type.FileConfiguration;
import de.exxcellent.challenge.util.intf.FileReaderUtilInf;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class SpreadUtil {
    private static int getSpread(int first, int second) {
        int spread = first - second;
        //need to flip negative value to find closest to 0
        return spread < 0 ? spread * -1 : spread;
    }

    public static String getSmallestSpread(FileConfiguration fileConfiguration, int firstValueIndex, int secondValueIndex) throws IOException {
        FileReaderUtilInf fileReader = FileReaderUtil.getFileReaderUtilByFileType(fileConfiguration.getType());
        AtomicInteger smallestSpread = new AtomicInteger(Integer.MAX_VALUE);
        AtomicReference<String> entityNameWithSmallestSpread = new AtomicReference<>();
        fileReader.iterateOverFileWithoutHeaders(fileConfiguration.getName(), fileConfiguration.getDelimiter(), (values) -> {
            int firstValue = Integer.parseInt(values[firstValueIndex]);
            int secondValue = Integer.parseInt(values[secondValueIndex]);
            int goalSpread = SpreadUtil.getSpread(firstValue, secondValue);
            if (goalSpread < smallestSpread.get()) {
                smallestSpread.set(goalSpread);
                entityNameWithSmallestSpread.set(values[0]);
            }
        });
        return entityNameWithSmallestSpread.get();
    }
}
