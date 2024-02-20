package cinema.orderStates;

import cinema.MovieTicket;
import cinema.Order;

public class CancelledState implements IOrderState {

    @Override
    public void createOrder(Order order, MovieTicket[] tickets) {
        System.out.println("Order " + order.getOrderNr() + " is already cancelled and can not be created again.");
    }

    @Override
    public void submitOrder(Order order) {
        System.out.println("Order " + order.getOrderNr() + " is already cancelled and can not be submitted again.");
    }

    @Override
    public void payOrder(Order order) {
        System.out.println("Order " + order.getOrderNr() + " is already cancelled and can not be paid for anymore.");
    }

    @Override
    public void remindOrder(Order order) {
        System.out.println("Order " + order.getOrderNr() + " is already cancelled and reminder can not be sent again.");
    }

    @Override
    public void cancelOrder(Order order) {
        System.out.println("Order " + order.getOrderNr() + " is already cancelled.");
    }

}
