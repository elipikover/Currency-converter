package utilities;

import Coins.Coin;
import Coins.ILS;
import Coins.USD;

public class CoinFactory {


    public Coin getCoins(CoinsEnum coin) {
        switch (coin) {
            case ILS:
                return new ILS();
            case USD:
                return new USD();
            default:
                return null;
        }

    }

}