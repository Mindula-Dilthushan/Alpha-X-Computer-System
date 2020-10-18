package entity.custom;

import entity.SuperEntity;

public class OutPayment implements SuperEntity {
    private String opid;
    private String soid;
    private String pid;
    private String opDate;
    private double opPrice;

    public OutPayment() {
    }

    public OutPayment(String opid, String soid, String pid, String opDate, double opPrice) {
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
        return "OutPayment{" +
                "opid='" + opid + '\'' +
                ", soid='" + soid + '\'' +
                ", pid='" + pid + '\'' +
                ", opDate='" + opDate + '\'' +
                ", opPrice=" + opPrice +
                '}';
    }
}
