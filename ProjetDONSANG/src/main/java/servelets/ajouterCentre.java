package servelets;

import beans.Admin;
import beans.Centre;
import beans.Ville;
import dao.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ajouterCentre", value = "/ajouterCentre")
public class ajouterCentre extends HttpServlet {
    private DAOFactory daoFactory;
    private DAOVille villeDao;
    private HttpSession session;
    private daoCentre centreDao;

    @Override
    public void init() throws ServletException {
        super.init();
        daoFactory=DAOFactory.getInstance();
        villeDao=daoFactory.getVilleDAO();
        centreDao=daoFactory.getCentreDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ajouter = request.getParameter("ajouter");
        String modifier = request.getParameter("modifier");
        String supprimer = request.getParameter("supprimer");
   if(ajouter!=null){
        String nomCentre = request.getParameter("nom");
        String emailCentre = request.getParameter("email");
        String passwordCentre = request.getParameter("password");
        String addresseCentre = request.getParameter("addresse");
        String strIdVille = request.getParameter("ville");
        String gsm = request.getParameter("tele");

        System.out.println(nomCentre + " " + emailCentre + " " + passwordCentre + " " + addresseCentre + " " + strIdVille + " " + gsm);
        // validaton des champs
        if (nomCentre.trim().isEmpty() || emailCentre.trim().isEmpty() || passwordCentre.trim().isEmpty() || addresseCentre.trim().isEmpty()
                || strIdVille.trim().isEmpty() || gsm.trim().isEmpty()) {
            request.setAttribute("flashMessageFaild", "Please complete all fields");
            returnFormulaire(request, response);
        } else {
            //validation pour chaque champs
            String errors = "";
            errors += validationField(emailCentre, "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[a-z]{2,6}$", "Email is invalid <br>");
            errors += validationField(passwordCentre, "^.{6,30}$", "Error must have beetwen 6 and 30 caracter<br>");
            errors += validationField(gsm, "^(\\+212|0)[0-9]{9}$", "Number gsm is invalid<br>");
            if (!errors.isEmpty()) {
                request.setAttribute("flashMessageFaild", errors);
                returnFormulaire(request, response);
            } else {

                Centre centre = new Centre();
                centre.setNameCentre(nomCentre);
                centre.setEmailCentre(emailCentre);
                centre.setPasswordCentre(passwordCentre);
                centre.setAdresseCentre(addresseCentre);
                centre.setIdVille(Integer.parseInt(strIdVille));
                centre.setTeleCentre(gsm);

                Centre centre1 = centreDao.trouver(centre.getEmailCentre());

                if (centre1 == null) {
                    centreDao.creer(centre);
                    request.setAttribute("flashMessageSuccess", "Le centre est ajouté avec succes");
                } else {
                    request.setAttribute("flashMessageFaild", "l'email existe déja");
                }

            }
        }
    }else if(modifier!=null){

       String nomCentre = request.getParameter("nom");
       String emailCentre = request.getParameter("email");
       String addresseCentre = request.getParameter("addresse");
       int idCentre= Integer.parseInt(request.getParameter("idCentre"));
       String gsm = request.getParameter("tele");
       Centre centre1 = centreDao.getCentreById(idCentre);
       Centre centre = new Centre();
       centre.setNameCentre(nomCentre);
       centre.setEmailCentre(emailCentre);
       centre.setPasswordCentre(centre.getPasswordCentre());
       centre.setAdresseCentre(addresseCentre);
       centre.setIdVille(centre.getIdVille());
       centre.setTeleCentre(gsm);
           centreDao.modifier(centre);
   }else if(supprimer!=null){
          int idCentre=Integer.parseInt(request.getParameter("idCentre"));
          centreDao.supprimer(idCentre);
   }
        List<Centre> centres=centreDao.lister();
        List<Ville> villes=villeDao.lister();
        request.setAttribute("villes",villes);
        request.setAttribute("centres",centres);
        this.getServletContext().getRequestDispatcher("/WEB-INF/ajouterCentre.jsp").forward(request,response);
        }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // return formullaire centre
            List<Centre> centres=centreDao.lister();
            List<Ville> villes=villeDao.lister();
            request.setAttribute("villes",villes);
            request.setAttribute("centres",centres);
            this.getServletContext().getRequestDispatcher("/WEB-INF/ajouterCentre.jsp").forward(request,response);


    }
    private void returnFormulaire(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("oldNom",request.getParameter("nom"));
        request.setAttribute("oldEmail",request.getParameter("email"));
        request.setAttribute("oldAddresse",request.getParameter("addresse"));
        request.setAttribute("oldVille",request.getParameter("ville"));
        request.setAttribute("oldTele",request.getParameter("tele"));
        List<Ville> villes=villeDao.lister();
        request.setAttribute("villes",villes);

        this.getServletContext().getRequestDispatcher("/WEB-INF/ajouterCentre.jsp").forward(request,response);
    }

    private String validationField(String field,String pattern,String erreur){
        if(field.matches(pattern)){
            return "";
        }else{
            return erreur;
        }
    }
}
