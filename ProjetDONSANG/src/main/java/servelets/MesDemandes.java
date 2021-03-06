package servelets;

import autre.Autre;
import beans.*;

import dao.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MesDemandes", value = "/MesDemandes")
public class MesDemandes extends HttpServlet {
    public static final String MESDEMANDES_FORM="/WEB-INF/MesDemandes.jsp";
    private DAOFactory daoFactory;
    private DAODemandeUtilisateurImpl demandeDao;
    public void init() throws ServletException {
        super.init();
        daoFactory = DAOFactory.getInstance();
        demandeDao = daoFactory.getDemanadeUtilisateurDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page=1;
        int nbRecordsPerPage=8;
        if(request.getParameter("pageCourante")!=null){
             page=Integer.parseInt(request.getParameter("pageCourante"));
        }
        Utilisateur utilisateur=(Utilisateur)request.getSession().getAttribute("utilisateur");
       Long idUser=utilisateur.getIdutilisateur();
        List<DemandeUtilisateur> demandes=demandeDao.getDemandsUser(idUser);
        int nbRecords=demandeDao.getNbRecords();
        int nbPages=(int)Math.ceil(nbRecords*1.0/nbRecordsPerPage);
        List<DemandeUtilisateur> mesdemandes = Autre.filterPagination(demandes,(page-1)*nbRecordsPerPage,nbRecordsPerPage*(page) < nbRecords?nbRecordsPerPage*(page) :(nbRecords) );

        request.setAttribute("nbPages",nbPages);
        request.setAttribute("pageCourante",page);
        request.setAttribute("requests",mesdemandes);
        this.getServletContext().getRequestDispatcher(MESDEMANDES_FORM).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page=1;
        int nbRecordsPerPage=5;
        if(request.getParameter("pageCourante")!=null){
            page=Integer.parseInt(request.getParameter("pageCourante"));
        }
        String modifications="";
        int idDemande = Integer.parseInt(request.getParameter("idDemande"));


        Utilisateur utilisateur=(Utilisateur)request.getSession().getAttribute("utilisateur");
        Long idUser=utilisateur.getIdutilisateur();
        List<DemandeUtilisateur> demandes =demandeDao.getDemandsUser(idUser);
        int nbRecords=demandeDao.getNbRecords();
        int nbPages=(int)Math.ceil(nbRecords*1.0/nbRecordsPerPage);
        List<DemandeUtilisateur> mesdemandes = Autre.filterPagination(demandes,(page-1)*nbRecordsPerPage,nbRecordsPerPage*(page) < nbRecords?nbRecordsPerPage*(page) :(nbRecords) );
        if(demandeDao.updateDemande(idDemande)){
            modifications="La demande est fermée !!!";


        }else{
            modifications="Désolé une erreur est survenue!!";
        }

        request.setAttribute("requests",mesdemandes);
        request.setAttribute("modif",modifications);
        request.setAttribute("nbPages",nbPages);
        request.setAttribute("pageCourante",page);
        response.sendRedirect("MesDemandes");

    }
}
