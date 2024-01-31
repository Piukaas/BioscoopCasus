package cinema;

public class Order {
    private int orderNr;
    private boolean isStudentOrder;

    public Order(int orderNr, boolean isStudentOrder) {
        this.orderNr = orderNr;
        this.isStudentOrder = isStudentOrder;
    }

    public int getOrderNr() {
        return orderNr;
    }

    public void addSeatReservation(MovieTicket ticket) {
        // ...
    }

    public double calculatePrice() {
        return 0.0;
    }

    public void export(TicketExportFormat exportFormat) {
        // ...
    }
}
