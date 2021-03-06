import beans.Centre;
import dao.*;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test2 {
    @Test
    public void testadd(){

        DAOFactory daoFactory=DAOFactory.getInstance();
        daoCentreImpl centreDAO=daoFactory.getCentreDAO();
        assertEquals(3,centreDAO.lister().size());
        Centre centre=new Centre();
        centre.setNameCentre("centre4");
        centre.setEmailCentre("centre4@gmail.com");
        centre.setPasswordCentre("1234567");
        centre.setIdVille(1);
        centreDAO.creer(centre);
        assertEquals(4,centreDAO.lister().size());
        centreDAO.supprimer(5);
        assertEquals(3,centreDAO.lister().size());
    }

}
