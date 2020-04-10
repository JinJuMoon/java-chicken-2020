package domain.payment;

import java.util.Arrays;

public enum PaymentFactory {
    CREDIT_CARD(1, new PaymentByCreditCard()),
    CASH(2, new PaymentByCash());

    private final int number;
    private final Payment payment;

    PaymentFactory(int number, Payment payment) {
        this.number = number;
        this.payment = payment;
    }

    public static Payment from(int paymentNumber) {
        return Arrays.stream(values())
                .filter(paymentFactory -> paymentFactory.number == paymentNumber)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당하는 번호의 결제 수단은 존재하지 않습니다."))
                .payment;
    }
}
