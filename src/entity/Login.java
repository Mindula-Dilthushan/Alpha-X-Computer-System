package entity;

public class Login {
    private int tp;
    private String pw;

    public Login() {
    }
    public Login(int tp, String pw) {
        this.tp = tp;
        this.pw = pw;
    }

    public int getTp() {
        return tp;
    }

    public void setTp(int tp) {
        this.tp = tp;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    @Override
    public String toString() {
        return "Login{" +
                "tp=" + tp +
                ", pw='" + pw + '\'' +
                '}';
    }
}
