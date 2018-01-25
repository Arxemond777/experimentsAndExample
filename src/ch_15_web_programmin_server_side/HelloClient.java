package ch_15_web_programmin_server_side;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.System.out;

@WebServlet(urlPatterns={"/hello"})
public class HelloClient extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter outClient = response.getWriter();

        response.setContentType("text/html"); // must come first PrintWriter out = response.getWriter();
        out.println(
                "<html><head><title>Hello Client!</title></head><body>"
                        + "<h1>Hello Client!</h1>"
                        + "</body></html>" );

        outClient.println(
                "<html><head><title>Hello Client123!</title></head><body>"
                        + "<h1>Hello Client!</h1>"
                        + "</body></html>" );
        outClient.close();
    } }