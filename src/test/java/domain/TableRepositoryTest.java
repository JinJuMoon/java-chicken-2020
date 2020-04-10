package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class TableRepositoryTest {

    @DisplayName("주어진 번호로 해당하는 테이블을 찾는 기능")
    @Test
    void findByNumber() {
        int findingNumber = 3;
        Table foundTable = TableRepository.findTableByNumber(findingNumber);

        assertThat(foundTable.isNumber(findingNumber)).isTrue();
    }
}