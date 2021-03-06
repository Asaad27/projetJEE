package dao;

import beans.*;
import java.util.List;

public interface DAOConcerner {
     boolean setAllGroupsConcerned(DemandeUtilisateur demande) throws DAOException,IllegalArgumentException;
    List<concerner> getAllGroupesConcerned(int idDemande ) throws DAOException;
    boolean deleteConcerneDemande(int idDemande, int idGroupeSang) throws DAOException;
    boolean setAllGroupsConcernedCentre(DemandeCentre demande) throws DAOException,IllegalArgumentException;
}
