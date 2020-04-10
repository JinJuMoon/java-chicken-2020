package domain;

import java.util.Objects;

public class OrderAmount {
    private final int orderAmount;

    public OrderAmount(int orderAmount) {
        validateAmount(orderAmount);
        this.orderAmount = orderAmount;
    }

    private void validateAmount(int orderAmount) {
        if (orderAmount < 1) {
            throw new IllegalArgumentException("주문 수량은 최소 1개입니다.");
        }

        if (orderAmount > 99) {
            throw new IllegalArgumentException("주문 수량은 최대 99개입니다.");
        }
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
