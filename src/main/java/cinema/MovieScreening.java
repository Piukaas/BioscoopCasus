package cinema;

import java.time.LocalDateTime;

public class MovieScreening {
    private LocalDateTime dateAndTime;
    private double pricePerSeat;

    public MovieScreening(Movie movie, LocalDateTime dateAndTime, double pricePerSeat) {
        this.dateAndTime = dateAndTime;
        this.pricePerSeat = pricePerSeat;
    }

    public LocalDateTime getDate() {
        return dateAndTime;
    }

    public double getPricePerSeat() {
        return pricePerSeat;
    }

    public String toString() {
        return dateAndTime.toString() + " " + pricePerSeat;
    }
}
