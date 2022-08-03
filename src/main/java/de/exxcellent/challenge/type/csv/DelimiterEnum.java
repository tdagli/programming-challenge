package de.exxcellent.challenge.type.csv;

public enum DelimiterEnum {

    COMMA(",");

    private final String symbol;

    DelimiterEnum(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
