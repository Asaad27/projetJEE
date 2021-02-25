package dao;

import beans.Admin;
import beans.Centre;
import beans.Utilisateur;

import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static dao.DAOUtilitaire.fermeturesSilencieuses;
import static dao.DAOUtilitaire.initialisationRequetePreparee;

public class DAOCentreImpl implements DAOCentre{
    private DAOFactory  daoFactory;

    private static final String SQL_SELECT = "SELECT * FROM centre";
    private static final String SQL_SELECT_PAR_EMAIL = "SELECT * FROM centre WHERE email_centre = ?" ;
    private static final String SQL_SELECT_PAR_ID = "SELECT * FROM centre WHERE id_centre = ?" ;
    private static final String SQL_INSERT = "INSERT INTO centre (email_centre,nom_centre,id_ville,email_admin,telephone_centre,adresse_centre,password_centre) "
            + "VALUES (?, ?, ?,?,?,?,?)";
    private static final String SQL_UPDATE_BYID = "UPDATE centre set email_centre=?, nom_centre=?, id_ville=?, email_admin=?, telephone_centre=?, adresse_centre=?, password_centre=? where id_centre=?";

    DAOCentreImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
    public static Centre map( ResultSet resultSet ) throws SQLException {
        Centre centre = new Centre();
        centre.setId_centre( resultSet.getInt( "id_centre" ) );
        centre.setEmail_centre( resultSet.getString( "email_centre" ) );
        centre.setNom_centre( resultSet.getString( "nom_centre" ) );
        centre.setId_ville( resultSet.getInt( "id_ville" ) );
        centre.setEmail_admin( resultSet.getString( "email_admin" ) );
        centre.setTel_centre( resultSet.getString( "telephone_centre" ) );
        centre.setAdresse_centre( resultSet.getString( "adresse_centre" ) );
        centre.setPassword_centre( resultSet.getString( "password_centre" ) );

        return centre;
    }
    @Override
    public void creer(Centre centre) throws IllegalArgumentException, DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;
        try {
            connexion=daoFactory.getConnection();
            preparedStatement =initialisationRequetePreparee( connexion, SQL_INSERT, true,
                    centre.getEmail_centre(), centre.getNom_centre(), centre.getId_ville(), centre.getTel_centre(), centre.getAdresse_centre(),
                    centre.getPassword_centre());
            int statue=preparedStatement.executeUpdate();
            if(statue==0) {
                throw new DAOException( "Centre creation error" );
            }
            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
            if ( valeursAutoGenerees.next() ) {

                centre.setId_centre( valeursAutoGenerees.getInt( 1 ) );
            } else {
                throw new DAOException( "erreur generating Centre ID" );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
        }
    }

    @Override
    public Centre trouver(String email) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Centre centre = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement =initialisationRequetePreparee( connexion, SQL_SELECT_PAR_EMAIL, false, email );
            resultSet = preparedStatement.executeQuery();

            if ( resultSet.next() ) {
                centre = map( resultSet );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }

        return centre;
    }

    @Override
    public Centre trouver(int id) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Centre centre = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement =initialisationRequetePreparee( connexion, SQL_SELECT_PAR_ID, false, id );
            resultSet = preparedStatement.executeQuery();

            if ( resultSet.next() ) {
                centre = map( resultSet );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }

        return centre;
    }

    @Override
    public void modifier(Centre centre) throws IllegalArgumentException, DAOException {

        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet = null;

        try{
            connection=daoFactory.getConnection();
            preparedStatement=connection.prepareStatement(SQL_UPDATE_BYID);
            preparedStatement.setString(1,centre.getEmail_centre());
            preparedStatement.setString(2,centre.getNom_centre());
            preparedStatement.setInt(3,centre.getId_ville());
            preparedStatement.setString(4,centre.getEmail_admin());
            preparedStatement.setString(5,centre.getTel_centre());
            preparedStatement.setString(6,centre.getAdresse_centre());
            preparedStatement.setString(7,centre.getPassword_centre());
            preparedStatement.setInt(8,centre.getId_centre());
            preparedStatement.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void supprimer(int id_centre) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try{
            connection=daoFactory.getConnection();
            preparedStatement=connection.prepareStatement("delete from centre WHERE id_centre=?");
            preparedStatement.setInt(1,id_centre);
            preparedStatement.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public List<Centre> lister() {
        List<Centre> centres = new ArrayList<>();
        try {
            Connection connection = daoFactory.getConnection();
            java.sql.Statement statement= connection.createStatement();
            ResultSet result =statement.executeQuery(SQL_SELECT);

            while(result.next()) {
                Centre centre = new Centre();
                centre.setId_centre(result.getInt("id_centre"));
                centre.setPassword_centre(result.getString("password_centre"));
                centre.setNom_centre(result.getString("nom_centre"));
                centre.setEmail_admin(result.getString("email_admin"));
                centre.setId_ville(result.getInt("id_ville"));
                centre.setAdresse_centre(result.getString("adresse_centre"));
                centre.setEmail_centre(result.getString("email_centre"));
                centre.setTel_centre(result.getString("telephone_centre"));

                centres.add(centre);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return centres;
    }
}