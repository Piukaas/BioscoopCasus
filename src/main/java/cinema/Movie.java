package cinema;

public class Movie {
    private String title;

    public Movie(String title) {
        this.title = title;
    }

    public void addScreening(MovieScreening screening) {
        // ...
    }

    public String toString() {
        return title;
    }
}
