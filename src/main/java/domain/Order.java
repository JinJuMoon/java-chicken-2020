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

    public OrderAmount getOrderAmountOfMenu(Menu menu) {
        return order.get(menu);
    }

    public Map<Menu, OrderAmount> getMenuAndOrderaMount() {
        return Collections.unmodifiableMap(order);
    }
}
