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

public class DAOAdminImpl implements DAOAdmin {
    private static final String SQL_SELECT = "SELECT * FROM admin";
    private static final String SQL_SELECT_PAR_EMAIL = "SELECT * FROM admin WHERE email_admin = ?";
    private static final String SQL_INSERT = "INSERT INTO admin (nom_admin,prenom_admin,cin_admin,telephone_admin,email_admin,password_admin) "
            + "VALUES (?, ?, ?,?,?,?)";
    private static final String SQL_SELECT_PAR_ID = "SELECT * FROM admin WHERE id_admin= ?";
    private static final String SQL_DELETE_PAR_ID = "DELETE FROM admin WHERE id_admin= ?";
    private DAOFactory  daoFactory;

    DAOAdminImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
    public static Admin map( ResultSet resultSet ) throws SQLException {
        Admin admin = new Admin();
        admin.setIdAdmin( resultSet.getInt( "id_admin" ) );
        admin.setEmailAdmin( resultSet.getString( "email_admin" ) );
        admin.setCinAdmin( resultSet.getString( "cin_admin" ) );
        admin.setNomAdmin( resultSet.getString( "nom_admin" ) );
        admin.setPrenomAdmin( resultSet.getString( "prenom_admin" ) );
        admin.setTeleAdmin( resultSet.getString( "telephone_admin" ) );
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
            connexion = daoFactory.getConnection();
            preparedStatement =initialisationRequetePreparee( connexion, SQL_SELECT_PAR_EMAIL, false, email );
            resultSet = preparedStatement.executeQuery();

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
            preparedStatement=connection.prepareStatement(SQL_DELETE_PAR_ID);
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
                    admin.getNomAdmin(),admin.getPrenomAdmin(),admin.getCinAdmin(), admin.getTeleAdmin() ,
                    admin.getEmailAdmin(),admin.getPasswordAdmin() );
            int statue=preparedStatement.executeUpdate();
            if(statue==0) {
                throw new DAOException( "admin creation account error" );
            }
            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
            if ( valeursAutoGenerees.next() ) {

                admin.setIdAdmin( valeursAutoGenerees.getInt( 1 ) );
            } else {
                throw new DAOException( "erreur generating adminUser ID" );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
        }
    }

    public List<Admin> lister(){

        List<Admin> admins = new ArrayList<>();
        try {
            Connection connection = daoFactory.getConnection();
            java.sql.Statement statement= connection.createStatement();
            ResultSet result =statement.executeQuery(SQL_SELECT);

            while(result.next()) {
                Admin admin = new Admin();
                admin.setIdAdmin(result.getInt("id_admin"));
                admin.setCinAdmin(result.getString("cin_admin"));
                admin.setEmailAdmin(result.getString("email_admin"));
                admin.setNomAdmin(result.getString("nom_admin"));
                admin.setPrenomAdmin(result.getString("prenom_admin"));
                admin.setTeleAdmin(result.getString("telephone_admin"));

                admins.add(admin);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admins;
    }

    public Admin trouverAdminParID(int idadmin) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Admin admin = null;
        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_SELECT_PAR_ID, false, idadmin);
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