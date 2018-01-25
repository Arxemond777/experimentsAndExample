package _a;

public class WideBoxing
{
        static void methodWide(int i) {
            System.out.println("int");
        }

        static void methodWide(Integer i) {
            System.out.println("Integer");
        }

        public static void main(String[] args) {
            short shVal = 25;
            methodWide(shVal);
        }

}
