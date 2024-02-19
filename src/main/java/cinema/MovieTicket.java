package cinema;

import java.time.LocalDateTime;

public class MovieTicket {
    private int rowNr;
    private int seatNr;
    private boolean isPremium;
    private MovieScreening movieScreening;

    public MovieTicket(MovieScreening movieScreening, int rowNr, int seatNr, boolean isPremium) {
        this.movieScreening = movieScreening;
        this.rowNr = rowNr;
        this.seatNr = seatNr;
        this.isPremium = isPremium;
    }

    public boolean isPremiumTicket() {
        return isPremium;
    }

    public double getPrice() {
        return movieScreening.getPricePerSeat();
    }

    public LocalDateTime getScreeningDate() {
        return movieScreening.getDate();
    }

    public String toString() {
        return "Row " + rowNr + ", seat " + seatNr + ", premium: " + isPremium;
    }

    public MovieScreening getScreening() {
        return movieScreening;
    }

    public int getRowNr() {
        return rowNr;
    }

    public int getSeatNr() {
        return seatNr;
    }
}