package ch_24_XML.page_1137_JDOM;

import org.jdom2.*;
import org.jdom2.input.*;
import org.jdom2.output.*;
import java.util.*;

public class TestJDOM
{
    public static void main(String[] args) throws Exception {
        Document document = new SAXBuilder().build("src/ch_24_XML/xml/page_1124_zooinventory.xml");
        List animals = document.getRootElement().getChildren("animal");
        System.out.println("Animals = ");
        for (int i = 0; i < animals.size(); i++){
            String name = ((Element)animals.get(i)).getChildText("name");
            String species = ((Element)animals.get(i)).getChildText("species");
            System.out.println(name + " (" + species + ")");
        }

        Element foodRecipe = ((Element)animals.get(1)).getChild("foodRecipe");
        String name = foodRecipe.getChildText("name");
        System.out.println("Recipe = " + name);
        List ingredients = foodRecipe.getChildren("ingredient");
        for (int i = 0; i < ingredients.size(); i++){
            System.out.println(((Element)ingredients.get(i)).getText());
        }
    }
}
