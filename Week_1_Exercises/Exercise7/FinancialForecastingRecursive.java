package Exercise7;

public class FinancialForecastingRecursive {
    public static double calculateFutureValue(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue;
        }
        return calculateFutureValue(presentValue * (1 + growthRate), growthRate, years - 1);
    }

    public static void main(String[] args) {
        double presentValue = 1000.0;  
        double growthRate = 0.05;      
        int years = 10;                

        double futureValue = calculateFutureValue(presentValue, growthRate, years);
        System.out.printf("Future Value after %d years (Recursive): $%.2f%n", years, futureValue);
    }
}

