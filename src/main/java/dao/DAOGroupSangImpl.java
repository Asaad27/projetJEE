package dao;

import beans.GroupSang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static dao.DAOUtilitaire.fermeturesSilencieuses;


public class DAOGroupSangImpl implements DAOGroupSang{
    private static final String SQL_SELECT = "SELECT * FROM  groupesang";
    private DAOFactory daofactory;

    public DAOGroupSangImpl(DAOFactory daofactory) {
        this.daofactory = daofactory;
    }
    public List<GroupSang>  lister() throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<GroupSang>  groupes = new ArrayList<GroupSang>();

        try {
            connection = daofactory.getConnection();
            preparedStatement = connection.prepareStatement( SQL_SELECT );
            resultSet = preparedStatement.executeQuery();
            while ( resultSet.next() ) {
                groupes.add( map( resultSet ) );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connection );
        }

        return groupes;
    }
    private static GroupSang map( ResultSet resultSet ) throws SQLException {
        GroupSang groupe= new GroupSang();
        groupe.setIdGroupe( resultSet.getLong( "id_groupe" ) );
        groupe.setNomGroupe( resultSet.getString( "libelle_groupe" ) );

        return groupe;
    }
}
