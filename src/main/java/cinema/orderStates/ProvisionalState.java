package cinema.orderStates;

import cinema.MovieTicket;
import cinema.Order;
import cinema.OrderState;

public class ProvisionalState implements OrderState {

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
        System.out.println("Order " + order.getOrderNr() + " is paid.");
        order.setState(new HandledState());
    }

    @Override
    public void remindOrder(Order order) {
        System.out.println("Order " + order.getOrderNr() + " reminder has already been sent.");
    }

    @Override
    public void cancelOrder(Order order) {
        System.out.println("Order " + order.getOrderNr() + " is cancelled, due to not paying.");
        order.setState(new CancelledState());
    }

}
