package test;

import javax.swing.*;
/**
 * Created by urijglusenkov on 22.11.16.
 */
public class Test {

    public static void main (String [] args) {
        JFrame jframe = new JFrame("Test");
        JLabel jlable = new JLabel("Test", JLabel.CENTER);
        jframe.getContentPane().add(jlable);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(300, 300);
        jframe.setVisible(true);

    }

}
