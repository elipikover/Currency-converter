package Coins;

import utilities.API;

import java.io.IOException;

public class EUR extends Coin {
    API api = new API();
    public double EURRate;
    {
        try {
            EURRate = api.getCurrencyConversionRestApi("ILS_EUR");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    double getValue() {
        return EURRate;
    }

    @Override
    public double calculate(double amountTocalculate) throws NullPointerException {
        return amountTocalculate*EURRate;
    }
}

