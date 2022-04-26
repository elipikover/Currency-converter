package Coins;

public class EUR extends Coin {

    private final double EURRate = 4.23;

    @Override
    double getValue() {
        return EURRate;
    }

    @Override
    public double calculate(double amountTocalculate) throws NullPointerException {
        return amountTocalculate/EURRate;
    }
}

