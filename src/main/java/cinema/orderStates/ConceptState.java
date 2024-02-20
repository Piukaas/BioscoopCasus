package cinema.orderStates;

import cinema.MovieTicket;
import cinema.Order;
import cinema.IOrderState;

public class ConceptState implements IOrderState {

    @Override
    public void createOrder(Order order, MovieTicket[] tickets) {
        for (MovieTicket ticket : tickets) {
            order.addSeat(ticket);
        }
        System.out.println("Order " + order.getOrderNr() + " is created.");
        order.setState(new CreatedState());
    }

    @Override
    public void submitOrder(Order order) {
        System.out.println("Please create an order first.");
    }

    @Override
    public void payOrder(Order order) {
        System.out.println("Please create and submit your order first.");
    }

    @Override
    public void remindOrder(Order order) {
        System.out.println("Please don't forget to create your order to watch the movie.");
    }

    @Override
    public void cancelOrder(Order order) {
        System.out.println("You don't have an order to cancel.");
    }

}
