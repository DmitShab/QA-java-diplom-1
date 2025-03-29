import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

public class BunTests {
    private Bun bun;
    TestData testData = new TestData();
    String name = testData.generateRandomName();
    float price = testData.generateRandomPrice();

    @Before
    public void setUp() {
        bun = new Bun(name, price);
    }

    @Test
    public void getNameShouldReturnValue() {
        Assert.assertEquals(name, bun.getName());
    }

    @Test
    public void getPriceShouldReturnValue() {
        Assert.assertEquals(price, bun.getPrice(), 0);
    }

}
