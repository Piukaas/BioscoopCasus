package cinema;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import cinema.notifications.OrderObserver;
import cinema.orderStates.CreatedState;
import cinema.orderStates.IOrderState;

public class Order {
    private IOrderState         state;
    private int                 orderNr;
    private boolean             isStudentOrder;
    private List<MovieTicket>   tickets   = new ArrayList<>();
    private List<OrderObserver> observers = new ArrayList<>();

    public Order(int orderNr, boolean isStudentOrder) {
        this.orderNr = orderNr;
        this.isStudentOrder = isStudentOrder;
        this.state = new CreatedState();
    }

    public int getOrderNr() {
        return orderNr;
    }

    public boolean isStudentOrder() {
        return isStudentOrder;
    }

    public List<MovieTicket> getTickets() {
        return tickets;
    }

    public void setState(IOrderState state) {
        this.state = state;
    }

    public IOrderState getState() {
        return state;
    }

    public void addSeat(MovieTicket ticket) {
        tickets.add(ticket);
    }

    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers(String message) {
        for (OrderObserver observer : observers) {
            observer.update(message);
        }
    }

    public void reserveSeats() {
        for (MovieTicket ticket : tickets) {
            MovieScreening screening = ticket.getScreening();
            screening.setSeatReserved(ticket.getSeatNr(), ticket.getRowNr());
        }
    }

    public void removeSeatReservation() {
        for (MovieTicket ticket : tickets) {
            MovieScreening screening = ticket.getScreening();
            screening.removeSeatReservation(ticket.getSeatNr(), ticket.getRowNr());
        }
    }

    public double calculatePrice() {
        double total = 0.0;
        int ticketCount = 0;
        boolean isWeekend = false;

        for (MovieTicket ticket : tickets) {
            LocalDateTime screeningDate = ticket.getScreeningDate();
            isWeekend = screeningDate.getDayOfWeek().getValue() >= 5;

            double ticketPrice = ticket.getPrice();
            if (ticket.isPremiumTicket()) {
                ticketPrice += isStudentOrder ? 2 : 3;
            }

            if (isStudentOrder || !isWeekend) {
                // Every second ticket is free for students or on weekdays
                if (ticketCount % 2 == 0) {
                    total += ticketPrice;
                }
            } else {
                total += ticketPrice;
            }

            // group discount
            if (tickets.size() >= 6) {
                ticketPrice *= 0.1; // Apply 10% group discount
                total -= ticketPrice;
            }
            ticketCount++;
        }

        return total;
    }

    public void submitOrder() {
        state.submitOrder(this);
    }

    public void cancelOrder() {
        state.cancelOrder(this);
    }

    public void payOrder() {
        state.payOrder(this);
    }

    public void remindOrder() {
        state.remindOrder(this);
    }

    public void createOrder(MovieTicket[] tickets) {
        state.createOrder(this, tickets);
    }
}
