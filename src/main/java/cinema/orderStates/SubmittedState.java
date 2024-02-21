package cinema.orderStates;

import cinema.MovieTicket;
import cinema.Order;

public class SubmittedState implements IOrderState {

    @Override
    public void createOrder(Order order, MovieTicket[] tickets) {
        System.out.println("Order " + order.getOrderNr() + " is already submitted and can not be created again.");
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
        System.out.println("Order " + order.getOrderNr() + " reminder has been sent.");
        order.setState(new ProvisionalState());
    }

    @Override
    public void cancelOrder(Order order) {
        order.removeSeatReservation();
        System.out.println("Order " + order.getOrderNr() + " is cancelled.");
        order.setState(new CancelledState());
    }

}
