import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<SimpleMovie> movies = MovieDatabaseBuilder.getMovieDB("src/movie_data");
//        for (SimpleMovie movie : movies) {
//            System.out.println(movie);
//        }
//        System.out.println("Number of movies: " + movies.size());
        ArrayList<String> kbActors = MovieDatabaseBuilder.getActors("src/ActorNames");
        ArrayList<SimpleMovie> kbActorsMovies = new ArrayList<>();
        for (int i = 0; i < movies.size(); i++){
            for (int j = 0; j < kbActors.size(); j++){
                if (movies.get(i).getActors().contains(kbActors.get(j))){
                        kbActorsMovies.add(movies.get(i));
                }
            }
        }
        System.out.println(kbActorsMovies);
        Scanner s = new Scanner(System.in);
        System.out.println("Enter an actor's name: ");
        String actor = s.nextLine();


    }
}