package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

import static org.assertj.core.api.Assertions.*;

class OrderTest {
    @DisplayName("주문한 메뉴와 수량을 주문에 추가하는 기능")
    @Test
    void add() {
        Order order = new Order(new LinkedHashMap<>());
        Menu menu = MenuRepository.findMenuByNumber(3);
        OrderAmount orderAmount = new OrderAmount(2);
        order.add(menu, orderAmount);

        assertThat(order.getOrderAmountOfMenu(menu)).isEqualTo(orderAmount);
    }
}