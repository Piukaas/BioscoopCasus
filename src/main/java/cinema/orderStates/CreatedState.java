package cinema.orderStates;

import cinema.MovieTicket;
import cinema.Order;
import cinema.OrderState;

public class CreatedState implements OrderState{

    @Override
    public void createOrder(Order order, MovieTicket[] tickets) {
        System.out.println("Order " + order.getOrderNr() + " is already created.");
    }

    @Override
    public void submitOrder(Order order) {
        order.reserveSeats();
        
        System.out.println("Order " + order.getOrderNr() + " is submitted.");
        order.setState(new SubmittedState());
    }

    @Override
    public void payOrder(Order order) {
        System.out.println("Order " + order.getOrderNr() + " is not yet submitted.");
    }

    @Override
    public void remindOrder(Order order) {
        System.out.println("Please don't forget to submit your order to watch the movie.");
    }

    @Override
    public void cancelOrder(Order order) {
        System.out.println("Order " + order.getOrderNr() + " is cancelled.");
        order.setState(new CancelledState());
        
    }
    
}
