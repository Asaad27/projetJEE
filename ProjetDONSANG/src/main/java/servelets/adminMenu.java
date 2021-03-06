package servelets;

import beans.Admin;
import beans.Centre;
import beans.Ville;
import dao.daoCentre;
import dao.DAOFactory;
import dao.DAOVille;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class adminMenu extends HttpServlet {
    private HttpSession session;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        session=request.getSession();
        Admin admin=(Admin)session.getAttribute("admin");
        if(admin==null){
            try {
                response.sendRedirect("/admin");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            DAOFactory daoFactory= DAOFactory.getInstance();
            daoCentre daoCentre = daoFactory.getCentreDAO();
            DAOVille daoville=daoFactory.getVilleDAO();
            List<Centre> centres=daoCentre.lister();
            request.setAttribute("centres",centres);
            List<Ville> villes= daoville.lister();
            request.setAttribute("villes",villes);
            request.getServletContext().getRequestDispatcher("/WEB-INF/MenuAdmin.jsp").forward(request,response);
        }
    }
}
