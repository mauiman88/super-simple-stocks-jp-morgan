package utils;

import model.Stock;
import model.Trade;
import model.TradeIndicator;

import java.util.Date;
import java.util.List;

/**
 * Created by Mate on 2016.03.27..
 */
public class TradingUtils {

    public static Trade createBuyTrade(Stock stock, Date timestamp, int quantity, double price) {
        return new Trade(stock, timestamp, quantity, TradeIndicator.BUY, price);
    }

    public static Trade createSellTrade(Stock stock, Date timestamp, int quantity, double price) {
        return new Trade(stock, timestamp, quantity, TradeIndicator.SELL, price);
    }

    /**
     * Calculate Geometric Mean By Trades
     * @param trades
     * @return
     */
    public static double calculateGeometricMeanByTrades(List<Trade> trades) {
        double[] prices = new double[trades.size()];
        int iTrade = 0;
        for (Trade trade : trades)
        {
            prices[iTrade] = trade.price;
            iTrade++;
        }

        return calculateGeometricMeanByPrices(prices);
    }

    /**
     * Calculate Geometric Mean By Prices
     * @param prices
     * @return
     */
    private static double calculateGeometricMeanByPrices(double[] prices) {
        double productOfPrices = 1.0;
        for (double price : prices)
        {
            productOfPrices *= price;
        }
        double nRootPower = 1.0 / prices.length;
        return Math.pow(productOfPrices, nRootPower);
    }

    /**
     * Calculate Stock Price By Trades
     * @param trades
     * @return
     */
    public static double calculateStockPriceByTrades(List<Trade> trades) {
        double pricesPerQuantities = 0d;
        double quantities = 0d;

        for (Trade trade : trades) {
            if(trade.timestamp.after(DateUtils.getEarlierDateByMinutes(15))) {
                pricesPerQuantities += trade.price * trade.quantity;
                quantities += trade.quantity;
            }
        }

        return pricesPerQuantities / quantities;
    }

}