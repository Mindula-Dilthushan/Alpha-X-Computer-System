package dto;

public class SupplierOrderDetailDTO {
    private String soid;
    private String pid;
    private String sodQty;
    private double sodPrice;

    public SupplierOrderDetailDTO() {
    }

    public SupplierOrderDetailDTO(String soid, String pid, String sodQty, double sodPrice) {
        this.soid = soid;
        this.pid = pid;
        this.sodQty = sodQty;
        this.sodPrice = sodPrice;
    }

    public String getSoid() {
        return soid;
    }

    public void setSoid(String soid) {
        this.soid = soid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getSodQty() {
        return sodQty;
    }

    public void setSodQty(String sodQty) {
        this.sodQty = sodQty;
    }

    public double getSodPrice() {
        return sodPrice;
    }

    public void setSodPrice(double sodPrice) {
        this.sodPrice = sodPrice;
    }

    @Override
    public String toString() {
        return "SupplierOrderDetailDTO{" +
                "soid='" + soid + '\'' +
                ", pid='" + pid + '\'' +
                ", sodQty='" + sodQty + '\'' +
                ", sodPrice=" + sodPrice +
                '}';
    }
}
