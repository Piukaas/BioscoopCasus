package cinema.orderStates;

import cinema.MovieTicket;
import cinema.Order;
import cinema.OrderState;

public class ConceptState implements OrderState{

    @Override
    public void createOrder(Order order, MovieTicket[] tickets) {
        for (MovieTicket ticket : tickets) {
            order.addSeatReservation(ticket);
        }

    }

    @Override
    public void submitOrder(Order order) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'submitOrder'");
    }

    @Override
    public void payOrder(Order order) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'payOrder'");
    }

    @Override
    public void remindOrder(Order order) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remindOrder'");
    }

    @Override
    public void cancelOrder(Order order) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cancelOrder'");
    }
    
}
