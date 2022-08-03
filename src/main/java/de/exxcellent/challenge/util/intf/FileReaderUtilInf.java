package de.exxcellent.challenge.util.intf;

import de.exxcellent.challenge.type.csv.DelimiterEnum;

import java.io.IOException;
import java.util.function.Consumer;

public interface FileReaderUtilInf {
    void iterateOverFileWithoutHeaders(String fileName, DelimiterEnum delimiter, Consumer<String[]> callback) throws IOException;
}
