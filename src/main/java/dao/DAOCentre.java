package dao;

import beans.*;

import java.util.List;

public interface DAOCentre {
    public void creer(Centre centre) throws IllegalArgumentException, DAOException;
    public Centre trouver(String email);
    public Centre trouver(int id_centre);
    public void modifier(Centre centre) throws IllegalArgumentException, DAOException;
    public void supprimer(int id_centre);
    public List<Centre> lister();

}
