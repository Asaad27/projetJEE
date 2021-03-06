package dao;

import beans.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static dao.DAOUtilitaire.fermeturesSilencieuses;
import static dao.DAOUtilitaire.initialisationRequetePreparee;

public class daoCentreImpl implements daoCentre{
    private DAOFactory daoFactory;
    private DAOStock daoStock;
    private static final String SQL_SELECT = "SELECT * FROM centre";
    private static final String SQL_SELECT_PAR_EMAIL = "SELECT * FROM centre WHERE email_centre = ?";
    private static  final String SQL_SELECT_PAR_ID="SELECT * FROM centre where id_centre= ?";
    private static final String SQL_INSERT = "INSERT INTO centre (email_centre,nom_centre,id_ville,telephone_centre,adresse_centre,password_centre) "
            + "VALUES (?, ?, ?,?,?,?)";
    private static final String SQL_UPDATE_BYID = "UPDATE centre set email_centre=?, nom_centre=?, id_ville=?, telephone_centre=?, adresse_centre=?, password_centre=? where id_centre=?";

    public daoCentreImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
        this.daoStock=daoFactory.getStockDAO();
    }
    public static Centre map(ResultSet resultSet ) throws SQLException {
       Centre centre = new Centre();
        centre.setIdCentre( resultSet.getInt( "id_centre" ) );
        centre.setEmailCentre( resultSet.getString( "email_centre" ) );
        centre.setNameCentre( resultSet.getString( "nom_centre" ) );
        centre.setAdresseCentre( resultSet.getString( "adresse_centre" ) );
        centre.setTeleCentre( resultSet.getString( "telephone_centre" ) );
        centre.setPasswordCentre( resultSet.getString( "password_centre" ) );
        centre.setIdVille(resultSet.getInt( "id_ville" ) );


        return centre;
    }

    @Override
    public Centre trouver(String email) throws DAOException {
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
    public Centre getCentreById(int idCentre) throws DAOException{
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Centre centre = null;
        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_SELECT_PAR_ID, false, idCentre);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                centre = map(resultSet);
            }

        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(preparedStatement, connexion);
        }
        return centre;
    }
    public void creer(Centre centre) throws IllegalArgumentException, DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;
        try {
            connexion=daoFactory.getConnection();
            preparedStatement =initialisationRequetePreparee( connexion, SQL_INSERT, true,
                    centre.getEmailCentre(), centre.getNameCentre(), centre.getIdVille(), centre.getTeleCentre(), centre.getAdresseCentre(),
                    centre.getPasswordCentre());
            int statue=preparedStatement.executeUpdate();
            if(statue==0) {
                throw new DAOException( "Centre creation error" );
            }
            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
            if ( valeursAutoGenerees.next() ) {

                centre.setIdCentre( valeursAutoGenerees.getInt( 1 ) );
            } else {
                throw new DAOException( "erreur generating Centre ID" );
            }


        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
        }
        for(int i=1;i<=8;i++) {
            Stock stock=new Stock();
            stock.setIdCentre(centre.getIdCentre());
            stock.setQuantiteStock(0);
            stock.setIdGroupeSang(i);
            daoStock.ajouterStock(stock);
        }
    }
    public void modifier(Centre centre) throws IllegalArgumentException, DAOException {

        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet = null;

        try{
            connection=daoFactory.getConnection();
            preparedStatement=connection.prepareStatement(SQL_UPDATE_BYID);
            preparedStatement.setString(1,centre.getEmailCentre());
            preparedStatement.setString(2,centre.getNameCentre());
            preparedStatement.setInt(3,centre.getIdVille());
            preparedStatement.setString(4,centre.getTeleCentre());
            preparedStatement.setString(5,centre.getAdresseCentre());
            preparedStatement.setString(6,centre.getPasswordCentre());
            preparedStatement.setInt(7,centre.getIdCentre());
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
                centre.setIdCentre(result.getInt("id_centre"));
                centre.setPasswordCentre(result.getString("password_centre"));
                centre.setNameCentre(result.getString("nom_centre"));
                centre.setIdVille(result.getInt("id_ville"));
                centre.setAdresseCentre(result.getString("adresse_centre"));
                centre.setEmailCentre(result.getString("email_centre"));
                centre.setTeleCentre(result.getString("telephone_centre"));

                centres.add(centre);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return centres;
    }
}
