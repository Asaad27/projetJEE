package beans;

import java.sql.Timestamp;
import java.util.ArrayList;

public class DemandeCentre {
    private int idDemande;
    private int idcentre;
    private Timestamp dateDemande;
    private String descriptionDemande;
    private boolean estUrgente;
    private String titreDemande;
    private boolean estActive;
    private ArrayList<concerner> sangGroups = new ArrayList<concerner>();


    public ArrayList<concerner> getSangGroups()
    {
        return sangGroups;
    }
    public void setSangGroups(ArrayList<concerner> sangGroups) {
        this.sangGroups = sangGroups;
    }




    public int getIdDemande() {
        return idDemande;
    }
    public void setIdDemande(int idDemande) {
        this.idDemande = idDemande;
    }

    public Timestamp getDateDemande() {
        return dateDemande;
    }
    public void setDateDemande(Timestamp dateDemande)
    {
        this.dateDemande = dateDemande;
    }
    public String getDescriptionDemande() {
        return descriptionDemande;
    }
    public void setDescriptionDemande(String descriptionDemande) {
        this.descriptionDemande = descriptionDemande;
    }
    public boolean isEstUrgente() {
        return estUrgente;
    }
    public void setEstUrgente(boolean estUrgente) {
        this.estUrgente = estUrgente;
    }

    public boolean isEstActive() {
        return estActive;
    }
    public void setEstActive(boolean estActive) {
        this.estActive = estActive;
    }
    public String getTitreDemande() {
        return titreDemande;
    }
    public void setTitreDemande(String titreDemande) {
        this.titreDemande = titreDemande;
    }

    public int getIdcentre() {
        return idcentre;
    }

    public void setIdcentre(int idcentre) {
        this.idcentre = idcentre;
    }
}
