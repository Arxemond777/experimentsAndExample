package ch_15_web_programmin_server_side;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(urlPatterns = {"/show_session"})
public class ShowSession extends HttpServlet
{
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public void doGet(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        boolean clear = request.getParameter("clear") != null;
        if (clear)
            session.invalidate();
        else {
            String name = request.getParameter("Name");
            String value = request.getParameter("Value");
            if (name != null && value != null)
                session.setAttribute(name, value);
        }

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println(
                "<html><head><title>Show Session</title></head><body>");

        if (clear)
            out.println("<h1>Session Cleared:</h1>");
        else {
            out.println("<h1>In this session:</h1><ul>");

            Enumeration names = session.getAttributeNames();
            while (names.hasMoreElements()) {
                String name = (String) names.nextElement();
                out.println("<li>" + name + " = " + session.getAttribute(name));
            }
        }

        out.println(
                "</ul><p><hr><h1>Add String</h1>"
                        + "<form method=\"POST\" action=\""
                        + request.getRequestURI() + "\">"
                        + "Name: <input name=\"Name\" size=20><br>"
                        + "Value: <input name=\"Value\" size=20><br>"
                        + "<br><input type=\"submit\" value=\"Submit\">"
                        + "<input type=\"submit\" name=\"clear\" value=\"Clear\"></form>"
        );
        out.close(); //TODO
    }
}
