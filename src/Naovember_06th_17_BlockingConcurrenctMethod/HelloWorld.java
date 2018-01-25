package Naovember_06th_17_BlockingConcurrenctMethod;

public class HelloWorld {
    private Inner inner;

    public HelloWorld() {
        inner = new Inner();
    }

    private class Inner { // // HelloWorld$1
    }

    public static void main(String[] args) {
        Inner inner = new HelloWorld().new Inner();

//        new Object() {
//            public String toString() {
//                return "77";
//            }
//        }; // Analogue {@class Naovember_06th_17_BlockingConcurrenctMethod.HelloWorld} HelloWorld$1
    }

}

