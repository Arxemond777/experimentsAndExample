package ch10_works_with_text;

import java.util.*;

public class Message_it_IT extends ListResourceBundle {
    public Object [][] getContents() {
        return contents;
    }

    static final Object [][] contents = {
        {"HelloMessage", "Italian HelloMessage"},
        {"OtherMessage", 123 + "Other Message"}
    };
}
