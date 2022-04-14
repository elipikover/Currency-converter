package Coins;

public class ILS extends Coin {
    @Override
    double getValue( ) {
        final double ILSRate = 0.28;
        return ILSRate;
    }
}
