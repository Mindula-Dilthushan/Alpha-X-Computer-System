//Alpha-X-Computer-System
//Software Design Alpha X Software Solution
//10-17-20
package view.tm;

public class SupplierTM {
    private String supID;
    private String supName;
    private String supAdd;
    private int supCont;
    private String supEmail;

    public SupplierTM() {
    }

    public SupplierTM(String supID, String supName, String supAdd, int supCont, String supEmail) {
        this.supID = supID;
        this.supName = supName;
        this.supAdd = supAdd;
        this.supCont = supCont;
        this.supEmail = supEmail;
    }

    public String getSupID() {
        return supID;
    }

    public void setSupID(String supID) {
        this.supID = supID;
    }

    public String getSupName() {
        return supName;
    }

    public void setSupName(String supName) {
        this.supName = supName;
    }

    public String getSupAdd() {
        return supAdd;
    }

    public void setSupAdd(String supAdd) {
        this.supAdd = supAdd;
    }

    public int getSupCont() {
        return supCont;
    }

    public void setSupCont(int supCont) {
        this.supCont = supCont;
    }

    public String getSupEmail() {
        return supEmail;
    }

    public void setSupEmail(String supEmail) {
        this.supEmail = supEmail;
    }

    @Override
    public String toString() {
        return "SupplierTM{" +
                "supID='" + supID + '\'' +
                ", supName='" + supName + '\'' +
                ", supAdd='" + supAdd + '\'' +
                ", supCont=" + supCont +
                ", supEmail='" + supEmail + '\'' +
                '}';
    }
}
