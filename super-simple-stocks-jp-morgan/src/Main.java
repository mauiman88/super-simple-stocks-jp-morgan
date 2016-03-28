import utils.DateUtils;
import utils.StockUtils;
import model.Stock;
import model.StockType;
import model.Trade;
import model.TradeIndicator;
import utils.TradingUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    private static final double MARKET_PRICE = 1.2;
    private static final double STOCK_PRICE = 1.6;

    public static void main(String[] args) {
        System.out.println("App is running...");

        //Stocks
        final List<Stock> stocks = initStocks();
        //Trades
        final List<Trade> trades = initTradesByStocks(stocks);

        //Results
        System.out.println("\nDividend yield");
        for (Stock stock : stocks) {
            System.out.println("Stock: " + stock.symbol + "'s dividend yield: " +
                    StockUtils.calculateDividendYield(stock, MARKET_PRICE));
        }

        System.out.println("\nP/E Ratio");
        for (Stock stock : stocks) {
            System.out.println("Stock: " + stock.symbol + " -> " +
                    StockUtils.calculatePERatio(stock, STOCK_PRICE));
        }

        System.out.println("\nTrades");
        System.out.println("+--------+-----------+----------+-------+-------------------------------+");
        System.out.println("| Symbol | Indicator | Quantity | Price |              Date             |");
        System.out.println("+--------+-----------+----------+-------+-------------------------------+");

        for (Trade trade : trades) {
            printTradeInRow(trade);
        }

        System.out.println("+--------+-----------+----------+-------+-------------------------------+ \n");
        System.out.println("Geometric Mean: " + TradingUtils.calculateGeometricMeanByTrades(trades));
        System.out.println("Stock Price based on trades recorded in past 15 minutes: " + TradingUtils.calculateStockPriceByTrades(trades));
    }

    private static List<Stock> initStocks() {
        final List<Stock> stocks = new ArrayList<Stock>();

        stocks.add(new Stock("TEA", StockType.COMMON, 0.0, 0.0, 0.1));
        stocks.add(new Stock("POP", StockType.COMMON, 0.08, 0.0, 0.1));
        stocks.add(new Stock("ALE", StockType.COMMON, 0.23, 0.0, 0.06));
        stocks.add(new Stock("GIN", StockType.PREFERRED, 0.08, 0.2, 0.1));
        stocks.add(new Stock("JOE", StockType.COMMON, 0.13, 0.0, 0.25));

        return stocks;
    }

    private static List<Trade> initTradesByStocks(List<Stock> stocks) {
        final List<Trade> trades = new ArrayList<Trade>();

        System.out.println("Creating a trade for each stock");
        trades.add(TradingUtils.createBuyTrade(stocks.get(0), new Date(), 12, 102));
        trades.add(TradingUtils.createSellTrade(stocks.get(0), DateUtils.getEarlierDateByMinutes(17), 56, 160));
        trades.add(TradingUtils.createBuyTrade(stocks.get(1), new Date(), 22, 132));
        trades.add(TradingUtils.createBuyTrade(stocks.get(2), DateUtils.getEarlierDateByMinutes(20), 12, 102));
        trades.add(TradingUtils.createSellTrade(stocks.get(2), new Date(), 30, 121));
        trades.add(TradingUtils.createBuyTrade(stocks.get(3), DateUtils.getEarlierDateByMinutes(14), 26, 130));
        trades.add(TradingUtils.createSellTrade(stocks.get(4), new Date(), 92, 312));

        return trades;
    }

    /**
     * print trade in table format
     * @param trade
     */
    private static void printTradeInRow(Trade trade) {
        String printFormat = "|  " + trade.getStock().symbol + "   |    ";
        printFormat += TradeIndicator.BUY.equals(trade.getIndicator()) ? trade.getIndicator() + " " : trade.getIndicator();
        printFormat += "   |    " + trade.getQuantity() + "    | " + trade.getPrice() + " | " + trade.getTimestamp() + " |";

        System.out.println(printFormat);
    }
}