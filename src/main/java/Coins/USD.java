package Coins;

public class USD extends Coin {

    private final double USDRate = 3.52;

    @Override
    double getValue() {
        return USDRate;
    }

    @Override
    public double calculate(double amountTocalculate) {
        return amountTocalculate*USDRate;
    }
}

