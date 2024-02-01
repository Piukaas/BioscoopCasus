package cinema;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderTest {
    private Movie movie;
    private Movie otherMovie;
    private LocalDateTime wednesdayDateTime;
    private LocalDateTime saturdayDateTime;
    private MovieScreening movieScreening;
    private MovieScreening weekendMovieScreening;
    private MovieTicket regularMovieTicketWeekDay;
    private MovieTicket premiumMovieTicketWeekDay;
    private MovieTicket regularMovieTicketWeekend;
    private MovieTicket premiumMovieTicketWeekend;
    private Order studentOrder;
    private Order order;

    @BeforeEach
    void setUp() 
    {
        movie = new Movie("The Matrix");
        otherMovie = new Movie("John Wick");
        // Wednesday
        wednesdayDateTime = LocalDateTime.of(2024, 1, 31, 19, 0);
        movieScreening = new MovieScreening(movie, wednesdayDateTime, 10.0);
        // Saturday
        saturdayDateTime = LocalDateTime.of(2024, 2, 3, 19, 0);
        weekendMovieScreening = new MovieScreening(otherMovie, saturdayDateTime, 10.0);
        regularMovieTicketWeekDay = new MovieTicket(movieScreening, 1, 1, false);
        premiumMovieTicketWeekDay = new MovieTicket(movieScreening, 1, 1, true);
        regularMovieTicketWeekend = new MovieTicket(weekendMovieScreening, 1, 1, false);
        premiumMovieTicketWeekend = new MovieTicket(weekendMovieScreening, 1, 1, true);
        studentOrder = new Order(2, true);
        order = new Order(1, false);
    }

    @Test
    void testCalculatePrice_StudentOrderThreeTickets() 
    {
        studentOrder.addSeatReservation(regularMovieTicketWeekDay);
        studentOrder.addSeatReservation(regularMovieTicketWeekDay);
        studentOrder.addSeatReservation(regularMovieTicketWeekDay);
        assertEquals(20.0, studentOrder.calculatePrice());
    }

    @Test
    void testCalculatePrice_StudentOrderFourTickets() 
    {
        studentOrder.addSeatReservation(regularMovieTicketWeekDay);
        studentOrder.addSeatReservation(regularMovieTicketWeekDay);
        studentOrder.addSeatReservation(regularMovieTicketWeekDay);
        studentOrder.addSeatReservation(regularMovieTicketWeekDay);
        assertEquals(20.0, studentOrder.calculatePrice());
    }

    @Test
    void testCalculatePrice_StudentOrderTwoPremiumTickets() 
    {
        studentOrder.addSeatReservation(premiumMovieTicketWeekDay);
        studentOrder.addSeatReservation(premiumMovieTicketWeekDay);
        assertEquals(12.0, studentOrder.calculatePrice());
    }

    @Test
    void testCalculatePrice_StudentOrderThreePremiumTickets() 
    {
        studentOrder.addSeatReservation(premiumMovieTicketWeekDay);
        studentOrder.addSeatReservation(premiumMovieTicketWeekDay);
        studentOrder.addSeatReservation(premiumMovieTicketWeekDay);
        assertEquals(24.0, studentOrder.calculatePrice());
    }

    @Test
    void testCalculatePrice_regularOrderOnWeekDaySecondTicketFree() 
    {
        order.addSeatReservation(regularMovieTicketWeekDay);
        order.addSeatReservation(regularMovieTicketWeekDay);
        assertEquals(10.0, order.calculatePrice());
    }

    @Test
    void testCalculatePrice_regularOrderOnWeekendIsFullPrice() 
    {
        order.addSeatReservation(regularMovieTicketWeekend);
        order.addSeatReservation(regularMovieTicketWeekend);
        assertEquals(20.0, order.calculatePrice());
    }

    @Test
    void testCalculatePrice_studentOrderOnWeekendSecondTicketFree() 
    {
        studentOrder.addSeatReservation(regularMovieTicketWeekend);
        studentOrder.addSeatReservation(regularMovieTicketWeekend);
        assertEquals(10.0, studentOrder.calculatePrice());
    }

    @Test
    void testCalculatePrice_regularWeekendOrderMoreThanSixTicketsGetTenPercentOff() 
    {
        //add a loop for adding 7 regular tickets
        for (int i = 0; i < 7; i++) {
            order.addSeatReservation(regularMovieTicketWeekend);
        }
        assertEquals(63.0, order.calculatePrice());
    }

    @Test
    void testCalculatePrice_premiumWeekendOrderMoreThanSixTicketsGetTenPercentOff()
    {
        //add a loop for adding 7 premium tickets
        for (int i = 0; i < 7; i++) {
            order.addSeatReservation(premiumMovieTicketWeekend);
        }
        assertEquals(81.9, order.calculatePrice());
    }

}
