package ch_24_XML.page_1124_SAX;

public class Animal1
{
    public static enum AnimalClass
    {
        mammal, reptile, bird, fish, amphibian, invertebrate
    }

    public AnimalClass animalClass;
    public String name, species, habitat, food, temperament;
    public Double weight;
    public FoodRecipe foodRecipe;

    @Override
    public String toString() {
        return name + "(" + animalClass + ", " + species +")";
    }
}
