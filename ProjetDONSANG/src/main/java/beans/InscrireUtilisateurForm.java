package beans;

import dao.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class InscrireUtilisateurForm {
    //les champs du formumaire d'inscription
    private static final String  CHAMP_EMAIL="email";
    private static final String  CHAMP_PASSWORD="motdepasse";
    private static final String  CHAMP_CONDIRMATION="confirmation";
    private static final String  CHAMP_NOM="nom";
    private static final String  CHAMP_PRENOM="prenom";
    private static final String  CHAMP_CIN="cin";
    private static final String  CHAMP_TEL="tel";
    private static final String  CHAMP_ville="ville";
    private static final String  CHAMP_groupe="groupe";


    private Map<String,String> erreurs=new HashMap<String, String>();;

    private String resultat;
    private DAOUtilisateurImpl  inscrireutilisateurDao;
    public  InscrireUtilisateurForm(DAOUtilisateurImpl inscrireutilisateurDao) {
        this.inscrireutilisateurDao=inscrireutilisateurDao;
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
        String motdepasse=getValeurChamp(request,CHAMP_PASSWORD);
        String confirmation=getValeurChamp(request,CHAMP_CONDIRMATION);
        String nom=getValeurChamp(request,CHAMP_NOM);
        String cin = getValeurChamp(request, CHAMP_CIN);
        String tel = getValeurChamp(request, CHAMP_TEL);
        String groupe = getValeurChamp(request, CHAMP_groupe);
        String ville = getValeurChamp(request, CHAMP_ville);
        String prenom = getValeurChamp(request, CHAMP_PRENOM);

        Utilisateur utilisateur=new Utilisateur();

        try {
            traiterEmail(email, utilisateur);
            traiterMotDepasse(motdepasse, confirmation, utilisateur);
            traiterNom(nom, utilisateur);
            traitercin(cin, utilisateur);
            traiterPrenom(prenom, utilisateur);
            traitertele(tel, utilisateur);
            utilisateur.setIdgrouputilisateur(Integer.parseInt(groupe));
            utilisateur.setIdvilleutilisateur(Integer.parseInt(ville));

            if(erreurs.isEmpty()) {
                inscrireutilisateurDao.creer(utilisateur);
                setResultat("Succ�s d'inscreption");
            }else {
                setResultat("Echec d'inscription !!!");
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
            if(inscrireutilisateurDao.trouver(email) !=null) {
                throw new Exception("Cette adresse email est d�j� utilis�e, merci d'en choisir une autre.");
            }
        }

    }




    public void validationMotsDePasse(String motdepasse,String confirmation) throws Exception{
        if(motdepasse!=null && confirmation != null) {
            if(motdepasse.trim().length() >=3 && confirmation.trim().length() >=3) {
                if(!motdepasse.equals(confirmation)) {
                    throw new Exception("le mot de passe et sa confirmation ne son pas identiques");
                }

            }else {
                throw new Exception("le mot de passe et sa confirmation doivent contenir au moins 3 caract�res");

            }

        }else {
            throw new Exception("merci de saisir le mot de passe et sa confirmation ");
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
        if( tele != null && tele.trim().length() <9) {
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
    private void traiterMotDepasse(String motdepasse,String confirmation,Utilisateur utilisateur) {
        try {
            validationMotsDePasse(motdepasse, confirmation);
        }catch(Exception e) {
            setErreurs(CHAMP_PASSWORD, e.getMessage());
        }
        utilisateur.setPasswordutilisateur(motdepasse);
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
