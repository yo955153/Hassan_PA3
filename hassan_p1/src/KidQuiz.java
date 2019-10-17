import java.util.Scanner;
import java.security.SecureRandom;
import java.lang.Float;

public class KidQuiz {


    // Method that determines problem type
    public static int problem_type()
    {
        Scanner scnr = new Scanner(System.in);
        int type;
        System.out.println("Enter a problem type: ");
        System.out.println("Option 1: (Addition)");
        System.out.println("Option 2: (Multiplication)");
        System.out.println("Option 3: (Subtraction)");
        System.out.println("Option 4: (Division)");
        System.out.println("Option 5: (Mixture)");
        type = scnr.nextInt();
        return type;
    }

    //Method that determines difficulty
    public static int difficulty()
    {
        Scanner scnr = new Scanner(System.in);
        int diff;
        System.out.println("Enter a difficulty level(1-4):");
        diff = scnr.nextInt();
        return diff;
    }

    //Method to generate responses
    public static void responses(double ans, double true_ans)
    {
        Scanner scnr = new Scanner(System.in);
        SecureRandom rand = new SecureRandom();
        int ranI3 = rand.nextInt(4) + 1;

        // If response is incorrect
        if(ans != true_ans)
        {
            switch (ranI3)
            {
                case 1:
                    System.out.println("No. Please try again.");
                    break;

                case 2:
                    System.out.println("Wrong. Try once more.");
                    break;

                case 3:
                    System.out.println("Don't give up!");
                    break;

                case 4:
                    System.out.println("No. Keep trying.");
                    break;

                default:
                    break;
            }
        }

        // If response is correct
        else
        {
            switch (ranI3)
            {
                case 1:
                    System.out.println("Very good!");
                    break;

                case 2:
                    System.out.println("Excellent!");
                    break;

                case 3:
                    System.out.println("Nice work!");
                    break;

                case 4:
                    System.out.println("Keep up the good work!");
                    break;

                default:
                    break;
            }
        }


    }

    // Question Function
    public static int question(int diff, int prob)
    {
        Scanner scnr = new Scanner(System.in);
        SecureRandom rand = new SecureRandom();
        int randomInt = rand.nextInt(10);
        int randomInt2 = rand.nextInt(10);
        int ranI4 = rand.nextInt(4) + 1;

        double tru_ans = 0;



        if(diff == 1)
        {
            randomInt = rand.nextInt(10);
            randomInt2 = rand.nextInt(10);
        }

        if(diff == 2)
        {
            randomInt = rand.nextInt(100);
            randomInt2 = rand.nextInt(100);
        }

        if(diff == 3)
        {
            randomInt = rand.nextInt(1000);
            randomInt2 = rand.nextInt(1000);
        }

        if(diff == 4)
        {
            randomInt = rand.nextInt(10000);
            randomInt2 = rand.nextInt(10000);
        }


        if(prob == 1)
        {
            System.out.println("How much is " + randomInt + " plus " + randomInt2 + "?");
            tru_ans = randomInt + randomInt2;
        }

        if(prob == 2)
        {
            System.out.println("How much is " + randomInt + " times " + randomInt2 + "?");
            tru_ans = randomInt * randomInt2;
        }

        if(prob == 3)
        {
            System.out.println("How much is " + randomInt + " minus " + randomInt2 + "?");
            tru_ans = randomInt - randomInt2;
        }

        if(prob == 4)
        {
            // Prevent division by 0
            if(randomInt2 == 0)
            {
                if(diff == 1)
                    randomInt2 = rand.nextInt(9) + 1;

                if(diff == 2)
                    randomInt2 = rand.nextInt(99) + 1;

                if(diff == 3)
                    randomInt2 = rand.nextInt(999) + 1;

                if(diff == 4)
                    randomInt2 = rand.nextInt(9999) + 1;

            }
            System.out.println("How much is " + randomInt + " divided by " + randomInt2 + "?");
            tru_ans = (double)randomInt / randomInt2;
        }

        if(prob == 5)
        {
            switch (ranI4)
            {
                case 1:
                    System.out.println("How much is " + randomInt + " plus " + randomInt2 + "?");
                    tru_ans = randomInt + randomInt2;
                    break;

                case 2:
                    System.out.println("How much is " + randomInt + " times " + randomInt2 + "?");
                    tru_ans = randomInt * randomInt2;
                    break;

                case 3:
                    System.out.println("How much is " + randomInt + " minus " + randomInt2 + "?");
                    tru_ans = randomInt - randomInt2;
                    break;

                case 4:
                    if(randomInt2 == 0)
                    {
                        if(diff == 1)
                            randomInt2 = rand.nextInt(9) + 1;

                        if(diff == 2)
                            randomInt2 = rand.nextInt(99) + 1;

                        if(diff == 3)
                            randomInt2 = rand.nextInt(999) + 1;

                        if(diff == 4)
                            randomInt2 = rand.nextInt(9999) + 1;

                    }
                    System.out.println("How much is " + randomInt + " divided by " + randomInt2 + "?");
                    tru_ans = (double)randomInt / randomInt2;
                    break;

                default:
                    break;
            }
        }


        double ans = scnr.nextDouble();

        responses(ans, tru_ans);

        if(ans != tru_ans)
            return 0;
        else
            return 1;
    }


    // Main Method
    public static void main(String[] args)
    {
        Scanner scnr = new Scanner(System.in);

        int i, indicator, diff, prob;
        double percentage;
        int correct = 0, incorrect = 0;
        int cont = 1;


        while(cont == 1)
        {
            diff = difficulty();
            prob = problem_type();
            correct = 0;
            incorrect = 0;
            for (i = 0; i < 10; i++) {
                indicator = question(diff, prob);
                if (indicator != 1)
                    incorrect++;
                else
                    correct++;

            }
            System.out.println("You got " + correct + " correct.");
            System.out.println("You got " + incorrect + " incorrect.");

            percentage = (double) (10 - incorrect) / 10.0;

            if (percentage >= .75)
                System.out.println("Congratulations, you are ready to go to the next level!");

            else
                System.out.println("Please ask your teacher for extra help.");

            // Prompt user if they want to conintue
            System.out.println("Do you want to continue? (1 for yes) (0 for no): ");
            cont = scnr.nextInt();
        }
    }
}
