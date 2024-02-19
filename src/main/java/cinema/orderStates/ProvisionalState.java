package cinema.orderStates;

import cinema.MovieTicket;
import cinema.Order;
import cinema.OrderState;

public class ProvisionalState implements OrderState {

    @Override
    public void createOrder(Order order, MovieTicket[] tickets) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createOrder'");
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
