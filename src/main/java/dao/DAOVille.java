package dao;

import beans.Ville;

import java.util.List;

public interface DAOVille {
      public List<Ville> lister() throws DAOException;
      public Ville getVilleById(int idVille);
}
