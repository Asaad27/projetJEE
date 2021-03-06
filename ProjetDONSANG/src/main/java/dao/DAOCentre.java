package dao;

import beans.*;

import java.util.List;

public interface daoCentre {
    public Centre trouver(String email ) throws DAOException ;
    public Centre getCentreById(int idcentre) throws DAOException ;
    public void creer(Centre centre) throws IllegalArgumentException, DAOException;
    public  void modifier(Centre centre) throws IllegalArgumentException, DAOException;
    public void supprimer(int id_centre);
    public List<Centre> lister();

}
