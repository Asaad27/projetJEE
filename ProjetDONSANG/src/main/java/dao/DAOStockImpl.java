package dao;

import beans.Stock;
import beans.Utilisateur;
import beans.Ville;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static dao.DAOUtilitaire.fermeturesSilencieuses;
import static dao.DAOUtilitaire.initialisationRequetePreparee;

public class DAOStockImpl implements DAOStock{
    private static final String SQL_INSERT = "INSERT INTO stock (id_groupe,id_centre,quantiteSang) VALUES (?, ?, ?)";
    private static final String SQL_UPDATE = "update stock set quantiteSang = ? where id_centre=? and id_groupe= ?";
    private static final String SQL_SELECT = "select * from stock  where id_centre=?";
    private DAOFactory daoFactory;
    public static Stock map(ResultSet resultSet ) throws SQLException {
       Stock stock= new Stock();
        stock.setIdCentre( resultSet.getInt( "id_centre" ) );
        stock.setIdGroupeSang( resultSet.getInt( "id_groupe" ) );
        stock.setQuantiteStock( resultSet.getDouble( "quantiteSang" ) );
        return stock;
    }

    public DAOStockImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
    public boolean ajouterStock(Stock stock) throws DAOException{
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        boolean etat=false;
        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_INSERT, false,stock.getIdGroupeSang(), stock.getIdCentre(),stock.getQuantiteStock());
            int statue = preparedStatement.executeUpdate();
            if (statue == 0) {
                etat=false;
                throw new DAOException("�chec de la cr�ation de la demande , aucune ligne ajout�e dans la table.");
            }else{
                etat=true;
            }

        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses( preparedStatement, connexion);
        }
        return etat;
    }
    public boolean modifierStock(Stock stock) throws DAOException{
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        boolean etat=false;
        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_UPDATE, false,stock.getQuantiteStock(), stock.getIdCentre(),stock.getIdGroupeSang());
            int statue = preparedStatement.executeUpdate();
            if (statue == 0) {
                etat=false;
                throw new DAOException("�chec de la cr�ation de la demande , aucune ligne ajout�e dans la table.");
            }else{
                etat=true;
            }

        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses( preparedStatement, connexion);
        }
        return etat;
    }
    public List<Stock> getStock(int idCentre ) throws DAOException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Stock>  stocks = new ArrayList<Stock>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connection,SQL_SELECT,false,idCentre );
            resultSet = preparedStatement.executeQuery();
            while ( resultSet.next() ) {
                stocks.add( map( resultSet ) );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connection );
        }

        return stocks;
    }
}
