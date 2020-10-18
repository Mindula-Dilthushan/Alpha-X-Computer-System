//Alpha-X-Computer-System
//Software Design Alpha X Software Solution
//10-18-20
package entity.custom;

import entity.SuperEntity;

public class Customer implements SuperEntity {
    private String cid;
    private String cname;
    private String caddress;
    private int ccontact;
    private String cemail;

    public Customer() {
    }

    public Customer(String cid, String cname, String caddress, int ccontact, String cemail) {
        this.cid = cid;
        this.cname = cname;
        this.caddress = caddress;
        this.ccontact = ccontact;
        this.cemail = cemail;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCaddress() {
        return caddress;
    }

    public void setCaddress(String caddress) {
        this.caddress = caddress;
    }

    public int getCcontact() {
        return ccontact;
    }

    public void setCcontact(int ccontact) {
        this.ccontact = ccontact;
    }

    public String getCemail() {
        return cemail;
    }

    public void setCemail(String cemail) {
        this.cemail = cemail;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cid='" + cid + '\'' +
                ", cname='" + cname + '\'' +
                ", caddress='" + caddress + '\'' +
                ", ccontact=" + ccontact +
                ", cemail='" + cemail + '\'' +
                '}';
    }
}
