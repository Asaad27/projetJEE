package servelets;
import autre.Autre;
import dao.*;
import beans.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UsersDemandes", value = "/UsersDemandes")
public class UsersDemandes extends HttpServlet {
    private DAOFactory daoFactory;
    private DAODemandeUtilisateurImpl demandeDao;
    private DAOGroupSangImpl groupSangDao;
    private DAOVilleImpl villeDao;
    private DAOUtilisateurImpl utilisateurDao;
    private List<Ville> villes;
    private List<GroupSang> groupSangList;


    @Override
    public void init() throws ServletException {
        super.init();
        daoFactory = DAOFactory.getInstance();
        demandeDao = daoFactory.getDemanadeUtilisateurDAO();
        groupSangDao = daoFactory.getGroupSangDAO();
        villeDao = daoFactory.getVilleDAO();
        utilisateurDao=daoFactory.getUtilisateurDao();
        villes = villeDao.lister();
        groupSangList = groupSangDao.lister();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ville = request.getParameter("citySelect");
        String groupe = request.getParameter("groupSangSelect");
        int idVille=Integer.parseInt(ville);
        Utilisateur utilisateur=(Utilisateur) request.getSession().getAttribute("utilisateur");
        int idgroupe=utilisateur.getIdgrouputilisateur();
        List<DemandeUtilisateur> requestsFil=new ArrayList<DemandeUtilisateur>();

        List<DemandeUtilisateur> requests=demandeDao.getAllDemands(idVille);
        List<Utilisateur> users=new ArrayList<Utilisateur>();
        for(DemandeUtilisateur demande:requests){
            if(Autre.filterBygroup(demande.getSangGroups(),idgroupe)){
                requestsFil.add(demande);
            }

        }
        for(DemandeUtilisateur demande:requestsFil){
            Utilisateur user=utilisateurDao.getusersByID(demande.getIdutilisateur());
            users.add(user);}

        request.setAttribute("users",users);
        request.setAttribute("requests", requestsFil);
        request.setAttribute("villes",villes);
        request.setAttribute("groupSangList",groupSangList);

        this.getServletContext().getRequestDispatcher("/WEB-INF/UsersDemandes.jsp").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Utilisateur utilisateur=(Utilisateur) request.getSession().getAttribute("utilisateur");
        List<DemandeUtilisateur> requests=demandeDao.getAllDemands(utilisateur.getIdvilleutilisateur());
        int idgroupe=utilisateur.getIdgrouputilisateur();
        List<DemandeUtilisateur> requestsFil=new ArrayList<DemandeUtilisateur>();
        List<Utilisateur> users=new ArrayList<Utilisateur>();
        for(DemandeUtilisateur demande:requests){
            if(Autre.filterBygroup(demande.getSangGroups(),idgroupe)){
                requestsFil.add(demande);
            }

        }
        for(DemandeUtilisateur demande:requestsFil){
            Utilisateur user=utilisateurDao.getusersByID(demande.getIdutilisateur());
            users.add(user);}

        request.setAttribute("users",users);
        request.setAttribute("requests", requestsFil);
        request.setAttribute("villes",villes);
        request.setAttribute("groupSangList",groupSangList);

        this.getServletContext().getRequestDispatcher("/WEB-INF/UsersDemandes.jsp").forward(request, response);
    }
}
