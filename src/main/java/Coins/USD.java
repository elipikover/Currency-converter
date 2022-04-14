package Coins;

public class USD extends Coin{

    @Override
    double getValue() {
        final double USDRate = 3.52;
        return USDRate;
    }

}
