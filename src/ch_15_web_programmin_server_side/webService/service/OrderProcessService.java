package ch_15_web_programmin_server_side.webService.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
//import com.ibm.jaxws.tutorial.service.bean.OrderBean;
import ch_15_web_programmin_server_side.webService.service.bean.OrderBean;

//JWS-аннотация, указывающая, что имя portType Web-сервиса
//равно "OrderProcessPort", имя сервиса равно
//"OrderProcess", а targetNamespace, использующийся в сгенерированном
//WSDL, равен "http://jawxs.ibm.tutorial/jaxws/orderprocess".

@WebService(serviceName = "OrderProcess",
        portName = "OrderProcessPort",
        targetNamespace = "http://jawxs.ibm.tutorial/jaxws/orderprocess")

//JWS-аннотация, определяющая отображение сервиса на
//протокол SOAP-сообщений. В частности, она определяет, что SOAP-сообщения
//являются литералами документа.

@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL,
        parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)

public class OrderProcessService
{

    @WebMethod
    public OrderBean processOrder(OrderBean orderBean) {

        // Выполнить обработку...
        System.out.println("processOrder called for customer"
                + orderBean.getCustomer().getCustomerId());

        // Заказанными позициями являются
        if (orderBean.getOrderItems() != null) {
            System.out.println("Number of items is "
                    + orderBean.getOrderItems().length);
        }

        //Обработать заказ.

        //Установить идентификатор заказа.
        orderBean.setOrderId("A1234");

        return orderBean;
    }
}
