package servelets;


import beans.Admin;
import dao.DAOAdminImpl;
import dao.DAOFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginAdmin")
public class LoginAdmin extends HttpServlet {
    private DAOAdminImpl adminDAO;
    private Admin admin;
    private DAOFactory daoFactory;
    public static final String LOGIN_FORM="/WEB-INF/LoginAdmin.jsp";


    @Override
    public void init() throws ServletException {
        super.init();
        daoFactory = DAOFactory.getInstance();
        this.adminDAO = daoFactory.getAdminDao();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        admin = adminDAO.trouver(email);

        if(admin == null ){
            String msg = "informations incorrectes  ";
            request.setAttribute("msg", msg);
            this.getServletContext().getRequestDispatcher(LOGIN_FORM).forward(request, response);

        } else {
                HttpSession session = request.getSession();
                session.setAttribute("admin", admin);
                response.sendRedirect("dashboard");             //DASHBOARD ADMIN
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if((Admin)session.getAttribute("admin") == null)
            this.getServletContext().getRequestDispatcher(LOGIN_FORM).forward(request, response);
        else{
            response.sendRedirect("dashboard");
        }
    }
}