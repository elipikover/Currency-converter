import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class BaseTest {



@Test
        public void test01() throws IOException {
        Main.setScannerInput("1\n10\nN\n");
        Main.main(new String[0]);

        int value = Main.conversionResultList.get(0).intValue();
        Assert.assertEquals(35.0, value);

        }

}
