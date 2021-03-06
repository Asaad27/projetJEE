

import beans.Utilisateur;
import dao.DAOFactory;
import dao.DAOUtilisateurImpl;
import org.jboss.arquillian.container.test.api.Deployment;

import org.jboss.arquillian.container.test.api.RunAsClient;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import javax.inject.Inject;
import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertTrue;

@RunWith(Arquillian.class)
public class ArquillianTest {

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(DAOUtilisateurImpl.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

   @Test
  public void utilisateurTest(){
       DAOFactory daoFactory=DAOFactory.getInstance();
       DAOUtilisateurImpl utilisateur=daoFactory.getUtilisateurDao();
       assertTrue(!utilisateur.lister().isEmpty());
       System.out.println(String.format("Total des utilisateurs %d", utilisateur.lister().size()));
       assertEquals(4 , utilisateur.lister().size());
    }
}
