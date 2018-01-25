package ch11_main_tools;

import java.io.*;
import java.util.*;

public class WordSort
{
    public static void main(String[] args) {

        if (args.length < 2) {
            System.out.println("Используйте входящий и исходящий файл");
            return;
        }

        String inputFile = args[0], outPutFile = args[1];
        Map<String, Integer> map = new TreeMap<>();

        try {
            Scanner scanner = new Scanner(new File(inputFile));
            System.out.println(scanner.hasNext());
            while (scanner.hasNext()) {
                String world = scanner.next();
                Integer count = map.get(world);
                count = (count == null ? 1 : count++);
                map.put(world, count);

            }
            scanner.close();

            List<String> keys = new ArrayList<>(map.keySet());
            PrintWriter out = new PrintWriter(new FileWriter(outPutFile));
            for (String key : keys) {
                System.out.println(key + " : " + map.get(key));
                out.println(key + " : " + map.get(key));
            }
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException");
            System.out.println(e);
        } catch (IOException e) {
            System.out.println("IOException");
        }

    }
}

class TreeNode {

    final String name;
    final List<TreeNode> children;

    public TreeNode(String name, List<TreeNode> children) {
        this.name = name;
        this.children = children;
    }

    public void print() {
        print("", true);
    }

    private void print(String prefix, boolean isTail) {
        System.out.println(prefix + (isTail ? "└── " : "├── ") + name);
        for (int i = 0; i < children.size() - 1; i++) {
            children.get(i).print(prefix + (isTail ? "    " : "│   "), false);
        }
        if (children.size() > 0) {
            children.get(children.size() - 1)
                    .print(prefix + (isTail ?"    " : "│   "), true);
        }
    }
}