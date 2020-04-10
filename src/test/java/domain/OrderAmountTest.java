package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class OrderAmountTest {

    @DisplayName("주문 수량을 추가할 경우 추가값을 더한 새로운 주문 수량을 반환하는 기능")
    @Test
    void plus() {
        OrderAmount originalOrderAmount = new OrderAmount(4);
        OrderAmount additionalOrderAmount = new OrderAmount(2);
        OrderAmount finalOrginalAmount = originalOrderAmount.plus(additionalOrderAmount);

        assertThat(finalOrginalAmount).isEqualTo(new OrderAmount(6));
    }
}