package Coins;

import utilities.conversionRatioAPI;

import java.io.IOException;

public class ILS extends Coin {
    conversionRatioAPI api = new conversionRatioAPI();
    public double ILSRate;
    {
        try {
            ILSRate = api.getCurrencyConversionRestApi("ILS_USD");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    double getValue( ) {
        return ILSRate;
    }

    @Override
    public double calculate(double amountTocalculate) throws NullPointerException{
        return amountTocalculate*ILSRate;
    }
}
