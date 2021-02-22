package dao;

import beans.Utilisateur;

import java.util.List;

public interface DAOUtilisateur {
    public Utilisateur trouver(String email ) throws DAOException ;
    public  void creer( Utilisateur utilisateur ) throws IllegalArgumentException, DAOException ;
    public List<Utilisateur> lister() ;
    public List<Utilisateur> getusersByCity(int idVille);
    public Utilisateur getusersByID(Long iduser);
}
