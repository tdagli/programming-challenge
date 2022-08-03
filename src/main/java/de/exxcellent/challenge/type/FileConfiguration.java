package de.exxcellent.challenge.type;

import de.exxcellent.challenge.type.csv.DelimiterEnum;

public class FileConfiguration {

    private String name;

    private DelimiterEnum delimiter;

    private SupportedFileTypeEnum type;

    public FileConfiguration(String name, DelimiterEnum delimiter, SupportedFileTypeEnum type) {
        this.name = name;
        this.delimiter = delimiter;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public DelimiterEnum getDelimiter() {
        return delimiter;
    }

    public SupportedFileTypeEnum getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }
}
