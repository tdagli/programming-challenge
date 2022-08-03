package de.exxcellent.challenge.util;

import de.exxcellent.challenge.type.csv.DelimiterEnum;
import de.exxcellent.challenge.util.intf.FileReaderUtilInf;

import java.io.*;
import java.util.function.Consumer;

public class CSVUtil implements FileReaderUtilInf {

    public void iterateOverFileWithoutHeaders(String fileName, DelimiterEnum delimiter, Consumer<String[]> callback) throws IOException {
        //https://www.baeldung.com/java-csv-file-array#buff-reader
        FileReader reader = new FileReader("src/main/resources/de/exxcellent/challenge/" + fileName);
        BufferedReader br = new BufferedReader(reader);
        String line;
        int index = 0;
        while ((line = br.readLine()) != null) {
            //skip headers
            if (index == 0) {
                index++;
                continue;
            }
            String[] values = line.split(delimiter.getSymbol());
            callback.accept(values);
        }
    }

}
