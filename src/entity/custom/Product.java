package entity.custom;

import entity.SuperEntity;

public class Product implements SuperEntity {
    private String pid;
    private String pbrand;
    private String pname;
    private String pdesc;
    private int pqty;
    private double pprice;

    public Product() {
    }

    public Product(String pid, String pbrand, String pname, String pdesc, int pqty, double pprice) {
        this.pid = pid;
        this.pbrand = pbrand;
        this.pname = pname;
        this.pdesc = pdesc;
        this.pqty = pqty;
        this.pprice = pprice;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPbrand() {
        return pbrand;
    }

    public void setPbrand(String pbrand) {
        this.pbrand = pbrand;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    public int getPqty() {
        return pqty;
    }

    public void setPqty(int pqty) {
        this.pqty = pqty;
    }

    public double getPprice() {
        return pprice;
    }

    public void setPprice(double pprice) {
        this.pprice = pprice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid='" + pid + '\'' +
                ", pbrand='" + pbrand + '\'' +
                ", pname='" + pname + '\'' +
                ", pdesc='" + pdesc + '\'' +
                ", pqty=" + pqty +
                ", pprice=" + pprice +
                '}';
    }
}
