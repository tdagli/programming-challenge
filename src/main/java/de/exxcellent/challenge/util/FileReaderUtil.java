package de.exxcellent.challenge.util;

import de.exxcellent.challenge.type.SupportedFileTypeEnum;
import de.exxcellent.challenge.util.intf.FileReaderUtilInf;

public class FileReaderUtil {

    public static FileReaderUtilInf getFileReaderUtilByFileType(SupportedFileTypeEnum fileTypeEnum) {
        switch (fileTypeEnum) {
            case CSV:
                return new CSVUtil();
            default:
                throw new RuntimeException("File Type: " + fileTypeEnum + " not supported in switch statement.");
        }
    }
}
