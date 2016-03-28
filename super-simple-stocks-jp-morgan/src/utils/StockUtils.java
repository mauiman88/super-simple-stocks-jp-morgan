package utils;

import model.Stock;
import model.StockType;

/**
 * Created by Mate on 2016.03.27..
 * StockUtils
 */
public class StockUtils {

    /**
     * Calculate Dividend
     * @param stock
     * @return
     */
    public static double calculateDividend(Stock stock) {
        if(StockType.PREFERRED.equals(stock.type)) {
            return stock.fixedDividend * stock.parValue;
        }
        //COMMON
        return stock.lastDividend;
    }

    /**
     * Calculate Dividend Yield
     * @param stock
     * @param marketPrice
     * @return
     */
    public static double calculateDividendYield(Stock stock, double marketPrice) {
        return calculateDividend(stock) / marketPrice;
    }

    /**
     * Calculate P/E Ratio
     * @param stock
     * @param marketPrice
     * @return
     */
    public static double calculatePERatio(Stock stock, double marketPrice) {
        return marketPrice / calculateDividend(stock);
    }

}