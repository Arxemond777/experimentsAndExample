package ch6_relations_beetwen_classes;

public class Clazz {

    Clazz(int param) {

    }

    public static void main(String[] args) {
        //new Clazz(1) { }; // правильное создание анонимного класса
        Arr arr = new Arr(2);
        System.out.println(arr.getI());

        Arr getAnonimusArr = arr.getAnonimusArr(3);
        System.out.println(getAnonimusArr.getI());
    }
}

class Arr {

    int i;

    Arr(int i) {
        this.i = i;
    }

    Arr getAnonimusArr(int j) {
        return new Arr(j);
    }

    int getI() {
        return i;
    }

}