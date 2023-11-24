import java.util.ArrayList;

public class Movie extends Media{

    Movie(String title, int publicationYear, ArrayList<String> genre, double rating){
        super(title, publicationYear, genre, rating);
    }

    @Override
    public String getTitle() {
        return super.getTitle();
    }

    @Override
    public String toString() {
        return super.toString();
    }

}