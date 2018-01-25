package ch6_relations_beetwen_classes;

import static java.lang.Math.*;

interface TextReceiver {
    void receiverText(String text);
}

class TextTape implements TextReceiver {

    @Override
    public void receiverText(String text) {
        System.out.print("Ticker:\n" + text + "\n");
    }

    protected int a = 666;
}

public class TextSource {

    int a;
    {
        if(a == 0) {
            a = 2;
        }
    }
    public static void main(String [] args) {
        TextSource ts = new TextSource(new TextTape());
        ts.sendText("xyi");

        System.out.println(ts.a);


        System.out.println(sin(1));

        TextTape tt = new TextTape();
        System.out.println(tt.a);

    }

    TextReceiver receiver;
    TextSource(TextReceiver r) {
        receiver = r;
    }

    public void sendText(String s) {
        receiver.receiverText(s);
        System.out.println(this.a);
    }

}
