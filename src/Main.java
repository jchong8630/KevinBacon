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
        ArrayList<SimpleMovie> kbActorsMovies =  MovieDatabaseBuilder.getMovieDB("src/kbActorMovies");
//        ArrayList<String> kbActors2ndDegree= MovieDatabaseBuilder.getActors("src/2Degree");
//        try {
//            File f = new File("src/2Degree");
//            f.createNewFile();
//            FileWriter fw = new FileWriter(f);
//            for (String n : kbActorsInMoviesActors) {
//                fw.write(n + "\n");
//            }
//            fw.close();
//        }
//        catch (IOException ioe) {
//            System.out.println("Writing file failed");
//            System.out.println(ioe);
//        }

//
//        try {
//            File f = new File("src/kbActorMovies");
//            f.createNewFile();
//            FileWriter fw = new FileWriter(f);
//            for (SimpleMovie n : kbActorsMovies) {
//                fw.write(n.getTitle() + "---" + n.getActorsStr() + "\n");
//            }
//            fw.close();
//        }
//        catch (IOException ioe) {
//            System.out.println("Writing file failed");
//            System.out.println(ioe);
//        }
        ArrayList<SimpleMovie> actorMovies = new ArrayList<>();
        ArrayList<String> actorMoviesActors = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        System.out.print("Enter an actor's name: ");
        String actor = s.nextLine();

        for (int i = 0; i < movies.size(); i++){
            if (movies.get(i).getActors().contains(actor)){
                actorMovies.add(movies.get(i));
            }
        }
        for (int i = 0; i < actorMovies.size(); i++){
            for (int j = 0; j < actorMovies.get(i).getActors().size(); j++){
                String actorIn = actorMovies.get(i).getActors().get(j);
                if (!(actorMoviesActors.contains(actorIn))){
                    actorMoviesActors.add(actorIn);
                }
            }
        }

        boolean checker = false;
        if (kbActors.contains(actor)){
            System.out.println("Bacon Number: 1");
            checker = true;
        }
        if (checker != true){
            for (int i = 0; i < kbActorsMovies.size(); i++){
                if (kbActorsMovies.get(i).getActors().contains(actor)){
                    System.out.println("Bacon Number: 2");
                    System.out.println(kbActorsMovies.get(i));
                    checker = true;
                    break;
                }
            }
        }
        if (checker != true){
            for (int i = 0; i < actorMoviesActors.size(); i++){
                for (int j = 0; j < kbActorsMovies.size(); j++){
                    if (kbActorsMovies.get(j).getActors().contains(actorMoviesActors.get(i))){
                        System.out.println("Bacon Number: 3");
                        checker = true;
                        System.out.println(kbActorsMovies.get(j));
                        System.out.println(actorMoviesActors.get(i));
                        break;
                    }
                }
                if (checker == true){
                    break;
                }
            }
        }

    }
}