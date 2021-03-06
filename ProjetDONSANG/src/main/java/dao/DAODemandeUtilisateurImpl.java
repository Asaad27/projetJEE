package dao;

import beans.DemandeUtilisateur;
import beans.concerner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import static dao.DAOUtilitaire.*;

public class DAODemandeUtilisateurImpl implements DAODemandeUtilisateur {
    private static final String SQL_INSERT = "INSERT INTO demandeutil(date_demande,description_demande,estActive,estUrgente,id_utilisateur,titre_demande) VALUES(?,?,?,?,?,?);";
    private static final String SQL_SELECT_Demande = "SELECT demandeutil.id_demandeUtil,demandeutil.titre_demande,demandeutil.estUrgente,demandeutil.estActive  ," +
            "demandeutil.id_utilisateur,demandeutil.date_demande ,demandeutil.description_demande FROM demandeutil,utilisateur WHERE utilisateur.id_utilisateur=demandeutil.id_utilisateur and demandeutil.estActive=?  and utilisateur.id_ville= ? ORDER BY demandeutil.date_demande DESC";
    private static final String SQL_UPDATE = "update demandeutil set estActive=? where id_demandeUtil=?";
    private static final String SQL_SELECT_USER = "select * from demandeutil where id_utilisateur= ? and estActive=?";
    private static final String SQL_SELECT_USERDEMANDE= "select * from demandeutil where id_utilisateur= ? ORDER BY id_utilisateur  DESC";
    private static final String SQL_NB_ROWS = " SELECT FOUND_ROWS()";
    private DAOFactory daoFactory;
    private DAOConcernerImpl concerner;
    private int nbRecords;

    public int getNbRecords() {
        return nbRecords;
    }

    public void setNbRecords(int nbRecords) {
        this.nbRecords = nbRecords;
    }

    public DAODemandeUtilisateurImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
        concerner = daoFactory.getConcernerDAO();
    }

    public DemandeUtilisateur map(ResultSet resultSet) throws SQLException {
        DemandeUtilisateur demande = new DemandeUtilisateur();
        demande.setIdDemande(resultSet.getInt("id_demandeUtil"));
        demande.setTitreDemande(resultSet.getString("titre_demande"));
        demande.setDescriptionDemande(resultSet.getString("description_demande"));
        demande.setEstUrgente(resultSet.getBoolean("estUrgente"));
        demande.setEstActive(resultSet.getBoolean("estActive"));
        demande.setIdutilisateur(resultSet.getLong("id_utilisateur"));
        demande.setDateDemande(resultSet.getTimestamp("date_demande"));
        demande.setSangGroups(concerner.getAllGroupesConcerned(resultSet.getInt("id_demandeUtil")));


        return demande;
    }


    public boolean addDemande(DemandeUtilisateur demande) throws DAOException {


        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;
        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_INSERT, true,
                    demande.getDateDemande(), demande.getDescriptionDemande(), demande.isEstActive(), demande.isEstUrgente(), demande.getIdutilisateur(), demande.getTitreDemande());
            int statue = preparedStatement.executeUpdate();
            if (statue == 0) {
                throw new DAOException("�chec de la cr�ation de la demande , aucune ligne ajout�e dans la table.");
            }
            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
            if (valeursAutoGenerees.next()) {
                demande.setIdDemande(valeursAutoGenerees.getInt(1));
            } else {
                throw new DAOException("�chec de la cr�ation de l'utilisateur en base, aucun ID auto-g�n�r� retourn�.");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connexion);
        }
        if (concerner.setAllGroupsConcerned(demande))
            return true;
        return false;
    }

    public List<DemandeUtilisateur> getAllDemands(int id_ville) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<DemandeUtilisateur> listes=new ArrayList<DemandeUtilisateur>();
        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_SELECT_Demande, false, 1,id_ville);
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
    public List<DemandeUtilisateur> getDemandsUser(Long idUser) throws DAOException{
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<DemandeUtilisateur> listes=new ArrayList<DemandeUtilisateur>();
        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_SELECT_USER, false, idUser,1);
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
            fermeturesSilencieuses(resultSet, preparedStatement, connexion);
        }
        return listes;
    }
    public boolean updateDemande(int idDemande) throws DAOException{
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        boolean etat=false;
        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_UPDATE, false, 0,idDemande);
            int statue = preparedStatement.executeUpdate();
            if (statue == 0) {
                etat=false;
                throw new DAOException("�chec de la modification de la demande.");

            }else{
                etat=true;
            }

        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(preparedStatement, connexion);
        }
        return etat;

    }
    public List<DemandeUtilisateur> getAllDemandsUser(Long idUser) throws DAOException{
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<DemandeUtilisateur> listes=new ArrayList<DemandeUtilisateur>();
        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_SELECT_USERDEMANDE, false, idUser);
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
            fermeturesSilencieuses(resultSet, preparedStatement, connexion);
        }
        return listes;
    }
}


