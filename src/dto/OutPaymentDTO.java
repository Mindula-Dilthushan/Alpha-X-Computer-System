package dto;

public class OutPaymentDTO {
    private String opid;
    private String soid;
    private String pid;
    private String opDate;
    private double opPrice;

    public OutPaymentDTO() {
    }

    public OutPaymentDTO(String opid, String soid, String pid, String opDate, double opPrice) {
        this.opid = opid;
        this.soid = soid;
        this.pid = pid;
        this.opDate = opDate;
        this.opPrice = opPrice;
    }

    public String getOpid() {
        return opid;
    }

    public void setOpid(String opid) {
        this.opid = opid;
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

    public String getOpDate() {
        return opDate;
    }

    public void setOpDate(String opDate) {
        this.opDate = opDate;
    }

    public double getOpPrice() {
        return opPrice;
    }

    public void setOpPrice(double opPrice) {
        this.opPrice = opPrice;
    }

    @Override
    public String toString() {
        return "OutPaymentDTO{" +
                "opid='" + opid + '\'' +
                ", soid='" + soid + '\'' +
                ", pid='" + pid + '\'' +
                ", opDate='" + opDate + '\'' +
                ", opPrice=" + opPrice +
                '}';
    }
}
