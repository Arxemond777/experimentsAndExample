package ch_15_web_programmin_server_side;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
/*import java.util.Arrays;
import java.util.Enumeration;

@WebServlet(
        initParams = @WebInitParam(name = "location", value = "1")
)*/
public class WaitServlet extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
//        String waitStr = getServletConfig().getInitParameter("time");
        String waitStr = request.getParameter("time");

        if (waitStr == null)
            throw new ServletException("Missing parameter: time");
        int wait = Integer.parseInt(waitStr);

        try {
            Thread.sleep(wait * 1000);
        } catch (InterruptedException e) {
            throw new ServletException(e);
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body><h1>WaitServlet Response</h1></body></html>");

    }
}
