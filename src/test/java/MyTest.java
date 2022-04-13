import org.testng.Assert;
import org.testng.annotations.Test;

public class MyTest {
    int x = 5;
    int y = 5;

    @Test
    public void test_a(){
        Assert.assertEquals(x,y);

    }

}
