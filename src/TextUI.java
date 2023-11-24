import java.util.Scanner;

public class TextUI {

    public Scanner scan = new Scanner(System.in);

    public String getInput(String msg){
        this.displayMessage(msg);
        return scan.nextLine();
    }

    public void displayMessage(String msg){
        System.out.println(msg);
    }

    /*public int getNumericInput(String msg){
        System.out.println(msg);//Stille brugeren et spørgsmål

        // int input = scan.nextInt();
        // This is ok, but BEWARE OF THE SCANNERBUG: When using nextInt() right before nextLine(): the nextLine call will be skipped...
        // fix this by simply calling nextLine() once before you actually need it
        // Another fix: read it as string, then parse it:

        String input = scan.nextLine();              //Give brugere et sted at placere sit svar og vente på svaret
        int num = 0;
        try {
            num = Integer.parseInt(input);           //Konvertere svaret til et tal

        }catch(NumberFormatException e){
            System.out.println("This was not a number, " + e.getMessage());
            num = getNumericInput(msg);
        }
        return num;

    }*/
}