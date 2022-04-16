package Coins;

public class ILS extends Coin {

    private final double ILSRate = 0.28;

    @Override
    double getValue( ) {
        return ILSRate;
    }

    @Override
    public double calculate(double amountTocalculate) throws NullPointerException{
        return amountTocalculate*ILSRate;
    }
}
