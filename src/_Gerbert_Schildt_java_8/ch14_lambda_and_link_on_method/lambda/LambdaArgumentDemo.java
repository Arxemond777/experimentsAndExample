package _Gerbert_Schildt_java_8.ch14_lambda_and_link_on_method.lambda;

@FunctionalInterface
interface StringFunc {
    String func(String str);
}

public class LambdaArgumentDemo
{
    static String changeStr(StringFunc sf, String s) {
        return sf.func(s);
    }

    public static void main(String[] args) {
        String
                inStr = "inStr foo",
                outStr;

        System.out.println("IN String: " + inStr);

        StringFunc reverse = (str) -> {
          String result = "";
          for (int i = str.length()-1; i >= 0; i--)
              result += str.charAt(i);

          return result;
        };

        outStr = changeStr(reverse, inStr);
        System.out.println("Reverse: " + outStr);

        outStr = changeStr((str -> str.replace(' ', '-')), inStr);
        System.out.println("without space: " + outStr);

        outStr = changeStr(str -> {
            String result = "";
            char ch;

            for (int i = 0; i < str.length(); i++){
                ch = str.charAt(i);
                if (Character.isUpperCase(ch))
                    result += Character.toLowerCase(ch);
                else
                    result += Character.toUpperCase(ch);
            }
            return result;
        }, inStr);

        System.out.println("Change: " + outStr);
    }
}
