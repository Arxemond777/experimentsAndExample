import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayesWithCollections {
    public static void main(String[] args) {
        Aaa aaa2 = new Aaa();
        aaa2.setId(2L);

        Aaa aaa10 = new Aaa();
        aaa10.setId(10L);

        Aaa aaa4 = new Aaa();
        aaa4.setId(4L);

        Aaa aaa1 = new Aaa();
        aaa1.setId(1L);

        List<Aaa> l = Arrays.asList(aaa2, aaa10, aaa4, aaa1);

        System.out.println(l);

    }
}

class Aaa {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.valueOf(getId());
    }
}
