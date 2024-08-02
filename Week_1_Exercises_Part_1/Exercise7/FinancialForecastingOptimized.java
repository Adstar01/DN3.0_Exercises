package Exercise7;

public class FinancialForecastingOptimized {
    public static double calculateFutureValueIterative(double presentValue, double growthRate, int years) {
        double futureValue = presentValue;
        for (int i = 0; i < years; i++) {
            futureValue *= (1 + growthRate);
        }
        return futureValue;
    }

    public static void main(String[] args) {
        double presentValue = 1000.0;  
        double growthRate = 0.05;      
        int years = 10;                

        double futureValueIterative = calculateFutureValueIterative(presentValue, growthRate, years);
        System.out.printf("Future Value after %d years (Iterative): $%.2f%n", years, futureValueIterative);
    }
}

