package ch_15_web_programmin_server_side.exampleEchoService.Service;

import javax.jws.*;
import javax.xml.ws.Endpoint;

/**
 * Смотри полную реализацию в ch_15_web_programmin_server_side.web_service
 */

@WebService
public class Page_790_Echo
{
    @WebMethod
    public int echoInt(int value) {
        return value;
    }

    @WebMethod
    public String echoString(String value) {
        return value;
    }

    @WebMethod
    public MyObject echoMyObject(MyObject value) {
        return value;
    }

    public static void main(String[] args) {
        Endpoint.publish("http://127.0.0.1:8080/echo", new Page_790_Echo());
    }
}
