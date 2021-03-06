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
        int page=1;
        int nbRecordsPerPage=5;
        if(request.getParameter("pageCourante")!=null){
            page=Integer.parseInt(request.getParameter("pageCourante"));
        }
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
        int nbRecords=requestsFil.size();
        int nbPages=(int)Math.ceil(nbRecords*1.0/nbRecordsPerPage);
        List<DemandeUtilisateur> mesdemandes = Autre.filterPagination(requestsFil,(page-1)*nbRecordsPerPage,nbRecordsPerPage*(page) < nbRecords?nbRecordsPerPage*(page) :(nbRecords));
        request.setAttribute("users",users);
        request.setAttribute("requests", requestsFil);
        request.setAttribute("villes",villes);
        request.setAttribute("groupSangList",groupSangList);
        request.setAttribute("nbPages",nbPages);
        request.setAttribute("pageCourante",page);

        this.getServletContext().getRequestDispatcher("/WEB-INF/UsersDemandes.jsp").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page=1;
        int nbRecordsPerPage=5;
        if(request.getParameter("pageCourante")!=null){
            page=Integer.parseInt(request.getParameter("pageCourante"));
        }
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
        int nbRecords=requestsFil.size();
        int nbPages=(int)Math.ceil(nbRecords*1.0/nbRecordsPerPage);
        List<DemandeUtilisateur> mesdemandes = Autre.filterPagination(requestsFil,(page-1)*nbRecordsPerPage,nbRecordsPerPage*(page) < nbRecords?nbRecordsPerPage*(page) :(nbRecords));

        request.setAttribute("users",users);
        request.setAttribute("requests", mesdemandes);
        request.setAttribute("villes",villes);
        request.setAttribute("groupSangList",groupSangList);
        request.setAttribute("nbPages",nbPages);
        request.setAttribute("pageCourante",page);

        this.getServletContext().getRequestDispatcher("/WEB-INF/UsersDemandes.jsp").forward(request, response);
    }
}
