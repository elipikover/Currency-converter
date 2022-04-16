import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import Coins.*;
import utilities.CoinFactory;
import utilities.CoinsEnum;


public class Main {

//    method that takes user selection of currency to convert and returns selected Coin Object ILS or USD
    private static Coin getUserCurrency() {
while (true) {

    try {
        Scanner userInput = new Scanner(System.in);
        int operator = userInput.nextInt();

        CoinFactory coin = new CoinFactory();

        if (operator == 1) {
            return coin.getCoins(CoinsEnum.USD);

        } else if (operator == 2) {
            return coin.getCoins(CoinsEnum.ILS);

//            Handle error case of wrong numeric input
        } else {
            System.out.println("Invalid Choice, please try again");
        }

//        handle error cases of input mismatch(non integer)
    } catch (InputMismatchException e) {
        System.out.println("Invalid Choice, please try again");
    }
}
    }

//    method that takes from user amount to convert and returns as double(Second Screen)
    private static double getUserAmount() {

        System.out.println("Please enter an amount to convert");

        while (true) {

            try {
                Scanner userInput = new Scanner(System.in);
                return userInput.nextDouble();

            } catch (InputMismatchException e) {
                System.out.println("Invalid Choice, please try again");

            }
        }
    }

//    Print all conversion Results
    private static void printResults(ArrayList<Double> conversionResults) {

        for (double item : conversionResults){
            System.out.println(getFormat(item));
        }
    }

    private static boolean anotherRound() {
        while (true) {
            try {
                Scanner userInput = new Scanner(System.in);
                String answer = userInput.nextLine();

                if (answer.equalsIgnoreCase("Y")) {
                    return  true;
                } else if (answer.equalsIgnoreCase("N")) {
                    return false;
                } else {
                    System.out.println("Invalid Choice, please try again");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Choice, please try again");
            }
        }
    }

//    Write to file all the conversion results
    private static void writeToFile(ArrayList<Double> conversionResults) throws IOException {
        FileWriter myWriter = new FileWriter("results.txt");
        for (double item : conversionResults){
            String str = Double.toString(item);
            myWriter.write(str+"\n");
        }
        myWriter.close();
    }

//    Format result to look nice(tio decimal)
    private static String getFormat(double result) {
        DecimalFormat df = new DecimalFormat("###.#");
        return df.format(result);
    }



    public static void main(String[] args) throws IOException {

//      Initialize array of conversion results to store user results
        ArrayList<Double> conversionResultList = new ArrayList<>();

// Print Introduction screen for the user(First screen)
        System.out.println("\nWelcome to currency converter\n");

//        Iterator for main program loop
        boolean iterator = true;

        while (iterator) {

        System.out.println(
                "\nPlease choose an option (1/2):\n" +
                        "1. Dollars to Shekels”\n" +
                        "2. Shekels to Dollars");

////    Calculate result of currency conversion and show to user
        double result = getUserCurrency().calculate(getUserAmount());
//
//      Print result for the user(Third screen)
        System.out.println("Result of the conversion:  " + getFormat(result));

//      Store result of conversion in ArrayList
        conversionResultList.add(result);

//      Ask user to make another conversion
        System.out.println("\n\nPlease choose if you would like to make another conversion\n Y / N.");
//        get answer from user
        iterator = anotherRound();
}

// Print final message for the user

        System.out.println("\nThanks for using our currency converter\n");

//        Print the array of results and write all results to file

        printResults(conversionResultList);

        writeToFile(conversionResultList);


    }




}


