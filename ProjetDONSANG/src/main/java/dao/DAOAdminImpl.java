package dao;

import beans.Admin;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static dao.DAOUtilitaire.fermeturesSilencieuses;
import static dao.DAOUtilitaire.initialisationRequetePreparee;
//email_admin, id_admin, nom_admin, password_admin, prenom_admin
public class DAOAdminImpl implements DAOAdmin {
    private static final String SQL_SELECT_PAR_EMAIL = "SELECT * FROM admin WHERE email_admin = ?";
    private static final String SQL_INSERT = "INSERT INTO admin (nom_admin, prenom_admin, email_admin, password_admin) "
            + "VALUES (?,?,?,?)";
    private static final String SQL_SELECT_PAR_ID = "SELECT * FROM admin WHERE id_admin= ?";

    private DAOFactory    daoFactory;

    DAOAdminImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
    public static Admin map(ResultSet resultSet ) throws SQLException {
        Admin admin = new Admin();
        admin.setIdAdmin( resultSet.getInt( "id_admin" ) );
        admin.setEmailAdmin( resultSet.getString( "email_admin" ) );
        admin.setNomAdmin( resultSet.getString( "nom_admin" ) );
        admin.setPrenomAdmin( resultSet.getString( "prenom_admin" ) );
        admin.setPasswordAdmin( resultSet.getString( "password_admin" ) );

        return admin;
    }

    @Override
    public Admin trouver(String email) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Admin admin = null;

        try {
            /* R�cup�ration d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
            preparedStatement =initialisationRequetePreparee( connexion, SQL_SELECT_PAR_EMAIL, false, email );
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de donn�es de l'�ventuel ResulSet retourn� */
            if ( resultSet.next() ) {
                admin = map( resultSet );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }

        return admin;
    }

    @Override
    public void supprimer(int idAdmin) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try{
            connection=this.daoFactory.getConnection();
            preparedStatement=connection.prepareStatement("delete from admin where id_admin=?");
            preparedStatement.setInt(1,idAdmin);
            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public  void creer(Admin admin) throws IllegalArgumentException, DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;
        try {
            connexion=daoFactory.getConnection();
            preparedStatement =initialisationRequetePreparee( connexion, SQL_INSERT, true,
                    admin.getNomAdmin(),admin.getPrenomAdmin(),
                    admin.getEmailAdmin(),admin.getPasswordAdmin());
            int statue=preparedStatement.executeUpdate();
            if(statue==0) {
                throw new DAOException( "�chec de la cr�ation de l'admin, aucune ligne ajout�e dans la table." );
            }
            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
            if ( valeursAutoGenerees.next() ) {
                /* Puis initialisation de la propri�t� id du bean Utilisateur avec sa valeur */
                admin.setIdAdmin( valeursAutoGenerees.getInt( 1 ) );
            } else {
                throw new DAOException( "�chec de la cr�ation de l'admin en base, aucun ID auto-g�n�r� retourn�." );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
        }

    }
    public List<Admin> lister(){

        List<Admin> adminList = new ArrayList<>();
        try {
            Connection connection = daoFactory.getConnection();
            java.sql.Statement statement= connection.createStatement();
            ResultSet result =statement.executeQuery("SELECT * FROM admin");

            while(result.next()) {
                Admin admin = new Admin();
                admin.setIdAdmin(result.getInt("id_admin"));
                admin.setEmailAdmin(result.getString("email_admin"));
                admin.setNomAdmin(result.getString("nom_admin"));
                admin.setPrenomAdmin(result.getString("prenom_admin"));

                adminList.add(admin);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adminList;
    }

    public Admin getAdminsByID(int idAdmin) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Admin admin = null;
        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_SELECT_PAR_ID, false, idAdmin);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                admin = map(resultSet);
            }

        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(preparedStatement, connexion);
        }
        return admin;
    }

}