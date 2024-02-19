package cinema;

public interface OrderState {
    void createOrder(Order order);
    void submitOrder(Order order);
    void payOrder   (Order order);
    void remindOrder(Order order);
    void cancelOrder(Order order);
}
