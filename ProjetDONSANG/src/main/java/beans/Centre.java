package beans;

import java.io.Serializable;

public class Centre implements Serializable {
    private int id_ville;
    private String  email_admin;
    private int id_centre;
    private String nom_centre;
    private String adresse_centre;
    private String email_centre;
    private String password_centre;
    private String tel_centre;

    public int getId_ville() {
        return id_ville;
    }

    public void setId_ville(int id_ville) {
        this.id_ville = id_ville;
    }

    public String getEmail_admin() {
        return email_admin;
    }

    public void setEmail_admin(String email_admin) {
        this.email_admin = email_admin;
    }

    public int getId_centre() {
        return id_centre;
    }

    public void setId_centre(int id_centre) {
        this.id_centre = id_centre;
    }

    public String getNom_centre() {
        return nom_centre;
    }

    public void setNom_centre(String nom_centre) {
        this.nom_centre = nom_centre;
    }

    public String getAdresse_centre() {
        return adresse_centre;
    }

    public void setAdresse_centre(String adresse_centre) {
        this.adresse_centre = adresse_centre;
    }

    public String getEmail_centre() {
        return email_centre;
    }

    public void setEmail_centre(String email_centre) {
        this.email_centre = email_centre;
    }

    public String getPassword_centre() {
        return password_centre;
    }

    public void setPassword_centre(String password_centre) {
        this.password_centre = password_centre;
    }

    public String getTel_centre() {
        return tel_centre;
    }

    public void setTel_centre(String tel_centre) {
        this.tel_centre = tel_centre;
    }
}