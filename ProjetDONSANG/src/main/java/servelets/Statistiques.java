package servelets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

import beans.*;
import dao.DAOFactory;
import dao.DAOGroupSang;
import dao.DAOGroupSangImpl;
import dao.DAOStockImpl;

@WebServlet(name = "Statistiques", value = "/Statistiques")
public class Statistiques extends HttpServlet {

    private DAOStockImpl daoStock;
    private DAOFactory daoFactory;
    private DAOGroupSangImpl groupeDao;

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

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
