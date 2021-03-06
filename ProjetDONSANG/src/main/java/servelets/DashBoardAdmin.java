package servelets;

import beans.Admin;
import beans.Centre;
import beans.Ville;
import dao.daoCentre;
import dao.DAOFactory;
import dao.DAOVille;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;


public class DashBoardAdmin extends HttpServlet {
    private HttpSession session;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        session=request.getSession();
        Admin admin=(Admin)session.getAttribute("admin");
        if(admin==null){
            response.sendRedirect("/loginAdmin");
        }else{
            DAOFactory daoFactory=DAOFactory.getInstance();
            daoCentre centreDao=daoFactory.getCentreDAO();
            DAOVille villeDao=daoFactory.getVilleDAO();
            List<Centre> centres=centreDao.lister();
            request.setAttribute("centres",centres);
            List<Ville> villes=villeDao.lister();
            request.setAttribute("villes",villes);
            request.getServletContext().getRequestDispatcher("/WEB-INF/adminDashBoard.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
