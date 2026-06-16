package DSA;

public class FinancialForecasting {

    public static double calculateFutureValue(
            double presentValue,
            double growthRate,
            int years) {

        if (years == 0)
            return presentValue;

        return calculateFutureValue(
                presentValue,
                growthRate,
                years - 1)
                * (1 + growthRate);
    }

    public static void main(String[] args) {

        double presentValue = 10000;
        double growthRate = 0.10; // 10%
        int years = 5;

        double futureValue =
                calculateFutureValue(
                        presentValue,
                        growthRate,
                        years);

        System.out.printf(
                "Future Value after %d years = %.2f",
                years,
                futureValue);
    }
}
