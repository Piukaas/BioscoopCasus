package cinema;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cinema.orderStates.CancelledState;
import cinema.orderStates.ConceptState;
import cinema.orderStates.CreatedState;
import cinema.orderStates.HandledState;
import cinema.orderStates.ProvisionalState;

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
    private MovieTicket[] tickets;

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
        regularMovieTicketWeekDay = new MovieTicket(movieScreening, 1, 1, false);
        premiumMovieTicketWeekDay = new MovieTicket(movieScreening, 1, 1, true);
        regularMovieTicketWeekend = new MovieTicket(weekendMovieScreening, 1, 1, false);
        premiumMovieTicketWeekend = new MovieTicket(weekendMovieScreening, 1, 1, true);
        studentOrder = new Order(2, true);
        order = new Order(1, false);
        order.setState(new ConceptState());
        tickets = new MovieTicket[] { regularMovieTicketWeekDay, premiumMovieTicketWeekDay };
    }

    // State tests
    @Test
    void testCreateOrder() {
        MovieTicket[] tickets = new MovieTicket[] { regularMovieTicketWeekDay, premiumMovieTicketWeekDay };
        order.createOrder(tickets);
        assertTrue(order.getState() instanceof CreatedState,
                "Order state should be CreatedState after calling createOrder");
    }

    @Test
    void testSubmitOrder() {
        order.submitOrder();
        assertTrue(order.getState() instanceof ConceptState,
                "Order state should still be ConceptState after calling submitOrder before createOrder");
    }

    @Test
    void testPayOrder() {
        order.createOrder(tickets);
        order.submitOrder();
        order.payOrder();
        assertTrue(order.getState() instanceof HandledState,
                "Order state should be HandledState after calling payOrder");
    }

    @Test
    void testRemindOrder() {
        order.createOrder(tickets);
        order.submitOrder();
        order.remindOrder();
        assertTrue(order.getState() instanceof ProvisionalState,
                "Order state should be ProvisionalState after calling remindOrder");
    }

    @Test
    void testCancelOrder() {
        order.createOrder(tickets);
        order.cancelOrder();
        assertTrue(order.getState() instanceof CancelledState,
                "Order state should be CancelledState after calling cancelOrder");
    }

    // calculatePrice tests
    @Test
    void testCalculatePrice_StudentOrderThreeTickets() {
        studentOrder.addSeat(regularMovieTicketWeekDay);
        studentOrder.addSeat(regularMovieTicketWeekDay);
        studentOrder.addSeat(regularMovieTicketWeekDay);
        assertEquals(20.0, studentOrder.calculatePrice());
    }

    @Test
    void testCalculatePrice_StudentOrderFourTickets() {
        studentOrder.addSeat(regularMovieTicketWeekDay);
        studentOrder.addSeat(regularMovieTicketWeekDay);
        studentOrder.addSeat(regularMovieTicketWeekDay);
        studentOrder.addSeat(regularMovieTicketWeekDay);
        assertEquals(20.0, studentOrder.calculatePrice());
    }

    @Test
    void testCalculatePrice_StudentOrderTwoPremiumTickets() {
        studentOrder.addSeat(premiumMovieTicketWeekDay);
        studentOrder.addSeat(premiumMovieTicketWeekDay);
        assertEquals(12.0, studentOrder.calculatePrice());
    }

    @Test
    void testCalculatePrice_StudentOrderThreePremiumTickets() {
        studentOrder.addSeat(premiumMovieTicketWeekDay);
        studentOrder.addSeat(premiumMovieTicketWeekDay);
        studentOrder.addSeat(premiumMovieTicketWeekDay);
        assertEquals(24.0, studentOrder.calculatePrice());
    }

    @Test
    void testCalculatePrice_regularOrderOnWeekDaySecondTicketFree() {
        order.addSeat(regularMovieTicketWeekDay);
        order.addSeat(regularMovieTicketWeekDay);
        assertEquals(10.0, order.calculatePrice());
    }

    @Test
    void testCalculatePrice_regularOrderOnWeekendIsFullPrice() {
        order.addSeat(regularMovieTicketWeekend);
        order.addSeat(regularMovieTicketWeekend);
        assertEquals(20.0, order.calculatePrice());
    }

    @Test
    void testCalculatePrice_studentOrderOnWeekendSecondTicketFree() {
        studentOrder.addSeat(regularMovieTicketWeekend);
        studentOrder.addSeat(regularMovieTicketWeekend);
        assertEquals(10.0, studentOrder.calculatePrice());
    }

    @Test
    void testCalculatePrice_regularWeekendOrderMoreThanSixTicketsGetTenPercentOff() {
        // add a loop for adding 7 regular tickets
        for (int i = 0; i < 7; i++) {
            order.addSeat(regularMovieTicketWeekend);
        }
        assertEquals(63.0, order.calculatePrice());
    }

    @Test
    void testCalculatePrice_premiumWeekendOrderMoreThanSixTicketsGetTenPercentOff() {
        // add a loop for adding 7 premium tickets
        for (int i = 0; i < 7; i++) {
            order.addSeat(premiumMovieTicketWeekend);
        }
        assertEquals(81.9, order.calculatePrice());
    }

}
