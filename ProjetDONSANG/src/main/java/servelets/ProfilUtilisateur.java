package servelets;

import autre.Autre;
import beans.*;
import dao.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProfilUtilisateur", value = "/ProfilUtilisateur")
public class ProfilUtilisateur extends HttpServlet {
    public static final String PROFIL_FORM="/WEB-INF/ProfilUtilisateur.jsp";
    public static final String ATT_UTILISATEUR="utilisateurProfil";
    public static final String ATT_FORM="form";
    public static final String ATT_VILLE="villes";
    public static final String ATT_GROUP="groupes";
    private DAOFactory daoFactory;
    private DAOUtilisateurImpl utilisateurDao;
    private DAOVilleImpl villeDao;
    private DAOGroupSangImpl groupeDao;
    private DAODemandeUtilisateurImpl demandeDAO;
    public void init() throws ServletException {

        super.init();
        daoFactory=DAOFactory.getInstance();
        this.utilisateurDao = daoFactory.getUtilisateurDao();
        this.villeDao=daoFactory.getVilleDAO();
        this.groupeDao=daoFactory.getGroupSangDAO();
        this.demandeDAO=daoFactory.getDemanadeUtilisateurDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page=1;
        int nbRecordsPerPage=5;
        if(request.getParameter("pageCourante")!=null){
            page=Integer.parseInt(request.getParameter("pageCourante"));
        }
        Utilisateur userSesssion=(Utilisateur) request.getSession().getAttribute("utilisateur");
        Long idUser=userSesssion.getIdutilisateur();

        List<Ville> villes=villeDao.lister();
        List<GroupSang> groupes=groupeDao.lister();
        Utilisateur utilisateur=utilisateurDao.getusersByID(idUser);
       List<DemandeUtilisateur> mesDemandes=demandeDAO.getAllDemandsUser(idUser);
        String message="";
        int nbRecords= demandeDAO.getNbRecords();

        int nbPages=(int)Math.ceil(nbRecords*1.0/nbRecordsPerPage);
        List<DemandeUtilisateur> mesdemandes = Autre.filterPagination(mesDemandes,(page-1)*nbRecordsPerPage,nbRecordsPerPage*(page) < nbRecords?nbRecordsPerPage*(page) :(nbRecords) );
        request.setAttribute(ATT_VILLE,villes );
        request.setAttribute(ATT_GROUP, groupes);
        request.setAttribute(ATT_UTILISATEUR, utilisateur);
        request.setAttribute("nbPages",nbPages);
        request.setAttribute("pageCourante",page);
        request.setAttribute("message",idUser);
        request.setAttribute("requests",mesdemandes);
        this.getServletContext().getRequestDispatcher(PROFIL_FORM).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Utilisateur utilisateurSession=(Utilisateur) request.getSession().getAttribute("utilisateur");
        Long idUser=utilisateurSession.getIdutilisateur();


        UpdateUtilisateurForm form=new UpdateUtilisateurForm(utilisateurDao,idUser);

        Utilisateur utilisateur=form.validerUtilisateur(request);

        List<Ville> villes=villeDao.lister();
        List<GroupSang> groupes=groupeDao.lister();


        request.setAttribute(ATT_UTILISATEUR,utilisateur);
        request.setAttribute(ATT_FORM, form);
        request.setAttribute(ATT_VILLE,villes );
        request.setAttribute(ATT_GROUP, groupes);

        this.getServletContext().getRequestDispatcher(PROFIL_FORM).forward(request, response);
    }
}
