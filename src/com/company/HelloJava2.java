package com.company;

import java.awt.*; //GUI library
import java.awt.event.*; //Импорт пакета для работы с событиями, так как java.awt.* не импортирует внутренние пакеты
import javax.swing.*;

public class HelloJava2
{
    public static void main( String[] args ) {
        JFrame frame = new JFrame( "HelloJava2" );
        HelloComponent2 newObj = new HelloComponent2( args[0] );
        frame.add( newObj );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setSize( 300, 300 );
        frame.setVisible( true );
    }
}

class HelloComponent2 extends JComponent
        implements MouseMotionListener
{
    String theMessage;
    int messageX = 125, messageY = 95; // Coordinates of the message

    public HelloComponent2( String message ) {
        theMessage = message;
        addMouseMotionListener(this);
    }

    public void paintComponent( Graphics g ) {
        g.drawString(theMessage, messageX, messageY);
    }

    public void mouseDragged(MouseEvent e) {
        // Save the mouse coordinates and paint the message.
        System.out.printf("First Name: %s\nLast Name: %s",messageX, messageY);
        messageX = e.getX();
        messageY = e.getY();
        repaint();
    }

    public void mouseMoved(MouseEvent e) { }
}
