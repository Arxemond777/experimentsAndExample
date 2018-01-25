package ch_24_XML.page_1124_SAX;

import org.xml.sax.*;

import javax.xml.parsers.*;
import java.beans.XMLEncoder;

public class TestSAXModelBuilder
{
    public static void main(String[] args) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        factory.setValidating(true); // Use DTD if present

        SAXParser saxParser = factory.newSAXParser();
        XMLReader parser = saxParser.getXMLReader();
        SAXModelBuilder mb = new SAXModelBuilder();
        parser.setContentHandler(mb);

        parser.parse(new InputSource("/Users/urijglusenkov/InteliJ/HelloWorld/src/ch_24_XML/xml/page_1124_zooinventory.xml"));
        Inventory inventory = (Inventory) mb.getModel();
        System.out.println("Animals = " + inventory.animal);
        Animal1 cocoa = (Animal1) (inventory.animal.get(1));
        FoodRecipe recipe = cocoa.foodRecipe;
        System.out.println("Recipe = " + recipe);

        XMLEncoder xmle = new XMLEncoder(System.out);
        xmle.writeObject(inventory);
        xmle.close();
    }
}

