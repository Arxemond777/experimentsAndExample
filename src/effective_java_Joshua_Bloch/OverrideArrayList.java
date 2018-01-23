package effective_java_Joshua_Bloch;

import java.util.ArrayList;

public class OverrideArrayList<E> extends ArrayList<E> {

    public Integer myIndexOf(int i) {
        return super.indexOf(i);
    }
}
