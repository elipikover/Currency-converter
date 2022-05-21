import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class BaseTest {

        @BeforeTest
        public void BeforeTest(){

                CurrencyConverterMain.isTest = true;
        }


@Test
        public void conversionValueTestUSDtoILS() throws IOException {
        CurrencyConverterMain.setScannerInput("1\n10\nN\n");
        CurrencyConverterMain.main(new String[0]);
        int value = CurrencyConverterMain.conversionResultList.get(0).intValue();
        conversionRatioAPI ratio = new conversionRatioAPI();
        int expectedResult = (int) (10*ratio.getCurrencyConversionRestApi("USD_ILS"));
        Assert.assertEquals(expectedResult, value);

        }

}
