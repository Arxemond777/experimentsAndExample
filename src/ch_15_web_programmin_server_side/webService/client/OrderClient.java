package ch_15_web_programmin_server_side.webService.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

public class OrderClient {

    final QName qName = new QName(
            "http://jawxs.ibm.tutorial/jaxws/orderprocess", "OrderProcess");

    /**
     * при запущенном веб-сервисе
     * в out сделать wsimport -keep -p ch_15_web_programmin_server_side.webService.client http://localhost:8080/OrderProcessWeb/orderprocess?wsdl
     * @param args
     */
    public static void main(String[] args) {
//        if (args.length != 1) {
//            System.out
//                    .println("Specify the URL of the OrderProcess Web Service");
//            System.exit(-1);
//        }
        String uri = "http://localhost:8080/OrderProcessWeb/orderprocess?wsdl";
        URL url = getWSDLURL(uri);
        OrderClient client = new OrderClient();
        client.processOrder(url);
    }

    private static URL getWSDLURL(String urlStr) {
        URL url = null;
        try {
            url = new URL(urlStr);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return url;
    }

    public void processOrder(URL url) {

        OrderProcess orderProcessingService = new OrderProcess(url, qName);

        System.out.println("Service is" + orderProcessingService);

        OrderBean order = populateOrder();

        OrderProcessService port = orderProcessingService.getOrderProcessPort();
        OrderBean orderResponse = port.processOrder(order);

        System.out.println("Order id is " + orderResponse.getOrderId());

    }

    private OrderBean populateOrder() {

        OrderBean order = new OrderBean();
        Customer customer = new Customer();
        customer.setCustomerId("A123");
        customer.setFirstName("John");
        customer.setLastName("Smith");
        order.setCustomer(customer);

        // Заполнение Order Item.
        OrderItem item = new OrderItem();
        item.setItemId("11");
        item.setQty(11);

        order.getOrderItems().add(item);
        return order;
    }
}
