package dao;
import beans.*;
import java.util.List;

public interface DAOStock {
   public boolean ajouterStock(Stock stock) throws DAOException ;
   public boolean modifierStock(Stock stock) throws DAOException ;
   public List<Stock> getStock(int idCentre ) throws DAOException ;
}
