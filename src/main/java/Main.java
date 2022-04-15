import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;
import Coins.*;


public class Main {

    public static void main(String[] args) {
        Coin selection = null;
        double amountToCalculate = 0;
        DecimalFormat df = new DecimalFormat("###.#");

// Print Introduction screen for the user(instructions

        System.out.println("Welcome to currency converter”\n");

        System.out.println(
                        "“Please choose an option (1/2):”\n" +
                        "1. Dollars to Shekels”\n" +
                        "2. Shekels to Dollars");

//Get user selection of currency to convert

        try {
            selection = getUserCurrency();

        } catch (InputMismatchException e) {
            System.out.println("Invalid Choice, please try again");
        }

//Get user amount to convert

        try {
            amountToCalculate = getUserAmount();

        } catch (InputMismatchException e) {
            System.out.println("Invalid Choice, please try again");
        }
        double result = selection.calculate(amountToCalculate);

        System.out.println("Result of the conversion:  "+df.format(result));
    }

//    method that takes user selection of currency to convert and returns selected Coin Object ILS or USD

    private static Coin getUserCurrency() throws InputMismatchException {

        Scanner userInput = new Scanner(System.in);
        int operator = Integer.valueOf(userInput.nextInt());

        CoinFactory coin = new CoinFactory();

        if (operator == 1) {
            return coin.getCoins(CoinsEnum.USD);

        } else if (operator == 2) {
            return coin.getCoins(CoinsEnum.ILS);

        } else return null;
    }


//    method that takes from user amount to convert and returns as double

    private static double getUserAmount() throws InputMismatchException{
        System.out.println("Please enter an amount to convert");
        Scanner userInput = new Scanner(System.in);
        return  userInput.nextDouble();

    }

}


