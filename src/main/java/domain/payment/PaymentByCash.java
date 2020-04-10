package domain.payment;

import domain.Menu;
import domain.Order;
import domain.OrderAmount;

import java.util.Map;

public class PaymentByCash implements Payment {
    @Override
    public int calculatePriceToPay(Order order) {
        int priceToPay = 0;
        Map<Menu, OrderAmount> orderValue = order.getOrderValue();

        for (Menu menu : orderValue.keySet()) {
            OrderAmount orderAmount = orderValue.get(menu);
            priceToPay += menu.getPrice() * orderAmount.getOrderAmount();
        }

        int chickenDiscountPrice = order.countChickenDiscountTime() * 10_000;
        priceToPay -= chickenDiscountPrice;

        return (int)(priceToPay * 0.95);
    }
}
