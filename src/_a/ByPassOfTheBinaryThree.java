package _a;

import org.omg.CORBA.Object;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

public class ByPassOfTheBinaryThree {
    static Node parent;

    static {
        parent = new Node(null, 5);

        //
        Node left_1_1 = new Node(parent, 3);
        parent.left = left_1_1;

        Node left_2_1 = new Node(left_1_1, 2);
        left_1_1.left = left_2_1;
        Node right_2_1 = new Node(left_1_1, 4);
        left_1_1.right = right_2_1;

        //
        Node right_1_2 = new Node(parent, 7);
        parent.right = right_1_2;

        Node left_2_2 = new Node(right_1_2, 6);
        right_1_2.left = left_2_2;

        Node right_2_2 = new Node(right_1_2, 8);
        right_1_2.right = right_2_2;
    }

    public static void main(String[] args) {
        verticalByPass(ByPassOfTheBinaryThree.parent);
        System.out.println("_____");
        horizontalByPassQueue(ByPassOfTheBinaryThree.parent);
        System.out.println("_____");
        contPreOrder(ByPassOfTheBinaryThree.parent);
    }

    static void verticalByPass(Node p) {
        System.out.println(p.value);
        if (Objects.nonNull(p.left)) verticalByPass(p.left);
        if (Objects.nonNull(p.right)) verticalByPass(p.right);
    }

    static void horizontalByPassQueue(Node top) {
        Queue<Node> queue = new LinkedList<>();
        do {
            // the first step forever Null
            if (!queue.isEmpty()) top = queue.poll();

            System.out.println(top.value);
            if (top.left != null) queue.add(top.left);
            if (top.right != null) queue.add(top.right);
        } while (!queue.isEmpty());
    }

    static void contPreOrder(Node top){
        Stack<Node> stack = new Stack<>();
        while (top!=null || !stack.empty()){
            if (!stack.empty()){
                top=stack.pop();
            }
            while (top!=null){
                System.out.println(top.value);
                if (top.right!=null) stack.push(top.right);
                top=top.left;
            }
        }
    }

}

class Node {
    Node left, right, parent;
    Integer value;

    Node(Node parent, Integer value) {
        this.parent = parent;
        this.value = value;
    }

    /*@Override
    public String toString() {
        return
        "left :" + left +
        "right :" + right +
        "parent :" + parent +
        "value :" + value;
    }*/
}