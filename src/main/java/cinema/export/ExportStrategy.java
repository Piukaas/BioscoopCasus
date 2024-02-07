package cinema.export;

import cinema.Order;

public interface ExportStrategy {
    void export(Order order);
}
