package entity.custom;

import entity.SuperEntity;

public class SupplierOrder implements SuperEntity {

    private String soid;
    private String sid;
    private String sodate;

    public SupplierOrder() {
    }

    public SupplierOrder(String soid, String sid, String sodate) {
        this.soid = soid;
        this.sid = sid;
        this.sodate = sodate;
    }

    public String getSoid() {
        return soid;
    }

    public void setSoid(String soid) {
        this.soid = soid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSodate() {
        return sodate;
    }

    public void setSodate(String sodate) {
        this.sodate = sodate;
    }

    @Override
    public String toString() {
        return "SupplierOrder{" +
                "soid='" + soid + '\'' +
                ", sid='" + sid + '\'' +
                ", sodate='" + sodate + '\'' +
                '}';
    }
}
