package servelets;

import beans.*;
import dao.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import autre.*;
@WebServlet(name = "ajouterdemande", value = "/ajouterdemande")
public class ajouterdemande extends HttpServlet {
    private DAODemandeUtilisateurImpl demandeDao;
    private DAODemandeCentreImpl demandeCentreDao;
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
        pass = context.getInitParameter("pass");
        daoFactory = DAOFactory.getInstance();
        demandeDao = daoFactory.getDemanadeUtilisateurDAO();
        villeDao = daoFactory.getVilleDAO();
        groupSangDao = daoFactory.getGroupSangDAO();
        utilisateurDao= daoFactory.getUtilisateurDao () ;
        demandeCentreDao=daoFactory.getDemandeCentreDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String titre = request.getParameter("titre");
        String description = request.getParameter("description");
        String estUrgente = request.getParameter("urgentSelect");
        String groupe= request.getParameter("groupSangSelect");
        String resultMessage = "";
        if(titre.isEmpty() || description.isEmpty() ||  groupe ==null ){
            result = "vide";
        }else {

            Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute("utilisateur");
            Centre centre = (Centre) request.getSession().getAttribute("centre");
            if (utilisateur != null) {
                DemandeUtilisateur demande = new DemandeUtilisateur();
                demande.setIdutilisateur(utilisateur.getIdutilisateur());
                String id = String.valueOf(utilisateur.getIdgrouputilisateur());
                demande.setTitreDemande(titre);
                demande.setDateDemande(new Timestamp(System.currentTimeMillis()));
                demande.setDescriptionDemande(description);
                demande.setEstActive(true);
                demande.setEstUrgente(estUrgente.equals("Yes") ? true : false);
                List<concerner> concernerlist = new ArrayList<>();

                if (groupe.equals("A+")) {
                    concerner concerner1 = new concerner();
                    concerner1.setIdGroupeSang(Long.valueOf(1));
                    concernerlist.add(concerner1);
                    concerner concerner2 = new concerner();
                    concerner2.setIdGroupeSang(Long.valueOf(2));
                    concernerlist.add(concerner2);
                    concerner concerner3 = new concerner();
                    concerner3.setIdGroupeSang(Long.valueOf(5));
                    concernerlist.add(concerner3);
                    concerner concerner4 = new concerner();
                    concerner4.setIdGroupeSang(Long.valueOf(6));
                    concernerlist.add(concerner4);
                } else if (groupe.equals("A-")) {
                    concerner concerner1 = new concerner();
                    concerner1.setIdGroupeSang(Long.valueOf(2));
                    concernerlist.add(concerner1);
                    concerner concerner2 = new concerner();
                    concerner2.setIdGroupeSang(Long.valueOf(6));
                    concernerlist.add(concerner2);
                } else if (groupe.equals("AB+")) {
                    concerner concerner1 = new concerner();
                    concerner1.setIdGroupeSang(Long.valueOf(1));
                    concernerlist.add(concerner1);
                    concerner concerner2 = new concerner();
                    concerner2.setIdGroupeSang(Long.valueOf(2));
                    concernerlist.add(concerner2);
                    concerner concerner3 = new concerner();
                    concerner3.setIdGroupeSang(Long.valueOf(3));
                    concernerlist.add(concerner3);
                    concerner concerner4 = new concerner();
                    concerner4.setIdGroupeSang(Long.valueOf(4));
                    concernerlist.add(concerner4);
                    concerner concerner5 = new concerner();
                    concerner5.setIdGroupeSang(Long.valueOf(5));
                    concernerlist.add(concerner5);
                    concerner concerner6 = new concerner();
                    concerner6.setIdGroupeSang(Long.valueOf(6));
                    concernerlist.add(concerner6);
                    concerner concerner7 = new concerner();
                    concerner7.setIdGroupeSang(Long.valueOf(7));
                    concernerlist.add(concerner7);
                    concerner concerner8 = new concerner();
                    concerner8.setIdGroupeSang(Long.valueOf(8));
                    concernerlist.add(concerner8);
                } else if (groupe.equals("AB-")) {
                    concerner concerner1 = new concerner();
                    concerner1.setIdGroupeSang(Long.valueOf(2));
                    concernerlist.add(concerner1);
                    concerner concerner2 = new concerner();
                    concerner2.setIdGroupeSang(Long.valueOf(4));
                    concernerlist.add(concerner2);
                    concerner concerner3 = new concerner();
                    concerner3.setIdGroupeSang(Long.valueOf(6));
                    concernerlist.add(concerner3);
                    concerner concerner4 = new concerner();
                    concerner4.setIdGroupeSang(Long.valueOf(8));
                    concernerlist.add(concerner4);
                } else if (groupe.equals("B+")) {
                    concerner concerner1 = new concerner();
                    concerner1.setIdGroupeSang(Long.valueOf(5));
                    concernerlist.add(concerner1);
                    concerner concerner2 = new concerner();
                    concerner2.setIdGroupeSang(Long.valueOf(6));
                    concernerlist.add(concerner2);
                    concerner concerner3 = new concerner();
                    concerner3.setIdGroupeSang(Long.valueOf(7));
                    concernerlist.add(concerner3);
                    concerner concerner4 = new concerner();
                    concerner4.setIdGroupeSang(Long.valueOf(8));
                    concernerlist.add(concerner4);
                } else if (groupe.equals("B-")) {
                    concerner concerner1 = new concerner();
                    concerner1.setIdGroupeSang(Long.valueOf(6));
                    concernerlist.add(concerner1);
                    concerner concerner2 = new concerner();
                    concerner2.setIdGroupeSang(Long.valueOf(8));
                    concernerlist.add(concerner2);
                } else if (groupe.equals("O+")) {
                    concerner concerner1 = new concerner();
                    concerner1.setIdGroupeSang(Long.valueOf(5));
                    concernerlist.add(concerner1);
                    concerner concerner2 = new concerner();
                    concerner2.setIdGroupeSang(Long.valueOf(6));
                    concernerlist.add(concerner2);
                } else if (groupe.equals("O-")) {

                    concerner concerner2 = new concerner();
                    concerner2.setIdGroupeSang(Long.valueOf(6));
                    concernerlist.add(concerner2);
                }

                demande.setSangGroups((ArrayList<concerner>) concernerlist);


                if (demandeDao.addDemande(demande)) {
                    result = "ok";
                    // String message = Utile.createMessageFromDemand(demande);
                    List<Utilisateur> utilisateurList = new ArrayList<Utilisateur>();
                    if (demande.isEstUrgente()) {
                        utilisateurList = utilisateurDao.lister();

                        String recipient = "";
                        String subject = "Demande du sang urgente:groupe " + groupe + " !!!!";
                        String content = "<p>"+description+"<br/> Message de :"+utilisateur.getNomutilisateur() +" "
                                +utilisateur.getPrenomutilisateur() +"<br/>Pour le contacter:son téléphone:"+utilisateur.getTeleutilisateur() +
                                "</p>";
                        for (Utilisateur user : utilisateurList) {
                            recipient = user.getEmailutilisateur();

                            try {
                                EmailUtility.sendEmail(host, port, usere, pass, recipient, subject,
                                        content);
                                resultMessage = "The e-mail was sent successfully";
                            } catch (Exception ex) {
                                ex.printStackTrace();
                                resultMessage = "There were an error: " + ex.getMessage();
                            } finally {
                                request.setAttribute("Message", resultMessage);
                            }

                        }

                    } /*else {
                    utilisateurList = utilisateurDao.getusersByCity(utilisateur.getIdvilleutilisateur());
                }*/
                    try {
                        // Runnable sendSMS = new SendSMS(donnateurList,message);
                        //new Thread(sendSMS).start();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    result = "non";
                }

            }else if(centre!=null){
                DemandeCentre demande = new DemandeCentre();
                demande.setIdcentre(centre.getIdCentre());
                demande.setTitreDemande(titre);
                demande.setDateDemande(new Timestamp(System.currentTimeMillis()));
                demande.setDescriptionDemande(description);
                demande.setEstActive(true);
                demande.setEstUrgente(estUrgente.equals("Yes") ? true : false);
                List<concerner> concernerlist = new ArrayList<>();

                if (groupe.equals("A+")) {
                    concerner concerner1 = new concerner();
                    concerner1.setIdGroupeSang(Long.valueOf(1));
                    concernerlist.add(concerner1);
                    concerner concerner2 = new concerner();
                    concerner2.setIdGroupeSang(Long.valueOf(2));
                    concernerlist.add(concerner2);
                    concerner concerner3 = new concerner();
                    concerner3.setIdGroupeSang(Long.valueOf(5));
                    concernerlist.add(concerner3);
                    concerner concerner4 = new concerner();
                    concerner4.setIdGroupeSang(Long.valueOf(6));
                    concernerlist.add(concerner4);
                } else if (groupe.equals("A-")) {
                    concerner concerner1 = new concerner();
                    concerner1.setIdGroupeSang(Long.valueOf(2));
                    concernerlist.add(concerner1);
                    concerner concerner2 = new concerner();
                    concerner2.setIdGroupeSang(Long.valueOf(6));
                    concernerlist.add(concerner2);
                } else if (groupe.equals("AB+")) {
                    concerner concerner1 = new concerner();
                    concerner1.setIdGroupeSang(Long.valueOf(1));
                    concernerlist.add(concerner1);
                    concerner concerner2 = new concerner();
                    concerner2.setIdGroupeSang(Long.valueOf(2));
                    concernerlist.add(concerner2);
                    concerner concerner3 = new concerner();
                    concerner3.setIdGroupeSang(Long.valueOf(3));
                    concernerlist.add(concerner3);
                    concerner concerner4 = new concerner();
                    concerner4.setIdGroupeSang(Long.valueOf(4));
                    concernerlist.add(concerner4);
                    concerner concerner5 = new concerner();
                    concerner5.setIdGroupeSang(Long.valueOf(5));
                    concernerlist.add(concerner5);
                    concerner concerner6 = new concerner();
                    concerner6.setIdGroupeSang(Long.valueOf(6));
                    concernerlist.add(concerner6);
                    concerner concerner7 = new concerner();
                    concerner7.setIdGroupeSang(Long.valueOf(7));
                    concernerlist.add(concerner7);
                    concerner concerner8 = new concerner();
                    concerner8.setIdGroupeSang(Long.valueOf(8));
                    concernerlist.add(concerner8);
                } else if (groupe.equals("AB-")) {
                    concerner concerner1 = new concerner();
                    concerner1.setIdGroupeSang(Long.valueOf(2));
                    concernerlist.add(concerner1);
                    concerner concerner2 = new concerner();
                    concerner2.setIdGroupeSang(Long.valueOf(4));
                    concernerlist.add(concerner2);
                    concerner concerner3 = new concerner();
                    concerner3.setIdGroupeSang(Long.valueOf(6));
                    concernerlist.add(concerner3);
                    concerner concerner4 = new concerner();
                    concerner4.setIdGroupeSang(Long.valueOf(8));
                    concernerlist.add(concerner4);
                } else if (groupe.equals("B+")) {
                    concerner concerner1 = new concerner();
                    concerner1.setIdGroupeSang(Long.valueOf(5));
                    concernerlist.add(concerner1);
                    concerner concerner2 = new concerner();
                    concerner2.setIdGroupeSang(Long.valueOf(6));
                    concernerlist.add(concerner2);
                    concerner concerner3 = new concerner();
                    concerner3.setIdGroupeSang(Long.valueOf(7));
                    concernerlist.add(concerner3);
                    concerner concerner4 = new concerner();
                    concerner4.setIdGroupeSang(Long.valueOf(8));
                    concernerlist.add(concerner4);
                } else if (groupe.equals("B-")) {
                    concerner concerner1 = new concerner();
                    concerner1.setIdGroupeSang(Long.valueOf(6));
                    concernerlist.add(concerner1);
                    concerner concerner2 = new concerner();
                    concerner2.setIdGroupeSang(Long.valueOf(8));
                    concernerlist.add(concerner2);
                } else if (groupe.equals("O+")) {
                    concerner concerner1 = new concerner();
                    concerner1.setIdGroupeSang(Long.valueOf(5));
                    concernerlist.add(concerner1);
                    concerner concerner2 = new concerner();
                    concerner2.setIdGroupeSang(Long.valueOf(6));
                    concernerlist.add(concerner2);
                } else if (groupe.equals("O-")) {

                    concerner concerner2 = new concerner();
                    concerner2.setIdGroupeSang(Long.valueOf(6));
                    concernerlist.add(concerner2);
                }

                demande.setSangGroups((ArrayList<concerner>) concernerlist);


                if (demandeCentreDao.addDemandeCentre(demande)) {
                    result = "ok";
                    // String message = Utile.createMessageFromDemand(demande);
                    List<Utilisateur> utilisateurList = new ArrayList<Utilisateur>();
                    if (demande.isEstUrgente()) {
                        utilisateurList = utilisateurDao.lister();

                        String recipient = "";
                        String subject = "<b>Demande du sang urgente:groupe " + groupe + " !!!!</b>";
                        String content = description;
                        for (Utilisateur user : utilisateurList) {
                            recipient = user.getEmailutilisateur();

                            try {
                                EmailUtility.sendEmail(host, port, usere, pass, recipient, subject,
                                        content);
                                resultMessage = "The e-mail was sent successfully";
                            } catch (Exception ex) {
                                ex.printStackTrace();
                                resultMessage = "There were an error: " + ex.getMessage();
                            } finally {
                                request.setAttribute("Message", resultMessage);
                            }

                        }

                    } /*else {
                    utilisateurList = utilisateurDao.getusersByCity(utilisateur.getIdvilleutilisateur());
                }*/
                    try {
                        // Runnable sendSMS = new SendSMS(donnateurList,message);
                        //new Thread(sendSMS).start();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    result = "non";
                }

            }
        }

        request.setAttribute("result", result);


        request.setAttribute("groupSangList",groupSangList);
        request.setAttribute("resultMessage",resultMessage);

        this.getServletContext().getRequestDispatcher("/WEB-INF/addDemande.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        villes = villeDao.lister();
        groupSangList = groupSangDao.lister();


        request.setAttribute("groupSangList",groupSangList);
        this.getServletContext().getRequestDispatcher("/WEB-INF/addDemande.jsp").forward(request, response);
    }
}
