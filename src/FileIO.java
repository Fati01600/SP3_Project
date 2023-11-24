import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileIO implements Data {

    @Override
    public ArrayList<User> readUserData(String path) {
        ArrayList<User> data = new ArrayList<>();
        File file = new File(path);
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String s = scan.nextLine();
                String[] userDetails = s.split(",");
                User u = new User(userDetails[0], userDetails[1]);
                data.add(u);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return data;
    }

    @Override
    public void saveUserData(List<User> users) {
        try {
            //PrintWriter har flere konstruktører, den tager flere forskellige typer af agumenter. Såsom file, string.
            //Den understøtter metoden som vi kender for at være println (håndtere forskellige datatyper).
            PrintWriter writer = new PrintWriter("data/User.txt");
            for (User u : users) {
                String textTosave = u.getUserName() + "," + u.getPassword();
                writer.write(textTosave + "\n");//
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error: Unable to save user data.");
        }
    }

    @Override
    public String[] readMediaData (String path, int length) {
        int count = 0;
        String[] data = new String[length];
        File file = new File(path);
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String s = scan.nextLine();
                data[count] = s;
                count++;
            }
        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        return data;
    }
}