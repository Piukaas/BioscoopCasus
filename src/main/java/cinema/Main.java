package cinema;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        // Create a movie
        Movie movie = new Movie("The Matrix");

        // Create a movie screening
        LocalDateTime dateAndTime = LocalDateTime.now();
        double pricePerSeat = 10.0;
        MovieScreening movieScreening = new MovieScreening(movie, dateAndTime, pricePerSeat);

        // Add the screening to the movie
        movie.addScreening(movieScreening);

        // Create a movie ticket
        int rowNr = 1;
        int seatNr = 1;
        boolean isPremium = true;
        MovieTicket movieTicket = new MovieTicket(movieScreening, rowNr, seatNr, isPremium);

        // Create an order and add the ticket to it
        boolean isStudentOrder = false;
        Order order = new Order(1, isStudentOrder);
        order.addSeatReservation(movieTicket);

        // Calculate the price of the order
        double price = order.calculatePrice();
        System.out.println("The price of the order is: " + price);
    }
}