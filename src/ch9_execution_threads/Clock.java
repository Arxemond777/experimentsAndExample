package ch9_execution_threads;

public class Clock extends ch9_execution_threads.UpdateApplet {
    public void paint( java.awt.Graphics graphics ) {
        graphics.drawString( new java.util.Date().toString(), 10, 25 );
    }
}
