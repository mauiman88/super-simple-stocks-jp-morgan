package model;

/**
 * Created by Mate on 2016.03.27..
 * Stock
 */
public class Stock {

    public final String symbol;

    public final StockType type;

    public final double lastDividend;

    public final double fixedDividend;

    public final double parValue;

    public Stock(String symbol, StockType type, double lastDividend, double fixedDividend, double parValue) {
        this.symbol = symbol;
        this.type = type;
        this.lastDividend = lastDividend;
        this.fixedDividend = fixedDividend;
        this.parValue = parValue;
    }
}
