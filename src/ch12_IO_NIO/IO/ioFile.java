package ch12_IO_NIO.IO;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ioFile
{
    public static void main(String[] args) {
        Integer [] i = new Integer[] {1, 2, 3};
        List<Integer> iList = Arrays.asList(i);
        System.out.println(Arrays.asList(iList));

//        ioFile.D();
    }

    static void A() {
        String path = System.getProperty("user.dir").replace("/", File.separator);
        File tmpFile = new File(path), file = new File(tmpFile, "foo.txt");

        System.out.println(file.exists());
    }

    static void B() {
        String[] path = {"mail", "foo"};
        StringBuffer sb = new StringBuffer();

        for (String s : path)
            sb.append(File.separator + s);

        System.out.println(sb.toString());
        System.out.println(Arrays.toString(File.listRoots()));//корневые точки системы
    }

    static void C() {
        File file = new File("/var/www/html");
        try {
            System.out.println(file.getCanonicalPath());
            System.out.println(file.lastModified() + " long");//setLastModified
            System.out.println((file.length() / 8) + " bit");
            System.out.println(file.isDirectory() ? "Directory" : "File");

            File[] f = file.listFiles();
            System.out.println(Arrays.toString(f));
            List<File> tempList = Arrays.asList(f);
            Collections.sort(tempList);
            System.out.println(Arrays.asList(tempList));


            File fs = new File("/tmp", "wifi-zSuCKI.log");
            String[] s = fs.list();
            System.out.println(Arrays.toString(s));


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    static void D() {
        String path = "/tmp/lalala/";
        String newPath = "/tmp/la2";
        boolean b = new File(path).mkdirs();//mkdirs = mkdir -p можно просто mkdir
        boolean newB = new File(path).renameTo(new File(newPath));
        boolean delB = new File(newPath).delete();
        System.out.println("Free: " + new File("/").getFreeSpace());
        System.out.println(delB);
        System.out.println(new File(path).toURI());
        try {
            File file = new File("/tmp/log1.log");
            file.getParentFile().mkdirs(); //Убеждаемся, что есть
            file.createNewFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        //createNewFile - атомарный
        //deleteOnExist - удаление по завершению
        //createTempFile - создает файлы в спец директории используя уникальные имена, используется с deleteOnExist
        //toURI преобразовывает к формату URI
    }
}
