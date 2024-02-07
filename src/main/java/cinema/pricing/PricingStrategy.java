package cinema.pricing;

import cinema.MovieTicket;

public interface PricingStrategy {
    double calculatePrice(MovieTicket ticket, boolean isStudentOrder, boolean isWeekend);
}
