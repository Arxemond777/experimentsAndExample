package ch7_works_with_class;

interface TypeWriter {
    void typeLine(String s);
}

public class MyAplication {

    public static void main(String [] args) {
        Midleware m = new Midleware();
        m.A();

    }
}

class Midleware {

    void A() {
        String outputDevice = "ch7_works_with_class.Printer";
        Class p = outputDevice.getClass();

        try {
//            System.out.println(outputDevice);
            Class newClass = Class.forName(outputDevice);
//            System.out.println(outputDevice);
            TypeWriter device = (TypeWriter)newClass.newInstance();

            System.out.println(device);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e.getMessage() + " Exception");
        }
    }
}

class Printer implements TypeWriter {

    public void typeLine(String s) {
        System.out.println(s);
    }

    public String toString() {
        return "A";
    }
}
