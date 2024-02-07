package cinema.export;

import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import cinema.MovieTicket;
import cinema.Order;

public class PlaintextExportStrategy implements ExportStrategy {
    private static int count = 0;

    @Override
    public void export(Order order) {
        StringBuilder sb = new StringBuilder();
        for (MovieTicket ticket : order.getTickets()) {
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
}
