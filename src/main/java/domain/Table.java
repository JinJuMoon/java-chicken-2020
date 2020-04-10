package domain;

import java.util.LinkedHashMap;

public class Table {
    private final int number;
    private final Order order;

    public Table(final int number) {
        this.number = number;
        this.order = new Order(new LinkedHashMap<>());
    }

    public boolean isNumber(int number) {
        return this.number == number;
    }

    public void addOrder(Menu menu, OrderAmount orderAmount) {
        order.add(menu, orderAmount);
    }

    public int getNumber() {
        return number;
    }

    public Order getOrder() {
        return order;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
