package cinema.pricing;

import cinema.MovieTicket;

public class GroupPricingStrategy implements PricingStrategy{

    @Override
    public double calculatePrice(MovieTicket ticket, boolean isStudentOrder, boolean isWeekend) {
        double ticketPrice = ticket.getPrice();
        if (ticket.isPremiumTicket()) {
            ticketPrice += isStudentOrder ? 2 : 3;
        }
        return ticketPrice * 0.9; // Apply 10% group discount
    }
    
}
