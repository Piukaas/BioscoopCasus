package cinema.orderStates;

import cinema.MovieTicket;
import cinema.Order;
import cinema.OrderState;

public class CreatedState implements OrderState {

    @Override
    public void createOrder(Order order, MovieTicket[] tickets) {
        System.out.println("Order " + order.getOrderNr() + " is already created and can not be created again.");
    }

    @Override
    public void submitOrder(Order order) {
        System.out.println("Order " + order.getOrderNr() + " is submitted.");
        order.setState(new SubmittedState());
    }

    @Override
    public void payOrder(Order order) {
        System.out.println("Order " + order.getOrderNr() + " is not yet submitted and can not be paid for.");
    }

    @Override
    public void remindOrder(Order order) {
        System.out.println("Order " + order.getOrderNr() + " is not yet submitted and reminder can not be sent.");
    }

    @Override
    public void cancelOrder(Order order) {
        System.out.println("Order " + order.getOrderNr() + " is cancelled.");
        order.setState(new CancelledState());
    }
}
