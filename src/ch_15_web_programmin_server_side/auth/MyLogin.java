package ch_15_web_programmin_server_side.auth;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

//@ServletSecurity(
//        httpMethodConstraints = @HttpMethodConstraint(
//                value = "POST",
//                transportGuarantee = ServletSecurity.TransportGuarantee.NONE,
//                rolesAllowed = "admin"
//        )
//)
@WebServlet(urlPatterns = {"/mylogin"})
public class MyLogin extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("j_name");
        String password = request.getParameter("j_password");
        request.login(user, password);
        PrintWriter out = response.getWriter();
        response.setCharacterEncoding("UTF-8");
        out.println("Прошел аунтетификацию : " + request.getRequestedSessionId());
        out.close();

        // Dispatch or redirect to the next page...
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }
}

