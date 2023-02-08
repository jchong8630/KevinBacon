import java.util.ArrayList;

public class SimpleMovie {
    private String title;
    private String actorsData;
    private ArrayList<String> actors;

    public SimpleMovie(String t, String a) {
        title = t;
        actorsData = a;
        actors = new ArrayList<String>();
        String[] tempActors = actorsData.split(":");
        for (int i = 0; i < tempActors.length; i++) {
            actors.add(tempActors[i]);
        }

    }

    public ArrayList<String> getActors() {
        return actors;
    }

    public String getActorsStr() {
        String str = "";
        for (int i = 0; i < actors.size(); i++){
            str += actors.get(i) + ":";
        }
        return str;
    }

    public String getTitle(){
        return title;
    }

    public String toString() {
        return "Title: " + title + "\n" + "Actors: " + actors + "\n";
    }
}