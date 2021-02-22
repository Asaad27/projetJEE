package dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DAOFactory {

    private static final String FICHIER_PROPERTIES = "dao.properties";
    private static final String PROPERTY_URL = "url";
    private static final String PROPERTY_DRIVER = "driver";
    private static final String PROPERTY_NOM_UTILISATEUR = "nomutilisateur";
    private static final String PROPERTY_MOT_DE_PASSE = "motdepasse";

    private String url;
    private String username;
    private String password;

    public DAOFactory(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    /*
     * Méthode chargée de récupérer les informations de connexion à la base de
     * données, charger le driver JDBC et retourner une instance de la Factory
     */
    public static DAOFactory getInstance() throws DAOConfigurationException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new DAOConfigurationException("Le driver est introuvable dans le classpath.", e);
        }
        DAOFactory instance = new DAOFactory("jdbc:mysql://localhost:3306/sang?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
        return instance;
    }

    /* Méthode chargée de fournir une connexion à la base de données */
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
    public DAOUtilisateurImpl getUtilisateurDao () {
        return new DAOUtilisateurImpl(this);

    }
    public DAOVilleImpl getVilleDAO(){
        return new DAOVilleImpl(this);
    }
    public DAOGroupSangImpl getGroupSangDAO()
    {
        return new DAOGroupSangImpl (this);
    }

    public DAODemandeUtilisateurImpl getDemanadeUtilisateurDAO(){
        return new DAODemandeUtilisateurImpl (this);
    }
    public DAOConcernerImpl getConcernerDAO(){
        return new DAOConcernerImpl(this);
    }
    public DAOAdminImpl getAdminDao () {
        return new DAOAdminImpl(this);
    }

    public DAOCentreImpl getCentreDAO()
    {
        return new DAOCentreImpl(this);
    }

}