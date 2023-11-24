import java.util.ArrayList;
import java.util.List;

public class User {

    private String userName;
    private String password;
    private List<Media> watched = new ArrayList<>();
    private List<Media> saved = new ArrayList<>();


    User(String userName, String password){
        this.userName = userName;
        this.password = password;
    }

    public void userWatched(Media m){
        watched.add(m);

    }

    public void userSaved(Media m){
        saved.add(m);

    }
    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public List<Media> getWatched() {
        return watched;
    }

    public List<Media> getSaved() {
        return saved;
    }


    public String toString() {
        return "You are no logged in " + userName + "!";
    }

}

