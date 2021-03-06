package servelets;


import autre.EmailUtility;
import beans.*;
import dao.*;

import javax.mail.MessagingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "contact", value = "/contact")
public class contact extends HttpServlet {
    private DAODemandeUtilisateurImpl demandeDao;
    private String host;
    private String port;
    private String usere;
    private String pass;

    private DAOVille villeDao;
    private DAOGroupSang groupSangDao;
    private DAOUtilisateurImpl utilisateurDao;
    private DAOFactory daoFactory;
    private List<Ville> villes;
    private List<GroupSang> groupSangList;
    private String result;

    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        usere = context.getInitParameter("user");



    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = request.getParameter("message");
        String subject = request.getParameter("subject");
        String pass = request.getParameter("pass");
        String email = request.getParameter("email");
        String resultMessage="";
        try {
            EmailUtility.sendEmail(host,port,email,pass,usere,subject,message);


                resultMessage = "The e-mail was sent successfully";
            } catch (Exception ex) {
                ex.printStackTrace();
                resultMessage = "There were an error: " + ex.getMessage();
            } finally {
                request.setAttribute("Message", resultMessage);
            }
        this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }
}

