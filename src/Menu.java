import javax.swing.border.TitledBorder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {


    private List<Media> allMedia = new ArrayList<>();
    private TextUI ui = new TextUI();


    public void displayStartMenu() {
        ui.displayMessage("Welcome to Chill. The best streaming service on the market!");
    }

    public void displayMainMenu() {
        boolean exit = false;
        while (!exit) {
            String choice = ui.getInput("\nMain menu: " + "\n" + "\n1. View watched list." + "\n2. View saved list." + "\n3. Search."+ "\n4. Logout." + "\n" + "\nChoose an option: ");

            switch (choice) {
                case "1":
                    displayWatchedList();
                    break;
                case "2":
                    displaySavedList();
                    break;
                case "3":
                    searchForMedia();
                    break;
                case "4":
                    logOut();
                    exit = true;
                    break;
                default:
                    ui.displayMessage("Invalid option. Please choose an option from the Main menu..");
                    break;
            }
        }
    }

    private void displaySavedList() {
        ui.displayMessage("Media you've saved: ");
        for (int i = 0; i < StreamingService.currentUser.getSaved().size(); i++) {
            ui.displayMessage((i+1) + StreamingService.currentUser.getSaved().get(i).toString());
        }
            String input = ui.getInput("\nDo you wish to delete any content on your saved list? Y/N ");
           if(input.equalsIgnoreCase("y")){
                ui.displayMessage("Please select the content you wish to delete.");
               int indexToRemove = ui.scan.nextInt();
               if(!(indexToRemove == 0)){
                   StreamingService.currentUser.getSaved().remove(indexToRemove-1);
                   indexToRemove = 0;
               }
            } else{
                   ui.displayMessage("Invalid index, no content removed");
               }if(input.equalsIgnoreCase("n")){
                ui.displayMessage("You're now being sent back to the Main menu.");
                displayMainMenu();
            }
           }

    private void searchForMedia() {
        int i = 0;
        String userInput = ui.getInput("Enter a search word: ");
        for (Media media : StreamingService.media) {
            if(media.getTitle().toLowerCase().contains(userInput.toLowerCase()) || media.getGenre().contains(userInput)) {
                ui.displayMessage((i+1) + ". " + media);
                allMedia.add(media);
                i++;
            }
        }
        userInput = ui.getInput("Do you wish to watch or save any of the content? Y/N");
        if(userInput.equalsIgnoreCase("y")){
            boolean exit = false;
            while (!exit) {
                String choice = ui.getInput("\n1. Save." + "\n2. Watch." + "\n3. Go back to Main menu.");

                switch (choice) {
                    case "1":
                        userInput = ui.getInput("Which type of content do you wish to save?");
                        for (int a = 0; a < allMedia.size(); a++) {
                            if(Integer.parseInt(userInput) == a +1) {
                                ui.displayMessage(allMedia.get(a).getTitle() + " is now saved.");
                                StreamingService.currentUser.userSaved(allMedia.get(a));
                            }
                        }
                        break;
                    case "2":
                        userInput = ui.getInput("Which type of content do you wish to watch?");
                        for (int a = 0; a < allMedia.size(); a++) {
                            if(Integer.parseInt(userInput) == a +1) {
                                ui.displayMessage(allMedia.get(a).getTitle() + " is now playing.");
                                StreamingService.currentUser.userWatched(allMedia.get(a));
                            }
                        }
                        break;
                    case "3":
                        displayMainMenu();
                        break;
                    default:
                        ui.displayMessage("Invalid option. Please choose an option from the Main menu..");
                        break;
                }
            }
        }if(userInput.equalsIgnoreCase("n")){
            displayMainMenu();
        }
        allMedia = new ArrayList<Media>();
    }

    private void logOut() {
        ui.displayMessage("You have been logged out of Chill.");
        StreamingService.currentUser = null;
    }

    private void displayWatchedList() {
        ui.displayMessage("Media you've already watched or want to continue watching: ");
        for (int i = 0; i < StreamingService.currentUser.getWatched().size(); i++) {
            ui.displayMessage(StreamingService.currentUser.getWatched().get(i).toString());
        }
    }
}




