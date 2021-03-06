package beans;

public class Stock {
    private int idGroupeSang;
    private int idCentre;
    private double quantiteStock;

    public Stock(int idGroupeSang, double quantiteStock) {
        this.idGroupeSang = idGroupeSang;
        this.quantiteStock = quantiteStock;
    }
    public Stock(){
        super();
    }

    public int getIdGroupeSang() {
        return idGroupeSang;
    }

    public void setIdGroupeSang(int idGroupeSang) {
        this.idGroupeSang = idGroupeSang;
    }

    public int getIdCentre() {
        return idCentre;
    }

    public void setIdCentre(int idCentre) {
        this.idCentre = idCentre;
    }

    public double getQuantiteStock() {
        return quantiteStock;
    }

    public void setQuantiteStock(double quantiteStock) {
        this.quantiteStock = quantiteStock;
    }
}
