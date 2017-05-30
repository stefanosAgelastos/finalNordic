package model;

/**
 * Created by aSeddik on 13-May-17.
 */
public class SalesAssistant implements Employee {
    public SalesAssistant(int id, String username, int password) {
        this.id=id;
        this.username=username;
        this.password=password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String username;
    private int password;
    private int id;

    @Override
    public boolean identify(String username, int password) {
        if(username.equals(this.username) && password==this.password){
            return true;
        }
        return false;
    }
}
