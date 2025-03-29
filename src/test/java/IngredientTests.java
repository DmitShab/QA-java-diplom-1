import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTests {
    Ingredient ingredient;

    static TestData testData = new TestData();

    private final IngredientType type;
    private final String name;
    private final float price;


    public IngredientTests(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {IngredientType.SAUCE, testData.generateRandomName(), testData.generateRandomPrice()},
                {IngredientType.FILLING, testData.generateRandomName(), testData.generateRandomPrice()},
        };
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(type, name, price);
    }
    @Test
    public void getNameShouldReturnName(){
        Assert.assertEquals(name, ingredient.getName());
    }
    @Test
    public void getTypeShouldReturnType(){
        Assert.assertEquals(type, ingredient.getType());
    }
    @Test
    public void getPriceShouldReturnPrice(){
        Assert.assertEquals(price, ingredient.getPrice(), 0);
    }
}
