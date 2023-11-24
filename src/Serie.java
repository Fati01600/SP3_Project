import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Serie extends Media {

    private static Map<Integer, Integer> integersSorted;


    Serie(String title, int publicationYear, ArrayList<String> genre , double rating, Map<Integer, Integer> integersSorted) throws IOException {
        super(title, publicationYear, genre, rating);
        this.integersSorted = integersSorted;
    }



    /*public static Map<Integer, Integer> getSeasons(List<String> integers){
        Map<Integer, Integer> result = new HashMap<>();
        for(String season: integers){
            Integer count = result.get(season);
            if(count == null){
                result.put(Integer.valueOf(season), 1);
            }
            else{
                result.put(Integer.valueOf(season), count + 1);
            }
        }
        return result;

        }*/


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

