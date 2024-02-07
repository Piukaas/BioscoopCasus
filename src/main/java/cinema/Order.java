package cinema;

import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import cinema.pricing.GroupPricingStrategy;
import cinema.pricing.PricingStrategy;
import cinema.pricing.StandardPricingStrategy;

public class Order {
    private int orderNr;
    private boolean isStudentOrder;
    private ArrayList<MovieTicket> tickets = new ArrayList<>();
    private static int count = 0;

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
        PricingStrategy pricingStrategy = new StandardPricingStrategy();
        for (MovieTicket ticket : tickets) {
            LocalDateTime screeningDate = ticket.getScreeningDate();
            isWeekend = screeningDate.getDayOfWeek().getValue() >= 5;

            if(tickets.size() > 6) {
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
        switch (exportFormat) {
            case PLAINTEXT:
                exportToPlainText();
                break;
            case JSON:
                exportToJson();
                break;
        }
    }

    private void exportToPlainText() {
        StringBuilder sb = new StringBuilder();
        for (MovieTicket ticket : tickets) {
            sb.append(ticket.toString()).append("\n");
        }

        try {
            Files.createDirectories(Paths.get("orders"));
            try (PrintWriter out = new PrintWriter("orders/order_" + count + ".txt")) {
                out.println(sb.toString());
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void exportToJson() {
        JSONObject jsonOrder = new JSONObject();
        jsonOrder.put("orderNr", this.orderNr);
        jsonOrder.put("isStudentOrder", this.isStudentOrder);

        JSONArray jsonTickets = new JSONArray();
        for (MovieTicket ticket : tickets) {
            JSONObject jsonTicket = new JSONObject();
            jsonTicket.put("screeningDate", ticket.getScreeningDate().toString());
            jsonTicket.put("isPremiumTicket", ticket.isPremiumTicket());
            jsonTicket.put("price", ticket.getPrice());
            jsonTickets.put(jsonTicket);
        }
        jsonOrder.put("tickets", jsonTickets);

        try {
            Files.createDirectories(Paths.get("orders"));
            try (PrintWriter out = new PrintWriter("orders/order_" + count + ".json")) {
                out.println(jsonOrder.toString());
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
