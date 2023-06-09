package entity;

public class User {
    private int id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String nastionalCode;

    public User(int id, String firstname, String lastname, String username, String password, String nastionalCode) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.nastionalCode = nastionalCode;
    }

    public User(String firstname, String lastname, String username, String password, String nastionalCode) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.nastionalCode = nastionalCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNastionalCode() {
        return nastionalCode;
    }

    public void setNastionalCode(String nationalCode) {
        this.nastionalCode = nationalCode;
    }

    @Override
    public String toString() {
        return this.firstname + "," + this.lastname + "," + this.username + "," + this.password + "," +  this.nastionalCode;
    }
}
