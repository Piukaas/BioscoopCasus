package cinema.export;

import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import cinema.MovieTicket;
import cinema.Order;

public class PlaintextExportStrategy implements ExportStrategy{

    @Override
    public void export(Order order) 
    {
        // Implementation of exporting to plain text
        StringBuilder sb = new StringBuilder();
        for (MovieTicket ticket : order.getTickets()) {
            sb.append(ticket.toString()).append("\n");
        }

        try {
            Files.createDirectories(Paths.get("orders"));
            try (PrintWriter out = new PrintWriter("orders/order_" + order.getOrderNr() + ".txt")) {
                out.println(sb.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
