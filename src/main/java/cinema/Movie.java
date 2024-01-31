package cinema;

import java.util.ArrayList;

public class Movie {
    private String title;
    private ArrayList<MovieScreening> screenings = new ArrayList<>();

    public Movie(String title) {
        this.title = title;
    }

    public void addScreening(MovieScreening screening) {
        screenings.add(screening);
    }

    public String toString() {
        return title;
    }
}
