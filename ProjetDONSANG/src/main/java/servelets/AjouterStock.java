package servelets;

import beans.*;

import dao.DAOFactory;
import dao.DAOGroupSang;
import dao.DAOStockImpl;
import dao.DAOUtilisateurImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AjouterStock", value = "/AjouterStock")
public class AjouterStock extends HttpServlet {
    private DAOGroupSang groupSangDao;
    private DAOStockImpl daoStock;
    private DAOFactory daoFactory;
    private List<GroupSang> groupSangList;
    public void init() throws ServletException {
        super.init();

        daoFactory = DAOFactory.getInstance();
        groupSangDao = daoFactory.getGroupSangDAO();
        daoStock=daoFactory.getStockDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        groupSangList=groupSangDao.lister();
        request.setAttribute("groupSangList",groupSangList);
        this.getServletContext().getRequestDispatcher("/WEB-INF/AjouterStock.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             String ajouter=request.getParameter("ajouter");
             String soustraire=request.getParameter("soustraire");
             Centre centre=(Centre)request.getSession().getAttribute("centre");
             System.out.println(centre.getIdCentre());
          List<Stock> stocks= daoStock.getStock(centre.getIdCentre());

             String resultatEchec="";
             String resultatSucces="";
             if(ajouter !=null){
                 for(int i=1;i<=8;i++){
                     Double oldStock=stocks.get(i-1).getQuantiteStock();
                     Stock stock=new Stock();
                     String quantite=request.getParameter("quantite"+i);
                     String idGroupe=request.getParameter("groupe");
                     if(quantite==null){
                         stock.setQuantiteStock(oldStock);
                     }else{
                         stock.setQuantiteStock(oldStock+Double.parseDouble(quantite));
                     }
                     stock.setIdGroupeSang(i);
                     stock.setIdCentre(centre.getIdCentre());
                     if(daoStock.modifierStock(stock)){
                         resultatSucces="Modification enregistrée avec suscces";
                     }else{
                         resultatEchec="Echec de modification";
                     }
                 }
             }else if(soustraire!=null){
                 for(int i=1;i<=8;i++){
                     Double oldStock=stocks.get(i-1).getQuantiteStock();
                     Stock stock=new Stock();
                     String quantite=request.getParameter("quantite"+i);
                     String idGroupe=request.getParameter("groupe");
                     if(quantite==null){
                         stock.setQuantiteStock(oldStock);
                     }else{
                         stock.setQuantiteStock(oldStock-Double.parseDouble(quantite));
                     }
                     stock.setIdGroupeSang(i);
                     stock.setIdCentre(centre.getIdCentre());
                     if(daoStock.modifierStock(stock)){
                         resultatSucces="Modification enregistrée avec suscces";
                     }else{
                         resultatEchec="Echec de modification";
                     }
                 }
             }
             request.setAttribute("resultatSucces",resultatSucces);
             request.setAttribute("resultatEchec", resultatEchec);
        groupSangList=groupSangDao.lister();
        request.setAttribute("groupSangList",groupSangList);
        this.getServletContext().getRequestDispatcher("/WEB-INF/AjouterStock.jsp").forward(request, response);

    }
}
