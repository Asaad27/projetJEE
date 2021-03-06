package servelets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import beans.*;
import dao.DAOFactory;
import dao.DAOGroupSangImpl;
import dao.DAOStockImpl;
import java.util.*;

@WebServlet(name = "ProfilCentre", value = "/ProfilCentre")
public class ProfilCentre extends HttpServlet {
    private DAOStockImpl daoStock;
    private DAOGroupSangImpl groupeDao;
    private DAOFactory daoFactory;
    public void init() throws ServletException {

        super.init();
        daoFactory = DAOFactory.getInstance();
        daoStock=daoFactory.getStockDAO();
        groupeDao=daoFactory.getGroupSangDAO();

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Centre centre=(Centre)request.getSession().getAttribute("centre");
        List<Stock> stocks=daoStock.getStock(centre.getIdCentre());
        request.setAttribute("stocks",stocks);

        this.getServletContext().getRequestDispatcher("/WEB-INF/ProfilCentre.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/ProfilCentre.jsp").forward(request, response);
    }
}
