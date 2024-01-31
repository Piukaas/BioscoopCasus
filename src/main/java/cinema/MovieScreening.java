package cinema;

import java.time.LocalDate;

public class MovieScreening {
    private LocalDate dateAndTime;
    private double pricePerSeat;

    public MovieScreening(Movie movie, LocalDate dateAndTime, double pricePerSeat) {
        this.dateAndTime = dateAndTime;
        this.pricePerSeat = pricePerSeat;
    }

    public double getPricePerSeat() {
        return pricePerSeat;
    }

    public String toString() {
        return dateAndTime.toString() + " " + pricePerSeat;
    }
}
