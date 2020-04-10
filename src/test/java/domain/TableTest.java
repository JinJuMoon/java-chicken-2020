package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TableTest {

    @DisplayName("주어진 번호와 테이블의 번호가 일치하는지 확인")
    @Test
    void isNumber() {
        Table table = new Table(3);
        assertThat(table.isNumber(3)).isTrue();
    }

    @DisplayName("주문을 등록")
    @Test
    void addOrder() {
        Table table = TableRepository.findTableByNumber(3);

        Menu menu = MenuRepository.findMenuByNumber(2);
        OrderAmount orderAmount = new OrderAmount(5);

        table.addOrder(menu, orderAmount);
        Order order = table.getOrder();

        assertThat(order.getOrderAmountOfMenu(menu)).isEqualTo(new OrderAmount(5));
    }
}
