package cinema;

import java.time.LocalDateTime;
import java.util.ArrayList;

import cinema.export.ExportStrategy;
import cinema.export.JsonExportStrategy;
import cinema.export.PlaintextExportStrategy;
import cinema.pricing.GroupPricingStrategy;
import cinema.pricing.PricingStrategy;
import cinema.pricing.StandardPricingStrategy;

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

    public boolean isStudentOrder() {
        return isStudentOrder;
    }

    public ArrayList<MovieTicket> getTickets() {
        return tickets;
    }

    public void addSeatReservation(MovieTicket ticket) {
        tickets.add(ticket);
    }

    public double calculatePrice() {
        double total = 0.0;
        int ticketCount = 0;
        boolean isWeekend = false;
        PricingStrategy pricingStrategy = new StandardPricingStrategy();
        for (MovieTicket ticket : tickets) {
            LocalDateTime screeningDate = ticket.getScreeningDate();
            isWeekend = screeningDate.getDayOfWeek().getValue() >= 5;

            if (tickets.size() > 6) {
                pricingStrategy = new GroupPricingStrategy();
            } else {
                pricingStrategy = new StandardPricingStrategy();
            }
            double ticketPrice = pricingStrategy.calculatePrice(ticket, isStudentOrder, isWeekend);

            if (isStudentOrder || !isWeekend) {
                // Every second ticket is free for students or on weekdays
                if (ticketCount % 2 == 0) {
                    total += ticketPrice;
                }
            } else {
                total += ticketPrice;
            }
            ticketCount++;
        }

        return total;
    }

    public void export(TicketExportFormat exportFormat) {
        ExportStrategy exportStrategy = new JsonExportStrategy();
        if (exportFormat == TicketExportFormat.PLAINTEXT) {
            exportStrategy = new PlaintextExportStrategy();
        }
        exportStrategy.export(this);
    }
}
