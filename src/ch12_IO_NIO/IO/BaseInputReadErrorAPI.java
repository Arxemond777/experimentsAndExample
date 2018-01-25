package ch12_IO_NIO.IO;

import java.io.*;
import java.text.NumberFormat;
import java.text.ParseException;

public class BaseInputReadErrorAPI
{
    public static void main(String[] args) {
        /*System.out.println(true && false | true);
        System.out.println(true && false || true);*/
//        A();
//        B();
//        C();
//        D();
//        E();
//        F();
//        G();
        H();
    }

    static void A() {
        System.out.println("Enter charset");
        try {
            int val;
            while ((val = System.in.read()) != -1) {
                System.out.println((byte) val);
            }

            //System.exit(200);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    static void B() {
        byte[] b = new byte[1024];
        try {
            int got = System.in.read(b);
            System.out.println(got);
        } catch (IOException e) {

        } finally {
            try {
                System.in.close();
            } catch (IOException e) {
            }
        }
    }

    static void C() {
        try {
            int sizeArray = System.in.available();
            if (sizeArray > 0) { //Для файлов, но не для всего
                byte[] b = new byte[sizeArray];
                int info = System.in.read(b);
                System.out.println(info);
            }
        } catch (IOException e) {
        }

    }

    static void D() {
        try {
            System.out.println("Введите ЧИСЛО");

            InputStream in = System.in;
            InputStreamReader inReader = new InputStreamReader(in, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inReader);
            String line = bufferedReader.readLine();
//            byte b = NumberFormat.getInstance().parse(line).byteValue();//конверт из числа в байты
            int i = NumberFormat.getInstance().parse(line).byteValue();//из байт в число
            System.out.println(i);
        } catch (IOException e) {
            System.out.println(e);
        } catch (ParseException ee) {
            System.out.println(ee);
        }
    }

    static void E() {
        /**
         * BufferedInputStream - накапливает данные в буфер позволяя не обращаться
         * каждый раз к устройству ввода
         */
        System.out.println("Enter data: ");
        InputStream inputStream = new BufferedInputStream(System.in);
        System.out.print(inputStream);
    }

    static void F() {
        System.out.println("Enter data: ");

        System.out.println(Runtime.getRuntime().maxMemory() + " / " + Runtime.getRuntime().freeMemory());
        try {
            DataInputStream dis = new DataInputStream(System.in);
            double d = dis.readDouble();

            BufferedInputStream bis = new BufferedInputStream(dis, 32768);
            System.out.println(d);
            System.out.println(bis.read());
            System.out.println(Runtime.getRuntime().maxMemory() + " / " + Runtime.getRuntime().freeMemory());
        } catch (IOException e) {

        }
    }

    static void G() {
        String text = "Hello world!";
        byte[] buffer = text.getBytes();
        ByteArrayInputStream in = new ByteArrayInputStream(buffer);

        try(BufferedInputStream bis = new BufferedInputStream(in, 32768)){

            int c;
            while((c=bis.read())!=-1){

                System.out.print((char)c);
            }
        }
        catch(Exception e){

            System.out.println(e.getMessage());
        }
    }

    static void H() {
        PrintWriter pr = new PrintWriter(System.out, true);
        pr.println(1);
    }
}
