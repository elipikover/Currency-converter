package utilities;

import Coins.Coin;
import Coins.EUR;
import Coins.ILS;
import Coins.USD;

public class CoinFactory {


    public Coin getCoins(CoinsEnum coin) {
        switch (coin) {
            case ILS:
                Constants.Symbol  = "$";
                return new ILS();
            case USD:
                Constants.Symbol = "₪";
                return new USD();
            case EUR:
                Constants.Symbol  = "€";
                return new EUR();
            default:
                return null;
        }

    }

}