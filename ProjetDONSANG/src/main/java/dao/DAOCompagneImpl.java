package dao;

import beans.Compagne;
import beans.DemandeCentre;
import beans.DemandeUtilisateur;
import beans.Utilisateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static dao.DAOUtilitaire.fermeturesSilencieuses;
import static dao.DAOUtilitaire.initialisationRequetePreparee;

public class DAOCompagneImpl implements DAOCompagne{
    private static final String SQL_INSERT = "INSERT INTO compagne(date_compagne,description_compagne,id_centre,titre_compagne,image_compagne) VALUES(?,?,?,?,?)";
    private static final String SQL_SELECT = "SELECT * from compagne";
    private static final String SQL_NB_ROWS=" SELECT FOUND_ROWS()";
    private DAOFactory daoFactory;
    private int nbRecords;


    public DAOCompagneImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public int getNbRecords() {
        return nbRecords;
    }

    public void setNbRecords(int nbRecords) {
        this.nbRecords = nbRecords;
    }

    public static Compagne map(ResultSet resultSet ) throws SQLException {
        Compagne compagne=new Compagne();
        compagne.setIdCompagne( resultSet.getInt( "id_compagne" ) );
        compagne.setTitreCompagne( resultSet.getString( "titre_compagne" ) );
        compagne.setDescriptionCompagne( resultSet.getString( "description_compagne" ) );
        compagne.setDateCompagne( resultSet.getString( "date_compagne" ) );
        compagne.setImageComapgne( resultSet.getString( "image_compagne" ) );
        compagne.setIdcentre( resultSet.getInt( "id_centre" ) );



        return compagne;
    }

    public boolean addCompagne(Compagne compagne) throws DAOException {


        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;
        boolean etat=false;
        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_INSERT, true,
                    compagne.getDateCompagne(), compagne.getDescriptionCompagne(),compagne.getIdcentre() , compagne.getTitreCompagne(),compagne.getImageComapgne());
            int statue = preparedStatement.executeUpdate();
            if (statue == 0) {
                etat=false;
                throw new DAOException("�chec de la cr�ation de la demande , aucune ligne ajout�e dans la table.");
            }else{
                etat=true;
            }
            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
            if (valeursAutoGenerees.next()) {
                compagne.setIdCompagne(valeursAutoGenerees.getInt(1));
            } else {
                throw new DAOException("�chec de la cr�ation de l'utilisateur en base, aucun ID auto-g�n�r� retourn�.");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connexion);
        }
        return etat;

    }
    public List<Compagne> getComapagne() throws DAOException{
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Compagne> listes=new ArrayList<Compagne>();
        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_SELECT, false);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                listes.add(map(resultSet));

            }
            resultSet.close();
            resultSet=preparedStatement.executeQuery(SQL_NB_ROWS);
            if(resultSet.next()){
                setNbRecords(resultSet.getInt(1));
            }


        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses( resultSet,preparedStatement, connexion);
        }

        return listes;
    }
}
