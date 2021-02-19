package dao;

import beans.Ville;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static dao.DAOUtilitaire.fermeturesSilencieuses;

public class DAOVilleImpl implements DAOVille{

    private static final String SQL_SELECT = "SELECT * FROM  ville";
    private DAOFactory daofactory;

    public DAOVilleImpl(DAOFactory daofactory) {
        this.daofactory = daofactory;
    }
    public List<Ville>  lister() throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Ville>  villes = new ArrayList<Ville>();

        try {
            connection = daofactory.getConnection();
            preparedStatement = connection.prepareStatement( SQL_SELECT );
            resultSet = preparedStatement.executeQuery();
            while ( resultSet.next() ) {
                villes.add( map( resultSet ) );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connection );
        }

        return villes;
    }
    private static Ville map( ResultSet resultSet ) throws SQLException {
        Ville ville= new Ville();
        ville.setIdVille( resultSet.getLong( "id_ville" ) );
        ville.setNomVille( resultSet.getString( "nom_ville" ) );

        return ville;
    }
    public Ville getVilleById(int idVille) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Ville ville;

        try{
            connection = daofactory.getConnection();
            preparedStatement = connection.prepareStatement("SELECT  * from Ville where id_ville = ?");
            preparedStatement.setInt(1, idVille);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                ville = new Ville();
                ville.setIdVille(resultSet.getLong(1));
                ville.setNomVille(resultSet.getString(2));
                preparedStatement.close();
                return ville;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
