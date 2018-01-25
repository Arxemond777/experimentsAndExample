package com.company;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import java.util.Arrays;

/**
 * AWT состоит из “тяжелых компонентов”, имеющих в качестве peer системные компоненты. Swing – состоит из легких компонентов, построенных на основании базовых компонентов AWT.
 * Кроме этого, в Swing усовершенствована модель слушателей событий.
 * В данный момент Swing является основной библиотекой пользовательского интерфейса в Java. AWT - не дорабатывается.
 * Поэтому использование Swing - почти всегда предпочтительнее, за исключением тех случаев, когда нужна обратная совместимость с Java 1.
 */

public class HelloJava3 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("HelloJava3");
        frame.add(new HelloComponent3("Hello Java!"));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}

class HelloComponent3 extends JComponent
        implements MouseMotionListener, ActionListener {
    String theMessage;
    int messageX = 125, messageY = 90;

    JButton theButton;

    int colorIndex;

    final static Color customiseColor = new Color(1, 2, 3);
    final Random random = new Random();

    static Color[] someColors = {
            Color.black, Color.red, Color.green, Color.blue,
            Color.magenta, HelloComponent3.customiseColor
    };

    //static Color[] someColorsRandom = new ArrayList<Integer>();

    public HelloComponent3(String message) {
        //someColorsRandom.add(1);
        //System.out.println(Arrays.toString(someColors));
        //mInfoTextView // это массив
        //int randomColor = mInfoTextView.setText(String.valueOf(random.nextInt(6) + 1));



        theMessage = message;
        theButton = new JButton("Change Color");
        setLayout(new FlowLayout());
        add(theButton);
        theButton.addActionListener(this);
        addMouseMotionListener(this);
    }

    public void paintComponent(Graphics g) {
        g.drawString(theMessage, messageX, messageY);
    }

    public void mouseDragged(MouseEvent e) {
        messageX = e.getX();
        messageY = e.getY();
        repaint();
    }

    public void mouseMoved(MouseEvent e) {
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == theButton) changeColor();

    }

    synchronized private void changeColor() {
        if (++colorIndex == someColors.length)
            colorIndex = 0;

        setForeground(currentColor());
        repaint();
    }

    synchronized private Color currentColor() {
        return someColors[colorIndex];
    }
}
