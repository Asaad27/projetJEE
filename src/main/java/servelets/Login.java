package servelets;

import beans.Utilisateur;
import dao.DAOFactory;
import dao.DAOUtilisateurImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {

    private DAOUtilisateurImpl utilisateurDAO;
    private Utilisateur utilisateur;
    private DAOFactory daoFactory;
    public static final String LOGIN_FORM="/WEB-INF/Login.jsp";
    public static final String DEMANDE_FORM="/WEB-INF/addDemande.jsp";


    @Override
    public void init() throws ServletException {
        super.init();
        daoFactory = DAOFactory.getInstance();
        this.utilisateurDAO = daoFactory.getUtilisateurDao();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        utilisateur = utilisateurDAO.trouver(email);

        if(utilisateur == null ){
            String msg = "informations incorrectes  ";
            request.setAttribute("msg", msg);
            this.getServletContext().getRequestDispatcher(LOGIN_FORM).forward(request, response);

        } else {
            if(utilisateur != null){
                HttpSession session = request.getSession();
                session.setAttribute("utilisateur", utilisateur);
                response.sendRedirect("MesDemandes");


            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if((Utilisateur)session.getAttribute("utilisateur") == null)
            this.getServletContext().getRequestDispatcher(LOGIN_FORM).forward(request, response);

        else{
            response.sendRedirect("/");
        }
    }}