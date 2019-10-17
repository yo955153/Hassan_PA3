public class Application {

   public static void main(String[] args)
   {
       int i;
       SavingsAccount saver1 = new SavingsAccount(2000);
       SavingsAccount saver2 = new SavingsAccount(3000);

       SavingsAccount.modifyInterestRate(.04);

       for(i = 0; i < 12; i++)
       {

           System.out.printf("Saver 1: (Month %d) $%.2f\n", i+1, saver1.calculateMonthlyInterest());
           System.out.printf("Saver 2: (Month %d) $%.2f\n", i+1, saver2.calculateMonthlyInterest());
           System.out.printf("\n");
       }

       SavingsAccount.modifyInterestRate(.05);

       System.out.println("\n\nAfter one month of new interest rate:");

       System.out.printf("Saver  1: (Month 1) $%.2f\n", saver1.calculateMonthlyInterest());
       System.out.printf("Saver  2: (Month 1) $%.2f\n", saver2.calculateMonthlyInterest());
   }
}
