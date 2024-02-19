package cinema.orderStates;

import cinema.MovieTicket;
import cinema.Order;
import cinema.OrderState;

public class CreatedState implements OrderState{

    @Override
    public void createOrder(Order order, MovieTicket[] tickets) {
        
    }

    @Override
    public void submitOrder(Order order) {
        
        
        System.out.println("Order " + order.getOrderNr() + " is submitted.");
        order.setState(new SubmittedState());
    }

    @Override
    public void payOrder(Order order) {
        
    }

    @Override
    public void remindOrder(Order order) {
        
    }

    @Override
    public void cancelOrder(Order order) {
        
    }
    
}
