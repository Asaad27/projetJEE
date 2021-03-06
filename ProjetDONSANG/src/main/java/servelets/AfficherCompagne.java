package servelets;

import autre.Autre;
import beans.*;
import dao.*;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AfficherCompagne", value = "/AfficherCompagne")
public class AfficherCompagne extends HttpServlet {
    private DAOFactory daoFactory;
    private DAOCompagneImpl daoCompagne;
    private daoCentreImpl daocentre;
    public void init() throws ServletException {
        super.init();

        daoFactory = DAOFactory.getInstance();
        daoCompagne=daoFactory.getCompagneDAO();
        daocentre=daoFactory.getCentreDAO();

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page=1;
        int nbRecordsPerPage=6;
        if(request.getParameter("pageCourante")!=null){
            page=Integer.parseInt(request.getParameter("pageCourante"));
        }
        List<Compagne> compagnes=daoCompagne.getComapagne();
        int nbRecords=compagnes.size();
        int nbPages=(int)Math.ceil(nbRecords*1.0/nbRecordsPerPage);
        List<Centre> centres=new ArrayList<Centre>();
        for(Compagne compagne:compagnes){
            centres.add(daocentre.getCentreById(compagne.getIdcentre()));
        }
        List<Compagne> mescompagnes = Autre.filterPaginationCompagne(compagnes,(page-1)*nbRecordsPerPage,nbRecordsPerPage*(page) < nbRecords?nbRecordsPerPage*(page) :(nbRecords));
        request.setAttribute("compagnes",mescompagnes);
        request.setAttribute("centres",centres);
        request.setAttribute("nbPages",nbPages);
        request.setAttribute("pageCourante",page);
        this.getServletContext().getRequestDispatcher("/WEB-INF/AfficherComapgne.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
