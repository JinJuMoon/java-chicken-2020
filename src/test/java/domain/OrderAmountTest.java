package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class OrderAmountTest {

    @DisplayName("주문 수량을 추가할 경우 추가값을 더한 새로운 주문 수량을 반환하는 기능")
    @Test
    void plus() {
        OrderAmount originalOrderAmount = new OrderAmount(4);
        OrderAmount additionalOrderAmount = new OrderAmount(2);
        OrderAmount finalOriginalAmount = originalOrderAmount.plus(additionalOrderAmount);

        assertThat(finalOriginalAmount).isEqualTo(new OrderAmount(6));
    }

    @DisplayName("주문 수량을 추가할 경우 추가값을 더한 새로운 주문 수량을 반환하는 기능")
    @ParameterizedTest
    @MethodSource("createAmountAndMessage")
    void validateAmount(int orderAmountValue, String message) {
        assertThatThrownBy(() -> {
            new OrderAmount(orderAmountValue);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    private static Stream<Arguments> createAmountAndMessage() {
        return Stream.of(
                Arguments.of(100, "주문 수량은 최대 99개입니다."),
                Arguments.of(-1, "주문 수량은 최소 1개입니다.")
        );
    }
}