package cinema;

import java.time.LocalDateTime;

import cinema.orderStates.ConceptState;

public class MainOrder {
    public static void main(String[] args) {
        // Create a movie
        Movie movie = new Movie("The Matrix");
        Movie otherMovie = new Movie("John Wick");

        // Create a non-weekend movie screening
        LocalDateTime wednesdayDateTime = LocalDateTime.of(2024, 1, 31, 19, 0); // January 31, 2024 is a Wednesday
        MovieScreening movieScreening = new MovieScreening(movie, wednesdayDateTime, 10.0);

        // Create a weekend movie screening
        LocalDateTime saturdayDateTime = LocalDateTime.of(2024, 2, 3, 19, 0); // February 3, 2024 is a Saturday
        MovieScreening weekendMovieScreening = new MovieScreening(movie, saturdayDateTime, 10.0);

        // Add the screenings to the movie
        movie.addScreening(movieScreening);
        otherMovie.addScreening(weekendMovieScreening);

        // Create a non-premium movie ticket
        MovieTicket movieTicket = new MovieTicket(movieScreening, 1, 1, false);

        // Create a premium movie ticket
        MovieTicket premiumMovieTicket = new MovieTicket(movieScreening, 1, 1, true);

        // Create a non-student order
        Order order = new Order(1, false);
        order.addSeat(premiumMovieTicket);
        order.addSeat(movieTicket); // This ticket should be free because it's the second ticket
        System.out.println("The price of the non-student order is: " + order.calculatePrice());

        // Create a student order
        Order studentOrder = new Order(2, true);
        studentOrder.addSeat(premiumMovieTicket);
        studentOrder.addSeat(movieTicket); // This ticket should be free because it's the second
        System.out.println("The price of the student order is: " + studentOrder.calculatePrice());

        // Create a non-student order with 6 tickets for a weekend screening
        Order groupOrder = new Order(3, false);
        for (int i = 0; i < 6; i++) {
            groupOrder.addSeat(new MovieTicket(weekendMovieScreening, 1, i + 1, true));
        }
        System.out.println("The price of the non-student group order is: " + groupOrder.calculatePrice());

        // Test the states
        order.setState(new ConceptState());

        MovieTicket[] tickets = new MovieTicket[] { movieTicket, premiumMovieTicket };
        order.createOrder(tickets);
        order.submitOrder();
        order.remindOrder();
        order.payOrder();
        order.cancelOrder();
    }
}