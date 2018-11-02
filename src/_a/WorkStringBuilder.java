package _a;

public class WorkStringBuilder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("a");

        System.out.println(sb.toString());

        sb.append("2");

        System.out.println(sb.toString());
    }
}
