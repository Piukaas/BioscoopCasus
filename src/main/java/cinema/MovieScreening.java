package cinema;

import java.time.LocalDateTime;

public class MovieScreening {
    private LocalDateTime dateAndTime;
    private double pricePerSeat;
    //arraylist for reserved seats
    private boolean[][] reservedSeats = new boolean[100][100];

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

    public void setSeatReserved(int seatNr, int rowNr) {
        reservedSeats[seatNr][rowNr] = true;
    }

    public boolean isSeatReserved(int seatNr, int rowNr) {
        return reservedSeats[seatNr][rowNr];
    }

    public void removeSeatReservation(int seatNr, int rowNr) {
        reservedSeats[seatNr][rowNr] = false;
    }
}
