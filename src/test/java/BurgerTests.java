import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTests {
    TestData testData = new TestData();

    String bunName = testData.generateRandomName();
    String ingredientName = testData.generateRandomName();
    float bunPrice = testData.generateRandomPrice();
    float ingredientPrice = testData.generateRandomPrice();

    private Burger burger;


    @Mock
    Ingredient ingredient;
    @Mock
    Bun bun;

    @Before
    public void setUp() {
        burger = new Burger();
        burger.setBuns(bun);
    }

    @Test
    public void addIngredientShouldBeAddedToList() {
        burger.addIngredient(ingredient);
        Assert.assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientShouldBeRemovedFromList() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        MatcherAssert.assertThat(burger.ingredients, is(empty()));
    }

    @Test
    public void getPriceShouldReturnPrice() {
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        Assert.assertEquals(bunPrice * 2 + ingredientPrice * 2, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptShouldReturnString() {
        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn(ingredientName);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        StringBuilder expected = new StringBuilder(String.format("(==== %s ====)%n", bunName));
        expected.append(String.format("= %s %s =%n", IngredientType.SAUCE.toString().toLowerCase(),
                ingredientName));
        expected.append(String.format("= %s %s =%n", IngredientType.SAUCE.toString().toLowerCase(),
                ingredientName));
        expected.append(String.format("(==== %s ====)%n", bunName));
        expected.append(String.format("%nPrice: %f%n", bunPrice * 2 + ingredientPrice * 2));
        Assert.assertEquals(expected.toString(), burger.getReceipt());


//        "(==== BunName ====)%n= IngType IngName =%n(==== BunName ====)%n%nPrice: price%n"

    }
}
