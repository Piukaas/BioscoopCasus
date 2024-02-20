package cinema.orderStates;

import cinema.MovieTicket;
import cinema.Order;
import cinema.IOrderState;

public class HandledState implements IOrderState {

    @Override
    public void createOrder(Order order, MovieTicket[] tickets) {
        System.out.println("Order " + order.getOrderNr() + " is already created and can not be created again.");
    }

    @Override
    public void submitOrder(Order order) {
        System.out.println("Order " + order.getOrderNr() + " is already submitted.");
    }

    @Override
    public void payOrder(Order order) {
        System.out.println("Order " + order.getOrderNr() + " is already paid.");
    }

    @Override
    public void remindOrder(Order order) {
        System.out.println("Order " + order.getOrderNr() + " is already paid, no reminder necessary.");
    }

    @Override
    public void cancelOrder(Order order) {
        System.out.println("Order " + order.getOrderNr() + " cannot be cancelled, because it is already handled.");
    }
}
