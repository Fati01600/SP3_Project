import java.util.ArrayList;

public class Media {

    private String title;
    private ArrayList<String> genre;
    private double rating;
    private int publicationYear;

    Media(String title, int publicationYear, ArrayList<String> genre, double rating){
        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.publicationYear = publicationYear;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<String> getGenre() {
        return genre;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public double getRating() {
        return rating;
    }

    /*public Movie displayTitle(){
        Movie m = movies.get(count);
        count++;
        if(count >= movies.size()){
            count = 0;
        }
        return m;
    }*/

    public void displayGenre(){
        // fÃ¥ lagt genre i en liste
    }

    @Override
    public String toString() {
        return "Title: " + title + ", " +
                "Genre: " + genre  + ", " +
                "Rating: " + rating + ", " +
                "PublicationYear: " + publicationYear;

    }
}

