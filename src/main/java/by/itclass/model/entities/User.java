package by.itclass.model.entities;

public class User {
    private int id;
    private String login;
    private String email;
    private String image;

    public User() {
    }

    public User(String login) {
        this.login = login;
    }

    public User(String login, String email) {
        this.login = login;
        this.email = email;
    }

    public User(int id, String login, String email) {
        this.id = id;
        this.login = login;
        this.email = email;
    }

    public User(int id, String login, String email, String image) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getIdString() {
        return Integer.toString(id);
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}