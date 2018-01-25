package ch_15_web_programmin_server_side.exampleEchoService.Client;


import ch_15_web_programmin_server_side.exampleEchoService.Service.MyObject;
import ch_15_web_programmin_server_side.exampleEchoService.Service.Page_790_Echo;

public class EchoClient
{
    public static void main( String [] args ) throws java.rmi.RemoteException
    {
        /*Page_790_Echo service = new EchoService().getEchoPort();
        int i = service.echoInt( 42 );
        System.out.println( i );
        String s = service.echoString( "Hello!" );
        System.out.println( s );
        MyObject myObject = new MyObject();
        myObject.setIntValue( 42 );
        myObject.setStringValue( "Foo!" );
        MyObject myObj = service.echoMyObject( myObject );
        System.out.println( myObj.getStringValue() );

        new Page_790_Echo().Echo();*/
    }
}
