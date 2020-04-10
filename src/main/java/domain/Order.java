package domain;

import java.util.Collections;
import java.util.Map;

public class Order {
    private final Map<Menu, OrderAmount> order;

    public Order(Map<Menu, OrderAmount> order) {
        this.order = order;
    }

    public void add(Menu menu, OrderAmount additionalOrderAmount) {
        OrderAmount originalOrderAmount = order.get(menu);

        if (originalOrderAmount == null) {
            originalOrderAmount = new OrderAmount(0);
        }

        OrderAmount finalOrderAmount = originalOrderAmount.plus(additionalOrderAmount);
        order.put(menu, finalOrderAmount);
    }

    public int countChickenDiscountTime() {
        return countChicken() / 10;
    }

    private int countChicken() {
        int chickenCategoryAmount = 0;
        for (Menu menu : order.keySet()) {
            if (menu.isChicken()) {
                chickenCategoryAmount += order.get(menu).getOrderAmount();
            }
        }
        return chickenCategoryAmount;
    }

    public OrderAmount getOrderAmountOfMenu(Menu menu) {
        return order.get(menu);
    }

    public Map<Menu, OrderAmount> getOrderValue() {
        return Collections.unmodifiableMap(order);
    }
}
