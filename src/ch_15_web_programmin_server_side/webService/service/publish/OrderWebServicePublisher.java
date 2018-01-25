package ch_15_web_programmin_server_side.webService.service.publish;

import javax.xml.ws.Endpoint;

import ch_15_web_programmin_server_side.webService.service.OrderProcessService;

/**
 * после компиляции заходим в out/production/HelloWorld
 * и делаем wsgen -cp . ch_15_web_programmin_server_side.webService.service.OrderProcessService -wsdl
 * создается папка с АРТЕФАКТАМИ ~/InteliJ/HelloWorld/out/production/HelloWorld/ch_15_web_programmin_server_side/webService/jaxws
 * И ~/InteliJ/HelloWorld/out/production/HelloWorld/OrderProcess.wsdl
 * ~/InteliJ/HelloWorld/out/production/HelloWorld/OrderProcess_schema1.xsd
 * И
 */
public class OrderWebServicePublisher
{

    public static void main(String[] args) {

        /**
         * http://www.ibm.com/developerworks/ru/edu/ws-jax/
         * TODO смотри на http://localhost:8080/OrderProcessWeb/orderprocess?wsdl
         */

        Endpoint.publish("http://localhost:8080/OrderProcessWeb/orderprocess",
                new OrderProcessService());

        System.out.println("The web service is published at http://localhost:8080/OrderProcessWeb/orderprocess");

        System.out.println("To stop running the web service , terminate the java process");
    }

}
