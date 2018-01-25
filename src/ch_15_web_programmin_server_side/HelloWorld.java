package ch_15_web_programmin_server_side;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class HelloWorld extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        showRequestParameters(request, response);
    }

    @Override
    public void doPost( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet( request, response );
    }

    void showRequestParameters(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(
                "<html<head><title>List Parameters </title></head><body>"
                + "<h1>Parametrs: </h1>"
        );

        Map<String, String[]> params = request.getParameterMap();
//        out.println(params);
        for(String name : params.keySet()) {
            String[] values = params.get(name);
            out.println("<li>" + name + " =  " + Arrays.asList(values));
        }
        out.print("<p>End</p>");

        out.println("</ul><p><form method=\"POST\" action=\""
                + request.getRequestURI() /*Определение местоположения сервлета*/ + "\">"
                + "Field 1 <input name=\"Field 1\" size=20><br>"
                + "Field 2 <input name=\"Field 2\" size=20><br>"
                + "<br><input type=\"submit\" value=\"Submit\"></form>"
        );
        out.close();
    }
}