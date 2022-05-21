package Coins;

import utilities.API;

import java.io.IOException;

public class ILS extends Coin {
    API api = new API();
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
