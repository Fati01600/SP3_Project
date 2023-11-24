import java.util.ArrayList;
import java.util.List;
public interface Data {

    ArrayList<User> readUserData(String path);

    String[] readMediaData (String path, int length);

    void saveUserData(List<User> users);
}
