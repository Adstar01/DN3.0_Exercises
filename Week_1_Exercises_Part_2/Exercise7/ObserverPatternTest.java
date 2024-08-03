package Week_1_Exercises_Part_2.Exercise7;

public class ObserverPatternTest {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp = new MobileApp("MobileApp1");
        Observer webApp = new WebApp("WebApp1");

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        stockMarket.setStockPrice(100.00);
        System.out.println("");

        stockMarket.setStockPrice(105.50);
        System.out.println("");

        stockMarket.deregisterObserver(webApp);

        stockMarket.setStockPrice(110.75);
    }
}

