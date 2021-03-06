package servelets;

import beans.*;
import dao.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "AjouterCompagne", value = "/AjouterCompagne")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 50)
public class AjouterCompagne extends HttpServlet {
    private DAOVille villeDao;
    public static final int TAILLE_TAMPON=1024*1024*10;
    private DAOFactory daoFactory;
    private DAOCompagneImpl daoCompagne;
    private List<Ville> villes;
    public void init() throws ServletException {
        super.init();
        ServletContext context = getServletContext();

        daoFactory = DAOFactory.getInstance();
        villeDao = daoFactory.getVilleDAO();
        daoCompagne=daoFactory.getCompagneDAO();

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        villes = villeDao.lister();
        request.setAttribute("villes",villes);
        this.getServletContext().getRequestDispatcher("/WEB-INF/AjouterCompagne.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("centre") == null) {
            response.sendRedirect("/login.jsp");
        } else {

            String titreEvent = request.getParameter("title");

            String descEvent = request.getParameter("description");

            String dateString = request.getParameter("date");

            Part part = request.getPart("imgInput");


            String fileName = extractFileName(part);

            if (titreEvent.trim().isEmpty() || descEvent.trim().isEmpty() || dateString.trim().isEmpty() || fileName.trim().isEmpty() || fileName == null ) {
                request.setAttribute("flashMessageFaild", "SVP Completer tous les champs");

            } else{
                System.out.println(fileName);
                String error="";
                error=validationChamp(fileName,"[^\\s]+(\\.(?i)(jpg|png|gif|bmp))$","Please choose file with (.png, .jpg, .gif, .bmp) extension.");

                if(error!=""){
                    request.setAttribute("flashMessageFaild",error);
                }else{

                    if(!fileName.isEmpty() && fileName!=null){
                        ecrireFichier(part,fileName,"C:\\Users\\Fatima zahra Azennag\\IdeaProjects\\ProjetJEE\\src\\main\\webapp\\imagesEvent");
                    }






                    if (titreEvent.trim().isEmpty() || descEvent.trim().isEmpty() ) {
                        this.getServletContext().getRequestDispatcher("/WEB-INF/AjouterCompagne.jsp").forward(request, response);
                    }
                    else {
                        Compagne compagne=new Compagne();
                        compagne.setTitreCompagne(titreEvent);
                        compagne.setDateCompagne(dateString);
                        compagne.setDescriptionCompagne(descEvent);
                        compagne.setImageComapgne(fileName);
                        Centre centre=(Centre) session.getAttribute("centre");
                        System.out.println(centre.getIdCentre());
                       compagne.setIdcentre(centre.getIdCentre());
                        System.out.println(compagne.getIdcentre());


                        if (daoCompagne.addCompagne(compagne)== true) {
                            boolean isInserted = true;
                            String messageSucces="Evenment ajouté avec sucees";
                            request.setAttribute("messageSucces", messageSucces);
                            this.getServletContext().getRequestDispatcher("/WEB-INF/AjouterCompagne.jsp").forward(request, response);
                        }
                        else {
                            String messageEchec="Echec de création de l'événement !!";
                            request.setAttribute("messageEchec",messageEchec );
                            this.getServletContext().getRequestDispatcher("/WEB-INF/AjouterCompagne.jsp").forward(request, response);
                        }

                    }

                }



            }

            }

    }
    private  String extractFileName(Part part) {

        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");

        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }

    private void ecrireFichier( Part part, String nomFichier, String chemin ) throws IOException {

        /* PrĂ©pare les flux. */

        BufferedInputStream entree = null;

        BufferedOutputStream sortie = null;

        try {

            /* Ouvre les flux. */

            entree = new BufferedInputStream( part.getInputStream(), TAILLE_TAMPON );

            sortie = new BufferedOutputStream( new FileOutputStream( new File( chemin +"\\"+ nomFichier ) ),

                    TAILLE_TAMPON );

            byte[] tampon = new byte[TAILLE_TAMPON];

            int longueur;

            while ( ( longueur = entree.read( tampon ) ) > 0 ) {

                sortie.write( tampon, 0, longueur );

            }

        } finally {

            try {

                sortie.close();

            } catch ( IOException ignore ) {

            }

            try {

                entree.close();

            } catch ( IOException ignore ) {

            }

        }




    }
    private String validationChamp(String field, String pattern,String erreur){
        if(!field.matches(pattern)){
            return erreur;
        }
        return "";
    }
}
