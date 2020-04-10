package domain;

import java.util.Objects;

public class OrderAmount {
    private final int orderAmount;

    public OrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }

    public OrderAmount plus(OrderAmount other) {
        return new OrderAmount(this.orderAmount + other.orderAmount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderAmount that = (OrderAmount) o;
        return orderAmount == that.orderAmount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderAmount);
    }

    @Override
    public String toString() {
        return "OrderAmount{" +
                "orderAmount=" + orderAmount +
                '}';
    }
}
