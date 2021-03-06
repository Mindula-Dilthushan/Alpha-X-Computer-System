package dto;

public class SupplierDTO {
    private String sid;
    private String sname;
    private String saddress;
    private int scontact;
    private String semail;

    public SupplierDTO() {
    }

    public SupplierDTO(String sid, String sname, String saddress, int scontact, String semail) {
        this.sid = sid;
        this.sname = sname;
        this.saddress = saddress;
        this.scontact = scontact;
        this.semail = semail;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSaddress() {
        return saddress;
    }

    public void setSaddress(String saddress) {
        this.saddress = saddress;
    }

    public int getScontact() {
        return scontact;
    }

    public void setScontact(int scontact) {
        this.scontact = scontact;
    }

    public String getSemail() {
        return semail;
    }

    public void setSemail(String semail) {
        this.semail = semail;
    }

    @Override
    public String toString() {
        return "SupplierDTO{" +
                "sid='" + sid + '\'' +
                ", sname='" + sname + '\'' +
                ", saddress='" + saddress + '\'' +
                ", scontact=" + scontact +
                ", semail='" + semail + '\'' +
                '}';
    }
}
