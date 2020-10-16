package view.tm;

public class ProductTM {
    private String proID;
    private String proBrand;
    private String proName;
    private String proDesc;
    private int proQty;
    private double proPrice;

    public ProductTM() {
    }

    public ProductTM(String proID, String proBrand, String proName, String proDesc, int proQty, double proPrice) {
        this.proID = proID;
        this.proBrand = proBrand;
        this.proName = proName;
        this.proDesc = proDesc;
        this.proQty = proQty;
        this.proPrice = proPrice;
    }

    public String getProID() {
        return proID;
    }

    public void setProID(String proID) {
        this.proID = proID;
    }

    public String getProBrand() {
        return proBrand;
    }

    public void setProBrand(String proBrand) {
        this.proBrand = proBrand;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProDesc() {
        return proDesc;
    }

    public void setProDesc(String proDesc) {
        this.proDesc = proDesc;
    }

    public int getProQty() {
        return proQty;
    }

    public void setProQty(int proQty) {
        this.proQty = proQty;
    }

    public double getProPrice() {
        return proPrice;
    }

    public void setProPrice(double proPrice) {
        this.proPrice = proPrice;
    }

    @Override
    public String toString() {
        return "ProductTM{" +
                "proID='" + proID + '\'' +
                ", proBrand='" + proBrand + '\'' +
                ", proName='" + proName + '\'' +
                ", proDesc='" + proDesc + '\'' +
                ", proQty=" + proQty +
                ", proPrice=" + proPrice +
                '}';
    }
}
