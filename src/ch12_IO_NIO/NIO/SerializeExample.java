package ch12_IO_NIO.NIO;

import java.io.*;
import java.util.*;

public class SerializeExample implements Serializable
{
    public static void main(String[] args) {
        Save save = new Save();
        save.save();

        Load load = new Load();
        load.load();
    }
}

class Save
{
    public static void save() {
        Hashtable hash = new Hashtable();
        hash.put("string", "Gabriel");
        hash.put("int", new Integer(26));
        hash.put("double", new Double(Math.PI));

        try {
            FileOutputStream fileOut = new FileOutputStream("hash.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            System.out.println("Before serialize: " + hash.hashCode());
            out.writeObject(hash);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Load
{
    public static void load() {
        try {
            FileInputStream fileIn = new FileInputStream("hash.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Hashtable hash = (Hashtable) in.readObject();
            System.out.println(hash.toString());
            System.out.println("After serialize: " + hash.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
