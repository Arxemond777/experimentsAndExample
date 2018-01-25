package ch12_IO_NIO.NIO;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map;

public class BufferExample
{
    public static void main(String[] args) {
//        System.out.println(ByteOrder.nativeOrder()); //порядок следование размещения байт в буфере 627 стр
//        System.exit(1);
        BufferExample.A();
    }

    public static void A() {
        CharBuffer cbuf = CharBuffer.allocate(64 * 1024);

        //Прямой буффер - оптимизируют некоторые операции ввода/вывода.
        ByteBuffer bbuf = ByteBuffer.allocateDirect(64 * 1024);
        byte[] someArray = /*new byte[10]*/{1,2};
//        someArray[0] = 1;
        ByteBuffer bbuf1 = ByteBuffer.wrap(someArray);

        Map map = Charset.availableCharsets();
        Iterator it = map.keySet().iterator();
        while (it.hasNext())
            System.out.println(it.next());
    }
}
