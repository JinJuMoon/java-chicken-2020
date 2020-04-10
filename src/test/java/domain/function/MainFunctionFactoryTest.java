package domain.function;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class MainFunctionFactoryTest {
    @DisplayName("주어진 번호에 해당하는 메인화면의 기능을 반환하는 기능")
    @ParameterizedTest
    @MethodSource("createNumberAndMainFunction")
    void from(int mainFunctionNumber, Class<MainFunction> expected) {
        MainFunction mainFunction = MainFunctionFactory.from(mainFunctionNumber);

        assertThat(mainFunction.getClass()).isEqualTo(expected);
    }

    private static Stream<Arguments> createNumberAndMainFunction() {
        return Stream.of(
                Arguments.of(1, RegisterOrder.class),
                Arguments.of(2, PayOrder.class),
                Arguments.of(3, ExitProgram.class)
        );
    }
}
