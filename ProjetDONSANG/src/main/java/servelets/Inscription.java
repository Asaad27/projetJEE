package servelets;

import beans.GroupSang;
import beans.InscrireUtilisateurForm;
import beans.Utilisateur;
import beans.Ville;
import dao.DAOFactory;
import dao.DAOGroupSangImpl;
import dao.DAOUtilisateurImpl;
import dao.DAOVilleImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Inscription", value = "/Inscription")
public class Inscription extends HttpServlet {
    public static final String CONF_DAO_FACTORY = "daofactory";
    public static final String INSCRIPTION_FORM="/WEB-INF/Inscription.jsp";
    public static final String ATT_UTILISATEUR="utilisateur";
    public static final String ATT_FORM="form";
    public static final String ATT_VILLE="villes";
    public static final String ATT_GROUP="groupes";
    private DAOFactory          daoFactory;
    private DAOUtilisateurImpl utilisateurDao;
    private DAOVilleImpl villeDao;
    private DAOGroupSangImpl groupeDao;

    public void init() throws ServletException {
        /* Récupération d'une instance de notre DAO Utilisateur */
        super.init();
        daoFactory=DAOFactory.getInstance();
        this.utilisateurDao = daoFactory.getUtilisateurDao();
        this.villeDao=daoFactory.getVilleDAO();
        this.groupeDao=daoFactory.getGroupSangDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Ville> villes=villeDao.lister();
        List<GroupSang> groupes=groupeDao.lister();
        request.setAttribute(ATT_VILLE,villes );
        request.setAttribute(ATT_GROUP, groupes);
        this.getServletContext().getRequestDispatcher(INSCRIPTION_FORM).forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InscrireUtilisateurForm  form=new InscrireUtilisateurForm(utilisateurDao);

        Utilisateur utilisateur=form.validerUtilisateur(request);

        List<Ville> villes=villeDao.lister();
        List<GroupSang> groupes=groupeDao.lister();


        request.setAttribute(ATT_UTILISATEUR,utilisateur);
        request.setAttribute(ATT_FORM, form);
        request.setAttribute(ATT_VILLE,villes );
        request.setAttribute(ATT_GROUP, groupes);

        this.getServletContext().getRequestDispatcher(INSCRIPTION_FORM).forward(request, response);

    }
}
