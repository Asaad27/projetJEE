package servelets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Deconnexion", value = "/Deconnexion")
public class Deconnexion extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("centre") != null && session.getAttribute("utilisateur") != null || session.getAttribute("admin") != null) {
            session.invalidate();
            response.sendRedirect("Login");
        }else{
            session.invalidate();
            response.sendRedirect("Login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
