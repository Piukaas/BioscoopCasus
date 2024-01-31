package cinema;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
    private int orderNr;
    private boolean isStudentOrder;
    private ArrayList<MovieTicket> tickets = new ArrayList<>();

    public Order(int orderNr, boolean isStudentOrder) {
        this.orderNr = orderNr;
        this.isStudentOrder = isStudentOrder;
    }

    public int getOrderNr() {
        return orderNr;
    }

    public void addSeatReservation(MovieTicket ticket) {
        tickets.add(ticket);
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
                // On weekends, non-students pay full price unless the order consists of 6 or more tickets
                total += ticketPrice;
                if (tickets.size() >= 6) {
                    total *= 0.9; // Apply 10% group discount
                }
            }

            ticketCount++;
        }

        return total;
    }

    public void export(TicketExportFormat exportFormat) {
        // ...
    }
}
