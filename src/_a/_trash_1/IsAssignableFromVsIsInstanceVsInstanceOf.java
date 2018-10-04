package _a._trash_1;

public class IsAssignableFromVsIsInstanceVsInstanceOf {
    public static void main(String[] args) {
        Class<bbbb> bbbbClass = bbbb.class;
        Class<aaa> aaaClass = aaa.class;

        aaa aaa = new aaa();
        ccc ccc = new ccc();
        System.out.println(aaa instanceof bbbb);
        System.out.println(bbbbClass.isAssignableFrom(bbbb.class));

        System.out.println("___only instance__");
        System.out.println(bbbbClass.isInstance(aaa.class));
        System.out.println(bbbbClass.isInstance(bbbb.class));
        System.out.println(aaaClass.isInstance(aaaClass));
        System.out.println(aaaClass.isInstance(aaa));
        System.out.println(aaaClass.isInstance(ccc));
    }
}

class ccc extends aaa {

}

class aaa implements bbbb {

}

interface bbbb {}