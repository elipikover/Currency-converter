package Coins;

import utilities.conversionRatioAPI;

import java.io.IOException;

public class EUR extends Coin {
    conversionRatioAPI api = new conversionRatioAPI();
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

