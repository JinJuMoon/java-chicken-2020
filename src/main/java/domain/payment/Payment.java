package domain.payment;

import domain.Order;

public interface Payment {
    int calculatePriceToPay(Order order);
}
