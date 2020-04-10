package domain.payment;

import domain.Order;

public class PaymentByCash implements Payment {
    @Override
    public int calculatePriceToPay(Order order) {
        return 0;
    }
}
