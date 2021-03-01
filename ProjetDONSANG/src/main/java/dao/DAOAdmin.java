package dao;
import beans.Admin;
import beans.Utilisateur;

import java.util.List;

public interface DAOAdmin {
    public void creer(Admin admin) throws IllegalArgumentException, DAOException;
    public Admin trouver(String email);
    public void supprimer(int idAdmin);
    public List<Admin> lister();
    public Admin getAdminsByID(int idAdmin);
}