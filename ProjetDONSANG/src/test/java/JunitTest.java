import dao.DAOFactory;
import dao.DAOUtilisateurImpl;
import org.junit.Test;
import static org.junit.Assert.*;
public class JunitTest {
    @Test
    public void testLister(){
        DAOFactory daoFactory=DAOFactory.getInstance();
        DAOUtilisateurImpl utilisateur=daoFactory.getUtilisateurDao();
        assertTrue(!utilisateur.lister().isEmpty());
        System.out.println(String.format("Total des utilisateurs %d", utilisateur.lister().size()));
        assertEquals(4 , utilisateur.lister().size());
    }

}
