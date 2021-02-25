package servelets;

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
       Utilisateur utilisateur=(Utilisateur)request.getSession().getAttribute("utilisateur");
       Long idUser=utilisateur.getIdutilisateur();
        List<DemandeUtilisateur> mesdemandes =demandeDao.getDemandsUser(idUser);
        request.setAttribute("requests",mesdemandes);
        this.getServletContext().getRequestDispatcher(MESDEMANDES_FORM).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String modifications="";
        int idDemande = Integer.parseInt(request.getParameter("idDemande"));

                String titre=request.getParameter("titre");
        Utilisateur utilisateur=(Utilisateur)request.getSession().getAttribute("utilisateur");
        Long idUser=utilisateur.getIdutilisateur();
        List<DemandeUtilisateur> mesdemandes =demandeDao.getDemandsUser(idUser);
        if(demandeDao.updateDemande(idDemande)){
            modifications="La demande est fermée !!!";


        }else{
            modifications="Désolé une erreur est survenue!!";
        }

        request.setAttribute("requests",mesdemandes);
        request.setAttribute("modif",modifications);
        response.sendRedirect("MesDemandes");

    }
}
