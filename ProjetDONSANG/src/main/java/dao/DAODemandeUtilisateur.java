package dao;
import beans.DemandeUtilisateur;
import java.util.List;
public interface DAODemandeUtilisateur {
   public boolean addDemande(DemandeUtilisateur demande) throws DAOException;
   public List<DemandeUtilisateur> getAllDemands(int id_ville) throws DAOException;
   public boolean updateDemande(int idDemande) throws DAOException;
   public List<DemandeUtilisateur> getDemandsUser(Long idUser) throws DAOException;


}
