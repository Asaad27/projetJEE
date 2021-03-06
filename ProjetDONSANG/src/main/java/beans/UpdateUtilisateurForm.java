package beans;

import dao.DAOException;
import dao.DAOUtilisateurImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class UpdateUtilisateurForm {
    private static final String  CHAMP_EMAIL="email";
    private static final String  CHAMP_ID="id";
    private static final String  CHAMP_PASSWORD="motdepasse";
    private static final String  CHAMP_CONDIRMATION="confirmation";
    private static final String  CHAMP_OLDPASSWORD="oldmotsepasse";
    private static final String  CHAMP_NOM="nom";
    private static final String  CHAMP_PRENOM="prenom";
    private static final String  CHAMP_CIN="cin";
    private static final String  CHAMP_TEL="tel";
    private static final String  CHAMP_ville="ville";
    private static final String  CHAMP_groupe="groupe";


    private Map<String,String> erreurs=new HashMap<String, String>();;

    private String resultat;
    private DAOUtilisateurImpl updateutilisateurDao;
    private Long idUser;


    public UpdateUtilisateurForm(DAOUtilisateurImpl updateutilisateurDao,Long idUser) {
        this.updateutilisateurDao = updateutilisateurDao;
        this.idUser=idUser;

    }

    public String getResultat() {
        return resultat;
    }
    public void setResultat(String resultat) {
        this.resultat = resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public Utilisateur validerUtilisateur(HttpServletRequest request) {


        String email=getValeurChamp(request,CHAMP_EMAIL);
        String nom=getValeurChamp(request,CHAMP_NOM);
        String cin = getValeurChamp(request, CHAMP_CIN);
        String tel = getValeurChamp(request, CHAMP_TEL);
        String groupe = getValeurChamp(request, CHAMP_groupe);
        String ville = getValeurChamp(request, CHAMP_ville);
        String prenom = getValeurChamp(request, CHAMP_PRENOM);


        Utilisateur utilisateur=new Utilisateur();
         utilisateur.setIdutilisateur(idUser);
        try {
            traiterEmail(email, utilisateur);
            traiterNom(nom, utilisateur);
            traitercin(cin, utilisateur);
            traiterPrenom(prenom, utilisateur);
            traitertele(tel, utilisateur);
            utilisateur.setIdgrouputilisateur(Integer.parseInt(groupe));
            utilisateur.setIdvilleutilisateur(Integer.parseInt(ville));
            utilisateur.setPasswordutilisateur(updateutilisateurDao.getPasswordUtilisateur(idUser));

            if(erreurs.isEmpty()) {
                updateutilisateurDao.updateUtilisateur(utilisateur);
                setResultat("Succes de modification");
            }else {
                setResultat("Echec de modification !!!");
            }
        }catch(DAOException e) {
            resultat = "�chec de l'inscription : une erreur impr�vue est survenue, merci de r�essayer dans quelques instants.";
            e.printStackTrace();

        }
        return utilisateur;
    }
    public void setErreurs(String champs,String message) {
        erreurs.put(champs, message);
    }
    public void validationEmail(String email) throws Exception {
        if(email ==null) {
            throw new Exception( "Merci de saisir une adresse mail." );

        }else {
            if(updateutilisateurDao.trouver(email) !=null && !updateutilisateurDao.getusersByID(idUser).getEmailutilisateur().equals(email)) {
                throw new Exception("Cette adresse email est d�j� utilis�e, merci d'en choisir une autre.");
            }
        }

    }


    public void validationNom(String nom) throws Exception{
        if( nom != null && nom.trim().length() <3) {
            throw new Exception("le nom doit contenir au moins 3 caract�res");
        }  if(nom ==null) {
            throw new Exception( "Merci de saisir  votre nom." );

        }

    }


    public void validationPrenom(String prenom) throws Exception{
        if( prenom != null && prenom.trim().length() <3) {
            throw new Exception("le prenom doit contenir au moins 3 caract�res");
        }  if(prenom ==null) {
            throw new Exception( "Merci de saisir votre prénom." );
        }

    }
    public void validationtele(String tele) throws Exception{
        if( tele != null && tele.trim().length() <10) {
            throw new Exception("le t�l�phone doit contenir au moins 9 num�ros");
        } if(tele ==null) {
            throw new Exception( "Merci de saisir votre téléphone." );
        }

    }
    public void validationCin(String cin) throws Exception{
        if( cin != null && cin.trim().length() <3) {
            throw new Exception("le cin doit contenir au moins 3 caract�res");
        } if(cin ==null) {
            throw new Exception( "Merci de saisir votre CIN." );
        }

    }
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur.trim();
        }
    }
    private void traiterEmail(String email,Utilisateur utilisateur) {
        try {
            validationEmail(email);
        }catch(Exception e) {
            setErreurs(CHAMP_EMAIL, e.getMessage());
        }
        utilisateur.setEmailutilisateur(email);

    }

    private void traiterNom(String nom,Utilisateur utilisateur) {
        try {
            validationNom(nom);
        }catch(Exception e) {
            setErreurs(CHAMP_NOM, e.getMessage());
        }
        utilisateur.setNomutilisateur(nom);


    }
    private void traiterPrenom(String prenom,Utilisateur utilisateur) {
        try {
            validationPrenom(prenom);
        }catch(Exception e) {
            setErreurs(CHAMP_PRENOM, e.getMessage());
        }
        utilisateur.setPrenomutilisateur(prenom);


    }
    private void traitercin(String cin,Utilisateur utilisateur) {
        try {
            validationCin(cin);
        }catch(Exception e) {
            setErreurs(CHAMP_CIN, e.getMessage());
        }
        utilisateur.setCinutilisateur(cin);


    }
    private void traitertele(String tele,Utilisateur utilisateur) {
        try {
            validationtele(tele);
        }catch(Exception e) {
            setErreurs(CHAMP_TEL, e.getMessage());
        }
        utilisateur.setTeleutilisateur(tele);


    }
}
