package _a._trash_0;

import java.util.ArrayList;
import java.util.List;

public class GenericEraserExample
{
    
    public static void main(String[] args) {
        S123<Integer> s123 = new S123<>();
        S1234<Integer> s1234 = new S1234<>();

        List<? extends S123> s123s = new ArrayList<>();
    }
}

class S123<T> {
    
}

class S1234<T extends Number> {

}