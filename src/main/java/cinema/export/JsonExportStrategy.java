package cinema.export;

import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONObject;

import cinema.MovieTicket;
import cinema.Order;

public class JsonExportStrategy implements ExportStrategy{

    @Override
    public void export(Order order) {
        JSONObject jsonOrder = new JSONObject();
        jsonOrder.put("orderNr", order.getOrderNr());
        jsonOrder.put("isStudentOrder", order.isStudentOrder());

        JSONArray jsonTickets = new JSONArray();
        for (MovieTicket ticket : order.getTickets()) {
            JSONObject jsonTicket = new JSONObject();
            jsonTicket.put("screeningDate", ticket.getScreeningDate().toString());
            jsonTicket.put("isPremiumTicket", ticket.isPremiumTicket());
            jsonTicket.put("price", ticket.getPrice());
            jsonTickets.put(jsonTicket);
        }
        jsonOrder.put("tickets", jsonTickets);

        try {
            Files.createDirectories(Paths.get("orders"));
            try (PrintWriter out = new PrintWriter("orders/order_" + order.getOrderNr() + ".json")) {
                out.println(jsonOrder.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
