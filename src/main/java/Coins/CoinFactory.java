package Coins;

public class CoinFactory {


    public static Coin getCoins(CoinsEnum coin) {

        if (coin.equals(null)) {
            return null;

        } else if (coin.equals(CoinsEnum.ILS)) {
            return new ILS();

        } else if (coin.equals(CoinsEnum.USD)) {
            return new USD();

        } else return null;

    }

}