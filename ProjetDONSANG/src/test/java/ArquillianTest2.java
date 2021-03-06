import beans.Centre;
import beans.Utilisateur;
import dao.DAOFactory;
import dao.*;
import org.jboss.arquillian.container.test.api.Deployment;

import org.jboss.arquillian.container.test.api.RunAsClient;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import javax.inject.Inject;
import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertTrue;

@RunWith(Arquillian.class)
public class ArquillianTest2 {

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(daoCentreImpl.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void centreTest(){

        DAOFactory daoFactory=DAOFactory.getInstance();
        daoCentreImpl centreDAO=daoFactory.getCentreDAO();
        Assertions.assertEquals(3,centreDAO.lister().size());
        Centre centre=new Centre();
        centre.setNameCentre("centre4");
        centre.setEmailCentre("centre4@gmail.com");
        centre.setPasswordCentre("1234567");
        centre.setIdVille(1);
        centreDAO.creer(centre);
        Assertions.assertEquals(4,centreDAO.lister().size());
        centreDAO.supprimer(5);
        Assertions.assertEquals(3,centreDAO.lister().size());
    }
}
