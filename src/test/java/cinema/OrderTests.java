package cinema;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderTests {
    private Movie movie;
    private Movie otherMovie;
    private LocalDateTime wednesdayDateTime;
    private LocalDateTime saturdayDateTime;
    private MovieScreening movieScreening;
    private MovieScreening weekendMovieScreening;
    private MovieTicket regularMovieTicket;
    private MovieTicket premiumMovieTicket;
    @BeforeEach
    void setUp() {
        movie = new Movie("The Matrix");
        otherMovie = new Movie("John Wick");
        // Wednesday
        wednesdayDateTime = LocalDateTime.of(2024, 1, 31, 19, 0);
        movieScreening = new MovieScreening(movie, wednesdayDateTime, 10.0);
        // Saturday
        saturdayDateTime = LocalDateTime.of(2024, 2, 3, 19, 0);
        weekendMovieScreening = new MovieScreening(otherMovie, saturdayDateTime, 10.0);
        regularMovieTicket = new MovieTicket(movieScreening, 1, 1, false);
        premiumMovieTicket = new MovieTicket(movieScreening, 1, 1, true);
    }

    @Test
    void testCalculatePrice_StudentOrderThreeTickets() {
        // Create a student order
        Order studentOrder = new Order(2, true);
        studentOrder.addSeatReservation(regularMovieTicket);
        studentOrder.addSeatReservation(regularMovieTicket);
        studentOrder.addSeatReservation(regularMovieTicket);
        assertEquals(20.0, studentOrder.calculatePrice());
    }    

    @Test
    void testCalculatePrice_StudentOrderFourTickets() {
        Order studentOrder = new Order(2, true);
        studentOrder.addSeatReservation(regularMovieTicket);
        studentOrder.addSeatReservation(regularMovieTicket);
        studentOrder.addSeatReservation(regularMovieTicket);
        studentOrder.addSeatReservation(regularMovieTicket);
        assertEquals(20.0, studentOrder.calculatePrice());
    }

}
