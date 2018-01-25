package ch_24_XML.page_1124_SAX;

import java.util.ArrayList;
import java.util.List;

public class FoodRecipe
{
    public String name;
    public List<String> ingredient = new ArrayList<>();

    @Override
    public String toString() {
        return name + ": " + ingredient.toString();
    }
}
