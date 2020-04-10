package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MenuRepositoryTest {

    @DisplayName("주어진 번호로 해당하는 메뉴를 찾는 기능")
    @Test
    void findMenuByNumber() {
        int findingNumber = 3;
        Menu foundMenu = MenuRepository.findMenuByNumber(findingNumber);

        assertThat(foundMenu.isNumber(findingNumber)).isTrue();
    }
}
