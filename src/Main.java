import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<SimpleMovie> movies = MovieDatabaseBuilder.getMovieDB("src/movie_data");
        ArrayList<String> kbActors = MovieDatabaseBuilder.getActors("src/ActorNames");
        ArrayList<SimpleMovie> kbActorsMovies =  MovieDatabaseBuilder.getMovieDB("src/kbActorMovies");
        ArrayList<SimpleMovie> kbMovies = MovieDatabaseBuilder.getMovieDB("src/kbMovies");
        ArrayList<SimpleMovie> actorMovies = new ArrayList<>();
        ArrayList<String> actorMoviesActors = new ArrayList<>();
        ArrayList<SimpleMovie> actorMoviesActorsMovies = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        String actor = "";
            System.out.print("Enter an actor's name: ");
            actor = s.nextLine();

            for (SimpleMovie value : movies) {
                if (value.getActors().contains(actor)) {
                    actorMovies.add(value);
                }
            }
            for (SimpleMovie simpleMovie : actorMovies) {
                for (int j = 0; j < simpleMovie.getActors().size(); j++) {
                    String actorIn = simpleMovie.getActors().get(j);
                    if (!(actorMoviesActors.contains(actorIn))) {
                        actorMoviesActors.add(actorIn);
                    }
                }
            }

            for (SimpleMovie movie : movies) {
                for (String actorMoviesActor : actorMoviesActors) {
                    if (movie.getActors().contains(actorMoviesActor)) {
                        actorMoviesActorsMovies.add(movie);
                        break;
                    }
                }
            }
            boolean checker = false;
            if (kbActors.contains(actor)) {
                System.out.println("Bacon Number: 1");
                for (SimpleMovie kbMovie : kbMovies) {
                    if (kbMovie.getActors().contains(actor)) {
                        System.out.println(actor + " --> " + kbMovie.getTitle() + "  --> Kevin Bacon\n");
                        break;
                    }
                }
                checker = true;
            }
            if (!checker) {
                for (SimpleMovie kbActorsMovie : kbActorsMovies) {
                    if (kbActorsMovie.getActors().contains(actor)) {
                        System.out.println("Bacon Number: 2");
                        String mainMovie = kbActorsMovie.getTitle();
                        checker = true;
                        for (int k = 0; k < kbActorsMovie.getActors().size(); k++) {
                            String nextActor = kbActorsMovie.getActors().get(k);
                            if (kbActors.contains(nextActor)) {
                                for (SimpleMovie kbMovie : kbMovies) {
                                    if (kbMovie.getActors().contains(nextActor)) {
                                        String nextMovie = kbMovie.getTitle();
                                        System.out.println(nextMovie);
                                        System.out.println(actor + " --> " + mainMovie + " --> " + nextActor + " --> " + nextMovie + "  --> Kevin Bacon\n");
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                        break;
                    }
                }
            }
            if (!checker) {
                for (String actorMoviesActor : actorMoviesActors) {
                    for (SimpleMovie kbActorsMovie : kbActorsMovies) {
                        if (kbActorsMovie.getActors().contains(actorMoviesActor)) {
                            String mainMovie = "";
                            System.out.println("Bacon Number: 3");
                            checker = true;
                            for (SimpleMovie actorMovie : actorMovies) {
                                if (actorMovie.getActors().contains(actorMoviesActor)) {
                                    mainMovie = actorMovie.getTitle();
                                }
                            }
                            for (int k = 0; k < kbActorsMovie.getActors().size(); k++) {
                                if (kbActors.contains(kbActorsMovie.getActors().get(k))) {
                                    String actorTwo = kbActorsMovie.getActors().get(k);
                                    for (SimpleMovie kbMovie : kbMovies) {
                                        if (kbMovie.getActors().contains(actorTwo)) {
                                            String movieTwo = kbMovie.getTitle();
                                            System.out.println(actor + " --> " + mainMovie + " --> " + actorMoviesActor + " --> " + kbActorsMovie.getTitle() + " --> " + actorTwo + " --> " + movieTwo + "  --> Kevin Bacon\n");
                                            break;
                                        }
                                    }
                                    break;
                                }
                            }
                            break;

                        }
                    }
                    if (checker) {
                        break;
                    }
                }
            }
            if (!checker) {
                String firstActor = "";
                System.out.println("Bacon Number: 4");
                for (SimpleMovie actorMoviesActorsMovie : actorMoviesActorsMovies) {
                    for (int j = 0; j < kbActorsMovies.size(); j++) {
                        for (int k = 0; k < actorMoviesActorsMovie.getActors().size(); k++) {
                            if (kbActorsMovies.get(j).getActors().contains((actorMoviesActorsMovie.getActors().get(k)))) {
                                firstActor = actorMoviesActorsMovie.getActors().get(k);
                                SimpleMovie mainMovie = null;
                                String ogActor = "";
                                for (String actorMoviesActor : actorMoviesActors) {
                                    if (actorMoviesActorsMovie.getActors().contains(actorMoviesActor)) {
                                        ogActor = actorMoviesActor;
                                        for (SimpleMovie actorMovie : actorMovies) {
                                            if (actorMovie.getActors().contains(ogActor)) {
                                                mainMovie = actorMovie;
                                            }
                                        }
                                    }
                                }
                                for (SimpleMovie kbActorsMovie : kbActorsMovies) {
                                    if (kbActorsMovie.getActors().contains(firstActor)) {
                                        for (String kbActor : kbActors) {
                                            if (kbActorsMovie.getActors().contains(kbActor)) {
                                                for (SimpleMovie kbMovie : kbMovies) {
                                                    if (kbMovie.getActors().contains(kbActor)) {
                                                        System.out.println(actor + " --> " + mainMovie.getTitle() + " --> " + ogActor + " --> " + actorMoviesActorsMovie.getTitle() + " --> " + firstActor + " --> " + kbActorsMovie.getTitle() + " --> " + kbActor + " --> " + kbMovie.getTitle() + "  --> Kevin Bacon\n");
                                                        break;
                                                    }
                                                }
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                        if (firstActor != "") {
                            break;
                        }
                    }
                    if (firstActor != "") {
                        break;
                    }
                }
            }
    }
}