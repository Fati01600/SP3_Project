import java.io.IOException;
import java.util.ArrayList;


public class Serie extends Media {

    private static Map<Integer, Integer> integersSorted;


    Serie(String title, int publicationYear, ArrayList<String> genre , double rating, int season) throws IOException {
        super(title, publicationYear, genre, rating);
        this.integersSorted = integersSorted;
    }


    @Override
    public String getTitle() {
        return super.getTitle();
    }

    public Map<Integer, Integer> getSeason(List<String> integers) {
        return integersSorted;
    }


    @Override
    public String toString() {
        return super.toString() +
                ", " + "Seasons and episodes: " + integersSorted;
    }

}

