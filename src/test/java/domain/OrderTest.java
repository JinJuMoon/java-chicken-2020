package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

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

    @DisplayName("치킨 주문수량에 대한 할인 횟수 계산하는 기능")
    @ParameterizedTest
    @MethodSource("createChickenAmountAndDiscountTime")
    void countChickenDiscountTime(int chickenAmount, int discountTime) {
        Map<Menu, OrderAmount> orderValues = new LinkedHashMap<>();
        orderValues.put(MenuRepository.findMenuByNumber(3), new OrderAmount(chickenAmount));
        Order order = new Order(orderValues);

        assertThat(order.countChickenDiscountTime()).isEqualTo(discountTime);
    }


    private static Stream<Arguments> createChickenAmountAndDiscountTime() {
        return Stream.of(
                Arguments.of(10, 1),
                Arguments.of(11, 1),
                Arguments.of(19, 1),
                Arguments.of(20, 2),
                Arguments.of(21, 2)
        );
    }
}