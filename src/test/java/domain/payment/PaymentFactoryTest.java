package domain.payment;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PaymentFactoryTest {
    @DisplayName("주어진 번호에 해당하는 결제수단을 반환하는 기능")
    @ParameterizedTest
    @MethodSource("createNumberAndPayment")
    void from(int paymentNumber, Class<Payment> expected) {
        Payment payment = PaymentFactory.from(paymentNumber);

        assertThat(payment.getClass()).isEqualTo(expected);
    }

    private static Stream<Arguments> createNumberAndPayment() {
        return Stream.of(
                Arguments.of(1, PaymentByCreditCard.class),
                Arguments.of(2, PaymentByCash.class)
        );
    }
}