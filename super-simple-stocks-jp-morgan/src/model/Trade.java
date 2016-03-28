package model;

import java.util.Date;

/**
 * Created by Mate on 2016.03.27..
 * Trade
 */
public class Trade {

    public final Stock stock;

    public final Date timestamp;

    public final int quantity;

    public final TradeIndicator indicator;

    public final double price;

    public Trade(Stock stock, Date timestamp, int quantity, TradeIndicator indicator, double price) {
        this.stock = stock;
        this.timestamp = timestamp;
        this.quantity = quantity;
        this.indicator = indicator;
        this.price = price;
    }

    public Stock getStock() {
        return stock;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public int getQuantity() {
        return quantity;
    }

    public TradeIndicator getIndicator() {
        return indicator;
    }

    public double getPrice() {
        return price;
    }
}
