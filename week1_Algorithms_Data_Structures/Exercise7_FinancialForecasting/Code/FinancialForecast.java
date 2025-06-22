import java.util.Scanner;

public class FinancialForecast {

    public static double calculateFutureValue(double amount, double rate, int years) {
        if (years == 0) {
            return amount;
        }
        return calculateFutureValue(amount * (1 + rate), rate, years - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter current amount: ");
        double currentAmount = sc.nextDouble();
        System.out.print("Enter annual growth rate: ");
        double growthRate = sc.nextDouble();
        System.out.print("Enter number of years to forecast: ");
        int years = sc.nextInt();


        double rate = growthRate / 100;
        double futureValue = calculateFutureValue(currentAmount, rate, years);
        System.out.printf("\n Future value after %d years: ₹%.2f\n", years, futureValue);

    }
}
