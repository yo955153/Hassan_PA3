public class SavingsAccount
{
    private static double annualInterestRate;
    private double savingsBalance;

    public SavingsAccount(double initial_balance)
    {
        this.savingsBalance = initial_balance;
    }

    public double calculateMonthlyInterest()
    {
        double monthly_interest = (this.savingsBalance * annualInterestRate) / 12.0;
        this.savingsBalance += monthly_interest;
        return this.savingsBalance;
    }

    public static void modifyInterestRate(double newannualInterestRate)
    {
        annualInterestRate = newannualInterestRate;
    }
}
