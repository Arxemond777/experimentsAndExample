package _a;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample
{
    public static void main(String[] args) {
        CustomObject e1 = new CustomObject();
        CustomObject e2 = new CustomObject();

        e1.setId(100);
        e2.setId(100);

        System.out.println(e1.equals(e2));
        System.out.println(e1 == e2);
        System.out.println(e1.hashCode() + " == " + e2.hashCode());

        Map<CustomObject, String> map = new HashMap<>();
        map.put(e1, "e1");
        map.put(e2, "e2"); // Заместится е1, тк переопределен hashCode

        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }
    }
}

class CustomObject
{

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + getId();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (getClass() != o.getClass()) {
            return false;
        }

        CustomObject e = (CustomObject) o;
        return (this.getId() == e.getId());

    }

}
