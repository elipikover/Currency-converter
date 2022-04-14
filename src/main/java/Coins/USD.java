package Coins;

public class USD extends Coin {

    @Override
    double getValue() {
        final double USDRate = 3.52;
        return USDRate;
    }

    @Override
    public double calculate(double amountTocalculate) {
        double USDRate = this.getValue();
        return amountTocalculate*USDRate;
    }
}

