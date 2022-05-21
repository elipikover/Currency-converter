package Coins;

import utilities.API;

import java.io.IOException;

public class USD extends Coin {
    API api = new API();
    public double USDRate;
    {
        try {
            USDRate = api.getCurrencyConversionRestApi("USD_ILS");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    double getValue() {
        return USDRate;
    }

    @Override
    public double calculate(double amountTocalculate) throws NullPointerException {
        return amountTocalculate*USDRate;
    }
}

