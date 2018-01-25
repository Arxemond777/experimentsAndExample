package ch_24_XML.page_1159_JAXB;

import java.util.*;

public class FoodRecipe
{
    public String name;
    public List<String> ingredient = new ArrayList<String>();

    public String toString() {
        return name + ": " + ingredient.toString();
    }
}
