package view.tm;

public class CustomerTM {
    private String custId;
    private String custName;
    private String custAdd;
    private int custCont;
    private String custEmail;

    public CustomerTM() {
    }

    public CustomerTM(String custId, String custName, String custAdd, int custCont, String custEmail) {
        this.custId = custId;
        this.custName = custName;
        this.custAdd = custAdd;
        this.custCont = custCont;
        this.custEmail = custEmail;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustAdd() {
        return custAdd;
    }

    public void setCustAdd(String custAdd) {
        this.custAdd = custAdd;
    }

    public int getCustCont() {
        return custCont;
    }

    public void setCustCont(int custCont) {
        this.custCont = custCont;
    }

    public String getCustEmail() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }

    @Override
    public String toString() {
        return "CustomerTM{" +
                "custId='" + custId + '\'' +
                ", custName='" + custName + '\'' +
                ", custAdd='" + custAdd + '\'' +
                ", custCont=" + custCont +
                ", custEmail='" + custEmail + '\'' +
                '}';
    }
}
