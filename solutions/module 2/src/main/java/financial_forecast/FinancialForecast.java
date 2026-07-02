package financial_forecast;

import java.util.HashMap;
import java.util.Map;

public class FinancialForecast {

    private double growthRate;
    private Map<Integer, Double> memoizationCache; // Used for the optimized method

    public FinancialForecast(double growthRate) {
        this.growthRate = growthRate;
        this.memoizationCache = new HashMap<>();
    }

    /**
     * NAIVE RECURSION
     * Predicts future value, but recalculates the same years repeatedly.
     */
    public double predictValueNaive(int year, double yearZeroValue, double yearOneValue) {
        // Base Cases: We already know the data for Year 0 and Year 1
        if (year == 0) return yearZeroValue;
        if (year == 1) return yearOneValue;

        // Recursive Step: Depends on the previous two years
        double previousYear = predictValueNaive(year - 1, yearZeroValue, yearOneValue);
        double twoYearsAgo = predictValueNaive(year - 2, yearZeroValue, yearOneValue);

        return previousYear + (twoYearsAgo * growthRate);
    }

    /**
     * OPTIMIZED RECURSION (Memoization)
     * Stores previously calculated years in memory to avoid redundant work.
     */
    public double predictValueOptimized(int year, double yearZeroValue, double yearOneValue) {
        // Base Cases
        if (year == 0) return yearZeroValue;
        if (year == 1) return yearOneValue;

        // Check if we have already calculated this year
        if (memoizationCache.containsKey(year)) {
            return memoizationCache.get(year); // Return cached value instantly
        }

        // Recursive Step
        double previousYear = predictValueOptimized(year - 1, yearZeroValue, yearOneValue);
        double twoYearsAgo = predictValueOptimized(year - 2, yearZeroValue, yearOneValue);
        double result = previousYear + (twoYearsAgo * growthRate);

        // Save the result to our cache before returning it
        memoizationCache.put(year, result);
        return result;
    }

    // Example Usage
    public static void main(String[] args) {
        FinancialForecast forecast = new FinancialForecast(1.05); // 5% base growth rate

        double yearZero = 10000.0;
        double yearOne = 10500.0;
        int targetYear = 35;

        System.out.println("Starting optimized calculation...");
        long startTimeOpt = System.currentTimeMillis();
        double optResult = forecast.predictValueOptimized(targetYear, yearZero, yearOne);
        long endTimeOpt = System.currentTimeMillis();
        System.out.println("Optimized Result: $" + Math.round(optResult));
        System.out.println("Optimized Time: " + (endTimeOpt - startTimeOpt) + "ms\n");

        System.out.println("Starting naive calculation... (This may take a moment)");
        long startTimeNaive = System.currentTimeMillis();
        double naiveResult = forecast.predictValueNaive(targetYear, yearZero, yearOne);
        long endTimeNaive = System.currentTimeMillis();
        System.out.println("Naive Result: $" + Math.round(naiveResult));
        System.out.println("Naive Time: " + (endTimeNaive - startTimeNaive) + "ms");
    }
}
