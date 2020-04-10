package domain.payment;

import domain.Menu;
import domain.MenuRepository;
import domain.Order;
import domain.OrderAmount;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class PaymentByCashTest {

    @Test
    void calculatePriceToPay() {
        Map<Menu, OrderAmount> orderValues = new LinkedHashMap<>();
        orderValues.put(MenuRepository.findMenuByNumber(3), new OrderAmount(2));
        Order order = new Order(orderValues);

        Payment payment = new PaymentByCash();
        int priceToPay = payment.calculatePriceToPay(order);

        assertThat(priceToPay).isEqualTo(30_400);
    }
}