package cinema;

public interface IOrderState {
    void createOrder(Order order, MovieTicket[] tickets);
    void submitOrder(Order order);
    void payOrder   (Order order);
    void remindOrder(Order order);
    void cancelOrder(Order order);
}
