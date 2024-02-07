package cinema.pricing;

import cinema.MovieTicket;

public class StandardPricingStrategy implements PricingStrategy {

    @Override
    public double calculatePrice(MovieTicket ticket, boolean isStudentOrder, boolean isWeekend) {
        double ticketPrice = ticket.getPrice();
        if (ticket.isPremiumTicket()) {
            ticketPrice += isStudentOrder ? 2 : 3;
        }
        return ticketPrice;
    }
    
}
