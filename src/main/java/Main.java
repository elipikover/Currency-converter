import java.awt.*;
import java.io.File;
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
    private static Scanner userInput = new Scanner(System.in);

    //    Initialize Scanner for taking user input
    static void scannerInit(){
        userInput = new Scanner(System.in);
    }


    //    method that takes user selection of currency to convert and returns selected Coin Object ILS or USD
    private static Coin getUserCurrency() {
        while (true) {

            try {

                int operator = userInput.nextInt();

                CoinFactory coin = new CoinFactory();

                if (operator == 1) {
                    return coin.getCoins(CoinsEnum.USD);

                } else if (operator == 2) {
                    return coin.getCoins(CoinsEnum.ILS);

                } else if (operator == 3) {
                    return coin.getCoins(CoinsEnum.EUR);

//            Handle error case of wrong numeric input
                } else {
                    System.out.println("Invalid Choice, please try again");
                    scannerInit();
                }

//        handle error cases of input mismatch(non integer)
            } catch (InputMismatchException e) {
                System.out.println("Invalid Choice, please try again");
                scannerInit();

            }
        }
    }

    //    method that takes from user amount to convert and returns as double(Second Screen)
    private static double getUserAmount() {

        System.out.println("Please enter an amount to convert");

        while (true) {

            try {

                return userInput.nextDouble();

            } catch (InputMismatchException e) {
                System.out.println("Invalid Choice, please try again");
                scannerInit();

            }finally {
                scannerInit();
            }
        }
    }

    //    Print all conversion Results
    private static void printResults(ArrayList<Double> conversionResults) {

        for (double item : conversionResults){
            System.out.println(getFormat(item));
        }
    }

    //    Ask user if another conversion is required
    private static boolean anotherRound() {

        while (true) {

            try {

                String answer = userInput.nextLine();


                if (answer.equalsIgnoreCase("Y")) {
                    return  true;

                } else if (answer.equalsIgnoreCase("N")) {
                    return false;

                } else {
                    System.out.println("Invalid Choice, please try again");
                    scannerInit();

                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Choice, please try again");
                scannerInit();

            }

        }

    }

    //     Set scanner to receive string for testing
    public static void setScannerInput(String string){
        userInput = new Scanner(string);
    }

    //    Write to file all the conversion results
    private static void writeToFile(ArrayList<Double> conversionResults) throws IOException {
        FileWriter myWriter = new FileWriter("results.txt");
        for (double item : conversionResults){
            String str = getFormat(item);
            myWriter.write(str+"\n");
        }
        myWriter.close();
    }

    //    Format result to look nice(tio decimal)
    private static String getFormat(double result) {
        DecimalFormat df = new DecimalFormat("###.##");
        return df.format(result);
    }

    //    Opens the results.txt  file
    public static void OpenAFile()
    {
        try
        {
//constructor of file class having file as argument
            File file = new File("results.txt");
            Desktop desktop = Desktop.getDesktop();

                desktop.open(file);              //opens the specified file
        }
        catch(IllegalArgumentException | IOException e )
        {
            System.out.println("\n\nSorry results.txt file is missing");
        }
    }


    public static  ArrayList<Double> conversionResultList = new ArrayList<>();


    public static void main(String[] strings) throws IOException {


    // Print Introduction screen for the user(First screen)
        System.out.println("\nWelcome to currency converter\n");

    //  Iterator for main program loop
        boolean iterator = true;

        while (iterator) {

        System.out.println(
                "\nPlease choose an option (1/2/3):\n" +
                        "1. Dollars to Shekels\n" +
                        "2. Shekels to Dollars\n" +
                        "3.Shekels to Euros\n");

//     Calculate result of currency conversion and show to user
        double result = getUserCurrency().calculate(getUserAmount());

//      Print result for the user(Third screen)
        System.out.println("Result of the conversion:  " + getFormat(result));

//      Store result of conversion in ArrayList
        conversionResultList.add(result);

//      Ask user to make another conversion
        System.out.println("\n\nPlease choose if you would like to make another conversion\n Y / N.");

//      Get answer from user
        iterator = anotherRound();
}

        System.out.println("\nThanks for using our currency converter\n"); // Print final message for the user

//      Print the array of results
        printResults(conversionResultList);

//      Write all results to file
        writeToFile(conversionResultList);

//      Open the results.txt file
        OpenAFile();



    }




}


