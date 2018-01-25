package ch_15_web_programmin_server_side;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.util.Arrays;

@WebServlet(urlPatterns = {"/servlet_context"})
public class ServletContextExample extends HttpServlet
{
    /**
     * Страница 752, там есть еще пару интересных вещей, включая
     * фабрику Servlet Context для объектов RequestDispatcher, которая позволяет перенаправлять
     * запросы другим сервлетам или включать их результаы работы в свой собственный ответ (стр 753)
     * */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        ServletContext context = getServletContext();
        out.println("ServletContext = " + context);

        Object object = new Object()
        {
            public int a() {
                return 666;
            }
        };

        context.setAttribute("myapp.statics", object);
        Object stats = context.getAttribute("myapp.statics");
        out.println(Arrays.toString(stats.getClass().getDeclaredMethods()));

        File tmpDir = (File)context.getAttribute("javax.servlet.context.tempDir");
        File tmpFile = File.createTempFile("appprefix", "appsuffix", tmpDir);

        InputStream in = context.getResourceAsStream("/WEB-INF/web.xml");
        BufferedReader bin = new BufferedReader(new InputStreamReader(in));
        String line, result = "";

        while ((line = bin.readLine()) != null)
            result += line;
        out.println(result);
        out.close();
//        URL bunnyURI = context.getResource("/images/images.jpg");
    }
}
