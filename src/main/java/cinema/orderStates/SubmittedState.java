package cinema.orderStates;

import cinema.MovieTicket;
import cinema.Order;
import cinema.OrderState;

public class SubmittedState implements OrderState {

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
        order.setState(new PaidState());
    }

    @Override
    public void remindOrder(Order order) {
        
    }

    @Override
    public void cancelOrder(Order order) {
        System.out.println("Order " + order.getOrderNr() + " is cancelled.");
        order.setState(new CancelledState());
    }

}
