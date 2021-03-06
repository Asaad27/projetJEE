import dao.DAOFactory;
import dao.DAOUtilisateurImpl;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Test3 {
    @Test
    public void testLister(){
        DAOFactory daoFactory=DAOFactory.getInstance();
        DAOUtilisateurImpl utilisateur=daoFactory.getUtilisateurDao();
        assertEquals(2 , utilisateur.getusersByCity(1).size());
    }
}
