package dao;

import beans.DemandeCentre;
import beans.DemandeUtilisateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static dao.DAOUtilitaire.fermeturesSilencieuses;
import static dao.DAOUtilitaire.initialisationRequetePreparee;

public class DAODemandeCentreImpl implements DAODemandeCentre{
    private static final String SQL_INSERT = "INSERT INTO demandecentre(date_demande,description_demande,estActive,estUrgente,id_centre,titre_demande) VALUES(?,?,?,?,?,?);";
    private DAOFactory daoFactory;
    private DAOConcernerImpl concerner;
    public DAODemandeCentreImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
        concerner = daoFactory.getConcernerDAO();
    }

    public boolean addDemandeCentre(DemandeCentre demande) throws DAOException {


        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;
        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_INSERT, true,
                    demande.getDateDemande(), demande.getDescriptionDemande(), demande.isEstActive(), demande.isEstUrgente(), demande.getIdcentre(), demande.getTitreDemande());
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
        if (concerner.setAllGroupsConcernedCentre(demande))
            return true;
        return false;
    }
}
