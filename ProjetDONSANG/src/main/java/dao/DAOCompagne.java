package dao;

import beans.Compagne;
import java.util.List;

public interface DAOCompagne {
    public boolean addCompagne(Compagne compagne) throws DAOException;
    public List<Compagne> getComapagne() throws DAOException;
}
