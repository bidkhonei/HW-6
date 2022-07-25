package domain;

public class User {
    private int id;
    private String username;
    private String password;
    private String nationalCode;
    private  String birthday;

    public User(int id, String username, String nationalCode1, String nationalCode, String birthday) {
        this.id = id;
        this.username = username;
        this.password = nationalCode;
        this.nationalCode = nationalCode;
        this.birthday = birthday;
    }
    public void changePassword(String password){
        this.password=password;

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getUsername() {
        return username;
    }
}
