import java.sql.*;
import java.util.*;

import static java.lang.Integer.*;


public class DBConnector implements Data {
    //database URL
    //JDBC = Java Database Connectivity

    // database URL
    static final String DB_URL = "jdbc:mysql://localhost/my_streaming";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "Szb49pmg..";


    //movie
    public Set<Media> readMovieData(){

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            //STEP 1: Vi Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //STEP 2: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 3: Execute a query
            System.out.println("Creating statement...");
            String sql = "SELECT * FROM movie";
            stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery(sql);

            Set<Media> media = new HashSet<>();

            //STEP 4: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name

                String name = rs.getString("title");
                String genres = rs.getString("genre");
                ArrayList<String> genre = new ArrayList<>();
                String[] genreSorted = genres.split(",");
                for (String g : genreSorted) {
                    genre.add(g.replace(" ", ""));
                }
                int year = parseInt(rs.getString("year"));
                double rating = Double.parseDouble(rs.getString("rating"));
                Media m = new Movie(name, year, genre, rating);
                media.add(m);
            }


            //STEP 5: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();

            return media;
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {

                try {
                    if (stmt != null)
                        stmt.close();
                } catch (SQLException se2) {
                }
            }
        }
        return null;
    }

    //Serie
    public Set<Media> readSerieData() {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            //STEP 1: Vi Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //STEP 2: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "SELECT * FROM serie_table";
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);

            Set<Media> media = new HashSet<>();

            while (rs.next()) {

                String title = rs.getString("title");
                String genres = rs.getString("genre");
                ArrayList<String> genre = new ArrayList<>();
                String[] genreSorted = genres.split(",");
                for (String g : genreSorted) {
                    genre.add(g.replace(" ", ""));
                }
                String years = rs.getString("year");
                String[] splitYear = years.trim().split("-");
                int year = splitYear.length;
                //String year = rs.getString("year"); //I vores database er det en string ( den indeholder bøde start og slut år)
                double rating = Double.parseDouble(rs.getString("rating"));//samme her
                String seasons = rs.getString("season");
                String[] splitSeason = seasons.trim().split("-");
                int season = splitSeason.length;
                Media m = new Serie(title, year, genre, rating, season);
                media.add(m);
            }

            //STEP 5: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();

            return media;

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {

                try {
                    if (stmt != null)
                        stmt.close();
                } catch (SQLException se2) {
                }
            }
        }
        return null;
    }


    public ArrayList<User> readUserData(String path){
        return null;
    }

    @Override
    public void saveUserData(List<User> users){
    }

    @Override
    public void saveWatchedMedia(List<Media> watched) {
    }

    @Override
    public void saveSavedMedia(List<Media> saved) {
    }

    public String[] readMediaData (String path, int length){
        return null;
    }

}




