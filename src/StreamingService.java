import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StreamingService {

    public static User currentUser;
    private TextUI ui = new TextUI();
    private FileIO io = new FileIO();
    public static ArrayList<Media> media = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();
    private Menu menu = new Menu();

    public void setup() throws IOException {

        String[] movieData = io.readMediaData("data/100bedstefilm.txt", 100);
        media = createMedia(movieData, "Movies");

        String[] serieData = io.readMediaData("data/series.txt", 100);
        createMedia(serieData, "Series");

        users = io.readUserData("data/User.txt");

        menu.displayStartMenu();
        runSignInDialog();
        menu.displayMainMenu();

    }

    public void runSignInDialog() {
        if (ui.getInput("Are you a current user and do you wish to sign in? Y/N").equalsIgnoreCase("Y")) {
            String username = ui.getInput("Enter your username: ");
            String password = ui.getInput("Enter your password: ");
            for(User u: users){
                if(u.getUserName().equals(username)){
                    if(u.getPassword().equals(password)){
                        currentUser = u;
                    }
                    else {
                        ui.displayMessage("Password or username is incorrect. Please try again.");
                        runSignInDialog();
                    }
                }
            }
            if(currentUser == null){
                ui.displayMessage("Unsuccessfull login, please try again.");
                runSignInDialog();
            }
            System.out.println(currentUser.toString());
        } else {
            runSignUpDialog();
        }
    }

    public void runSignUpDialog() {
        String input = "";
        String inputName = "";
        String inputPassword = "";
            input = ui.getInput("Do you wish to create a user? Y/N");
            if (input.equalsIgnoreCase("n")) {
                ui.displayMessage("Have a good day!");
                System.exit(0);
            }
            if (input.equalsIgnoreCase("y")) {
                ui.displayMessage("Then go ahead and sign up!");
                inputName = ui.getInput("Create a username: ");
                inputPassword = ui.getInput("Create a password: ");
                ui.displayMessage("Congrats! You have now created a profile and you're signed in.");
                registerUser(inputName, inputPassword);
            }
        }

    private void registerUser(String userName, String password){
        User user = new User(userName, password);
        currentUser = user;
        users.add(user);
        io.saveUserData(users);
    }

    public ArrayList<Media> createMedia(String[] data, String type) throws IOException {
        for (int i = 0; i < data.length; i++) {
            String[] sorted = data[i].split(";");
            String title = sorted[0];
            ArrayList<String> genre = new ArrayList<>();
            String [] genreSorted = sorted[2].split(",");
            for(String g: genreSorted){
                genre.add(g.replace(" ", ""));
            }
            double rating = Double.parseDouble(sorted[3].replace(",", ".").trim());
            Media m = null;
            if(type.equals("Movies")) {
                int publicationYear = Integer.parseInt(sorted[1].trim());
                m = new Movie(title, publicationYear, genre, rating);
            } else if(type.equals("Series")) {
                Map<Integer, Integer> integersSorted = new HashMap<>();
                String[] list = sorted[4].split(",");
                for (String s : list) {
                    String[] strArr = s.split("-");
                    integersSorted.put(Integer.parseInt(strArr[0].trim()), Integer.parseInt(strArr[1].trim()));
                }
                int publicationYear = Integer.parseInt(sorted[1].split("-")[0].trim());
                m = new Serie(title, publicationYear, genre, rating, integersSorted);
            }
            media.add(m);
        }
        return media;
    }

}

