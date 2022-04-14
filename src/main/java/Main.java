import java.util.Scanner;
import Coins.ILS;
import Coins.USD;


public class Main {

    public  void main(String[] args) {

            String selection = getUserCurrency();
        double amountToCalculate = getUserAmount();
            calculate(selection, amountToCalculate);


    }

//    Get user input aka welcome screen
    public String getUserCurrency(){
        System.out.println(

                "Welcome to currency converter”\n" +
                        "“Please choose an option (1/2):”\n" +
                        "1. Dollars to Shekels”\n" +
                        "2. Shekels to Dollars");

        return  String.valueOf(new Scanner(System.in));
    }



    double getUserAmount(){
        System.out.println("Please enter an amount to convert");
        return  Double.valueOf(String.valueOf(new Scanner(System.in)));

    }


    double calculate(String selection, double amountToCalculate){

        if (selection == "1") {
            Coins selectedCoin = Coins.ILS;
                ILS x = new ILS();

                return x.calculate(amountToCalculate);
            }
        else if (selection == "2") { Coins selectedCoin = Coins.USD;
            USD x = new USD();
            return x.calculate(amountToCalculate);
        }
       else{
            throw new ArithmeticException("Incorrect Input") ;}
    }

}
