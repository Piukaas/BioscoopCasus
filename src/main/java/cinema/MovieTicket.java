package cinema;

public class MovieTicket {
    private int rowNr;
    private int seatNr;
    private boolean isPremium;

    public MovieTicket(MovieScreening movieScreening, int rowNr, int seatNr, boolean isPremium) {
        this.rowNr = rowNr;
        this.seatNr = seatNr;
        this.isPremium = isPremium;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public double getPrice() {
        return 0.0;
    }

    public String toString() {
        return "Row " + rowNr + ", seat " + seatNr + ", premium: " + isPremium;
    }
}
