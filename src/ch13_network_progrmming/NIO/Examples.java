package ch13_network_progrmming.NIO;

import java.io.*;
import java.nio.channels.*;
import java.util.*;

public class Examples
{
    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
        while (selector.select(50) == 0) {
            Set readySelect = selector.selectedKeys();
            for (Iterator it = readySelect.iterator(); it.hasNext();) {
                SelectionKey key = (SelectionKey) it.next();
                System.out.println(key);
            }
        }
    }
}
