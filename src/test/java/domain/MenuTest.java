package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MenuTest {

    @DisplayName("주어진 번호와 테이블의 번호가 일치하는지 확인")
    @Test
    void isNumber() {
        Menu menu = new Menu(3, "순살파닭", Category.CHICKEN, 18_000);
        assertThat(menu.isNumber(3)).isTrue();
    }
}
