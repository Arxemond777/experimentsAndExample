/**
 * com.company - пакет - пространство имен
 * имя класса должно соответствывать имени класса
 */

package com.company;

import javax.swing.*;

public class HelloJava
{
    public static void main( String[] args ) {
        JFrame frame = new JFrame( "HelloJava" );
        frame.add( new HelloComponent() ); //com.company.HelloComponent() вызываем из своего пакета
        frame.setSize( 300, 300 );
        frame.setVisible( true );
    }
}