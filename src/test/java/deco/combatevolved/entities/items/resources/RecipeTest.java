package deco.combatevolved.entities.items.resources;

import deco.combatevolved.entities.items.Item;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class RecipeTest {

    private List<String> grenadeRecipe = new ArrayList<>();
    private Recipes recipes = new Recipes();

    @Before
    public void setup() {
        String zero = "0";
        String mentos = "mentos";
        String bronze = "bronze";
        String cola = "cola";

        grenadeRecipe.add(zero);
        grenadeRecipe.add(mentos);
        grenadeRecipe.add(zero);
        grenadeRecipe.add(zero);
        grenadeRecipe.add(mentos);
        grenadeRecipe.add(zero);
        grenadeRecipe.add(bronze);
        grenadeRecipe.add(cola);
        grenadeRecipe.add(bronze);
    }

    @Test
    public void testIsEntry() {
        assertTrue(recipes.isEntry(grenadeRecipe));
    }

    @Test
    public void testInvalidIsEntry() {
        List<String> falseItem = new ArrayList<>();
        falseItem.add("zero");
        falseItem.add("zero");
        falseItem.add("zero");
        falseItem.add("zero");
        falseItem.add("zero");
        falseItem.add("zero");
        falseItem.add("zero");
        falseItem.add("zero");

        assertFalse(recipes.isEntry(falseItem));
    }

    @Test
    public void testRecipeMap() {
        assertTrue(recipes.recipeMap().containsKey(grenadeRecipe));
    }

    @Test
    public void testGetCraftedItem() {
        Item grenade = new Item("Grenade", 4);
        assertEquals(grenade, recipes.getCraftedItem(grenadeRecipe));

    }

    @Test
    public void testInvalidGetCraftedItem() {
        List<String> falseItem = new ArrayList<>();
        falseItem.add("zero");
        falseItem.add("zero");
        falseItem.add("zero");
        falseItem.add("zero");
        falseItem.add("zero");
        falseItem.add("zero");
        falseItem.add("zero");
        falseItem.add("zero");

        assertNull(recipes.getCraftedItem(falseItem));
    }
}
