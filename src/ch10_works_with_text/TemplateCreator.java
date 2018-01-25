package ch10_works_with_text;

import java.util.*;
import java.util.regex.*;

public class TemplateCreator
{
    public static void main(String[] args) {
        String input = "<!-- TEMPLATE:name --> lives at" +
                "<!-- TEMPLATE:address -->";
        Template template = new Template();
        template.set("name", "Bob");
        template.set("address", "1234 Main St.");
        String output = template.fillIn(input);

        System.out.println(output);

        String templateText =
                "<html><head>\n"+
                        "<body>\n"+
                        "This is some text.\n"+
                        "<!-- TEMPLATE:foo  -->\n"+
                        "Some more text.\n"+
                        "\n"+
                        "<!--template:bar This is text -->\n"+
                        "More text.\n"+
                        "<!-- TEMPLATE:bar \n"+
                        "-->\n"+
                        "</body></html>\n";

        Template templateNew = new Template();
        templateNew.set( "foo", "FooTemplate");
        templateNew.set( "bar", "BarTemplate");
        System.out.println( templateText );
        System.out.println( templateNew.fillIn(templateText) );
    }
}

class Template
{
    Properties values = new Properties();
    Pattern templateComment =
            Pattern.compile("(?si)<!--\\s*TEMPLATE:(\\w+).*?-->");

    public void set(String name, String value) {
        values.setProperty(name, value);
    }

    public String fillIn(String text) {
        Matcher matcher = templateComment.matcher(text);
        StringBuffer buffer = new StringBuffer();
        while (matcher.find()) {
            String name = matcher.group(1);
            String value = values.getProperty(name);
            matcher.appendReplacement(buffer, value);
        }
        matcher.appendTail(buffer);
        return buffer.toString();
    }

}
