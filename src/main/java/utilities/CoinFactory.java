package utilities;

import Coins.Coin;
import Coins.ILS;
import Coins.USD;

public class CoinFactory {


    public Coin getCoins(CoinsEnum coin) {

         if (coin.equals(CoinsEnum.ILS)) {
            return new ILS();

        } else if (coin.equals(CoinsEnum.USD)) {
            return new USD();

        } else return null;

    }

}