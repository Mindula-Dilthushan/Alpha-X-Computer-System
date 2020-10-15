package dto;

public class LoginDTO {
    private int tp;
    private String pw;

    public LoginDTO() {
    }

    public LoginDTO(int tp, String pw) {
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
        return "LoginDTO{" +
                "tp=" + tp +
                ", pw='" + pw + '\'' +
                '}';
    }
}
