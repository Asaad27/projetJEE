package servelets;

import beans.*;
import dao.DAOFactory;
import dao.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {

        private DAOUtilisateurImpl utilisateurDAO;
        private Utilisateur utilisateur;
        private Centre centre;
        private Admin admin;
        private DAOFactory daoFactory;
        private daoCentreImpl centreDAO;
        private DAOAdminImpl daoAdmin;
        public static final String LOGIN_FORM="/WEB-INF/Login.jsp";
        public static final String DEMANDE_FORM="/WEB-INF/addDemande.jsp";


        @Override
        public void init() throws ServletException {
            super.init();
            daoFactory = DAOFactory.getInstance();
            this.utilisateurDAO = daoFactory.getUtilisateurDao();
            this.centreDAO=daoFactory.getCentreDAO();
            this.daoAdmin=daoFactory.getAdminDAO();

        }

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            String email = request.getParameter("email");
            String password = request.getParameter("password");

            utilisateur = utilisateurDAO.trouver(email);
            centre=centreDAO.trouver(email);
            admin=daoAdmin.trouver(email);



            if(utilisateur == null  && centre== null && admin==null ){
                String msg = "informations incorrectes  ";
                request.setAttribute("msg", msg);
                this.getServletContext().getRequestDispatcher(LOGIN_FORM).forward(request, response);

            } else {
                if(utilisateur != null){
                    HttpSession session = request.getSession();
                    session.setAttribute("utilisateur", utilisateur);
                    response.sendRedirect("ProfilUtilisateur");


                }else if(centre != null){
                    HttpSession session = request.getSession();
                    session.setAttribute("centre", centre);
                    response.sendRedirect("ProfilCentre");
                }else{
                    HttpSession session = request.getSession();
                    session.setAttribute("admin", admin);
                    response.sendRedirect("ajouterCentre");
                }
            }
        }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            HttpSession session = request.getSession();
            if((Utilisateur)session.getAttribute("utilisateur") == null && (Centre)session.getAttribute("centre") == null &&
                    (Centre)session.getAttribute("admin") ==null)
                this.getServletContext().getRequestDispatcher(LOGIN_FORM).forward(request, response);

            else{
                response.sendRedirect("/");
            }
        }}
