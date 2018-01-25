package ch12_IO_NIO.IO;

//import org.apache.commons.io.IOUtils;
import java.io.*;

import static java.io.File.separator;

public class StreamReadWriteFile
{
    public static void main(String[] args) {
//        StreamReadWriteFile.A();
//        StreamReadWriteFile.B(args[0]);
//        StreamReadWriteFile.C(System.in);
        StreamReadWriteFile.D(System.in);
    }

    static void A() {

        String path = separator + "tmp" + separator + "log.log";
        File file = new File(path);

        if (!file.exists() | !file.canRead()) {
            System.out.println("file do not available");
            return;
        }

        try (FileInputStream fis = new FileInputStream(file)) {
            System.out.println(fis.available() + " " + file.length());

            InputStreamReader isr = new InputStreamReader(fis);

            int s;
            while ((s = isr.read()) != -1) {
                char thisChar = (char) s;
                System.out.println(thisChar);
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    static void B(String args) {
        File file = new File(args);

        if (!file.exists() || !file.canRead()) {
            System.out.println("Can't read " + file);
            return;
        }

        if (file.isDirectory()) {
            //Если не указал файл
            String[] files = file.list();
            for (int i = 0; i < files.length; i++)
                System.out.println(files[i]);
        } else
            try {
                //В буффер записал вывод из чтения new InputStreamReader(new FileInputStream и потом прочитал
                Reader ir = new InputStreamReader(new FileInputStream(file));
                BufferedReader in = new BufferedReader(ir);
                String line;
                while ((line = in.readLine()) != null)
                    System.out.println(line);
            } catch (FileNotFoundException e) {
                System.out.println("File Disappeared");
            } catch (IOException e) {
                System.out.println(e);
            }
    }

    /** Полностью окрытие файла, получения данных, запись, и вывод реза. P.S. лучшая версия записи в методе StreamReadWriteFile.D() */
    static void C(InputStream is) {
        String path = "/tmp/log.log";
        System.out.println("Enter entry for read in " + path);
        File f = new File(path);

        /** значение true в FileOutputStream говорит, чтоб append-ить в конец, иначе перезатер*/
        try (FileOutputStream fos = new FileOutputStream(f, true)) { //Открывает для записи потока char
            /** Подготовка к записи */
            OutputStreamWriter osw = new OutputStreamWriter(fos); //Переводим в буфер строки данные из файла

            /** Считывание поступающих данных */
//            IOUtils.copy(is, writer, "UTF-8"); //Надо разобраться с импортом https://commons.apache.org/proper/commons-io/javadocs/api-release/org/apache/commons/io/IOUtils.html
            String str = new BufferedReader(new InputStreamReader(is)).readLine(); //Считали данные из InputStream
            osw.write(System.getProperty("line.separator") + str);
            osw.close();

            /** Читаем, что получилось */
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
            String s;
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    static void D(InputStream is) { //Более простая запись, чем через StreamReadWriteFile.C() через FileOutputStream
        try {
            String s = new BufferedReader(new InputStreamReader(is)).readLine();
            File out = new File(separator + "tmp" + separator + "log.log");
            FileWriter fw = new FileWriter(out);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(s);
            pw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
