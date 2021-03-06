package dao;

import beans.Utilisateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static dao.DAOUtilitaire.fermeturesSilencieuses;
import static dao.DAOUtilitaire.initialisationRequetePreparee;

public class DAOUtilisateurImpl implements DAOUtilisateur {
    private static final String SQL_SELECT_PAR_EMAIL = "SELECT * FROM utilisateur WHERE email_utilisateur = ?";
    private static final String SQL_INSERT = "INSERT INTO utilisateur (nom_utilisateur,prenom_utilisateur,cin_utilisateur,telephone_utilisateur,email_utilisateur,password_utilisateur,id_ville,id_groupe) "
            + "VALUES (?, ?, ?,?,?,?,?,?)";
    private static final String SQL_SELECT_PAR_ville = "SELECT id_utilisateur, nom_utilisateur,prenom_utilisateur,cin_utilisateur,telephone_utilisateur,email_utilisateur,password_utilisateur,id_ville,id_groupe FROM "
            + "Utilisateur WHERE id_ville= ?";
    private static final String SQL_SELECT_PAR_ID = "SELECT * FROM utilisateur WHERE id_utilisateur= ?";
    private static final String SQL_SELECT_PASSWORD = "SELECT password_utilisateur FROM utilisateur WHERE id_utilisateur= ?";
    private static final String SQL_UPDATE="UPDATE utilisateur set nom_utilisateur=?,prenom_utilisateur=?,telephone_utilisateur=?,email_utilisateur=?,id_ville=?  where id_utilisateur=?";
    private DAOFactory    daoFactory;

    DAOUtilisateurImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
    public static Utilisateur map( ResultSet resultSet ) throws SQLException {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setIdutilisateur( resultSet.getLong( "id_utilisateur" ) );
        utilisateur.setEmailutilisateur( resultSet.getString( "email_utilisateur" ) );
        utilisateur.setCinutilisateur( resultSet.getString( "cin_utilisateur" ) );
        utilisateur.setNomutilisateur( resultSet.getString( "nom_utilisateur" ) );
        utilisateur.setPrenomutilisateur( resultSet.getString( "prenom_utilisateur" ) );
        utilisateur.setTeleutilisateur( resultSet.getString( "telephone_utilisateur" ) );
        utilisateur.setPasswordutilisateur( resultSet.getString( "password_utilisateur" ) );
        utilisateur.setIdgrouputilisateur( resultSet.getInt( "id_groupe" ) );
        utilisateur.setIdvilleutilisateur( resultSet.getInt( "id_ville" ) );


        return utilisateur;
    }

    @Override
    public Utilisateur trouver(String email) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Utilisateur utilisateur = null;

        try {
            /* R�cup�ration d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
            preparedStatement =initialisationRequetePreparee( connexion, SQL_SELECT_PAR_EMAIL, false, email );
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de donn�es de l'�ventuel ResulSet retourn� */
            if ( resultSet.next() ) {
                utilisateur = map( resultSet );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }

        return utilisateur;


    }

    @Override
    public  void creer(Utilisateur utilisateur) throws IllegalArgumentException, DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;
        try {
            connexion=daoFactory.getConnection();
            preparedStatement =initialisationRequetePreparee( connexion, SQL_INSERT, true,
                    utilisateur.getNomutilisateur(),utilisateur.getPrenomutilisateur(),utilisateur.getCinutilisateur(), utilisateur.getTeleutilisateur() ,
                    utilisateur.getEmailutilisateur(),utilisateur.getPasswordutilisateur(),utilisateur.getIdvilleutilisateur(),utilisateur.getIdgrouputilisateur());
            int statue=preparedStatement.executeUpdate();
            if(statue==0) {
                throw new DAOException( "�chec de la cr�ation de l'utilisateur, aucune ligne ajout�e dans la table." );
            }
            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
            if ( valeursAutoGenerees.next() ) {
                /* Puis initialisation de la propri�t� id du bean Utilisateur avec sa valeur */
                utilisateur.setIdutilisateur( valeursAutoGenerees.getLong( 1 ) );
            } else {
                throw new DAOException( "�chec de la cr�ation de l'utilisateur en base, aucun ID auto-g�n�r� retourn�." );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
        }

    }
    public List<Utilisateur> lister(){

        List<Utilisateur> utilisateurList = new ArrayList<>();
        try {
            Connection connection = daoFactory.getConnection();
            java.sql.Statement statement= connection.createStatement();
            ResultSet result =statement.executeQuery("SELECT * FROM utilisateur");



            while(result.next()) {
                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setIdutilisateur(result.getLong("id_utilisateur"));
                utilisateur.setCinutilisateur(result.getString("cin_utilisateur"));
                utilisateur.setEmailutilisateur(result.getString("email_utilisateur"));
                utilisateur.setNomutilisateur(result.getString("nom_utilisateur"));
                utilisateur.setPrenomutilisateur(result.getString("prenom_utilisateur"));
                utilisateur.setIdvilleutilisateur(result.getInt("id_ville"));
                utilisateur.setIdgrouputilisateur(result.getInt("id_groupe"));
                utilisateur.setTeleutilisateur(result.getString("telephone_utilisateur"));

                utilisateurList.add(utilisateur);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return utilisateurList;
    }
    public List<Utilisateur> getusersByCity(int idVille) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement=initialisationRequetePreparee(connexion, SQL_SELECT_PAR_ville, false, idVille);
            resultSet = preparedStatement.executeQuery();
            List<Utilisateur>utilisateurList = new ArrayList<>();
            while(resultSet.next()){
               Utilisateur  utilisateur = new Utilisateur();

                utilisateur.setIdutilisateur(resultSet.getLong("id_utilisateur"));
                utilisateur.setCinutilisateur(resultSet.getString("cin_utilisateur"));
                utilisateur.setEmailutilisateur(resultSet.getString("email_utilisateur"));
                utilisateur.setNomutilisateur(resultSet.getString("nom_utilisateur"));
                utilisateur.setPrenomutilisateur(resultSet.getString("prenom_utilisateur"));
                utilisateur.setIdvilleutilisateur(resultSet.getInt("id_ville"));
                utilisateur.setIdgrouputilisateur(resultSet.getInt("id_groupe"));
                utilisateur.setTeleutilisateur(resultSet.getString("telephone_utilisateur"));
                utilisateurList.add(utilisateur);
            }
            return utilisateurList;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    public Utilisateur getusersByID(Long iduser) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Utilisateur utilisateur = null;
        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_SELECT_PAR_ID, false, iduser);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                utilisateur = map(resultSet);
            }

        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(preparedStatement, connexion);
        }
        return utilisateur;
    }
    public String getPasswordUtilisateur(Long idUser)throws DAOException{
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Utilisateur utilisateur = null;
        String password="";
        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_SELECT_PASSWORD,   false ,idUser);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
               password=resultSet.getString("password_utilisateur");
            }

        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(preparedStatement, connexion);
        }
        return password;
    }
    public boolean updateUtilisateur(Utilisateur utilisateur) throws DAOException{
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        int statue;
        boolean etat=false;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_UPDATE,   false ,utilisateur.getNomutilisateur(),
                    utilisateur.getPrenomutilisateur(),utilisateur.getTeleutilisateur(),utilisateur.getEmailutilisateur()
                    ,utilisateur.getIdvilleutilisateur(),utilisateur.getIdutilisateur());
            statue = preparedStatement.executeUpdate();
            if (statue==0) {
                throw new DAOException("problèmme d'update");
            }
            else{
                etat=true;
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(preparedStatement, connexion);
        }
        return etat;


    }

}