package domain.function;

import java.util.Arrays;

public enum MainFunctionFactory {
    REGISTER_ORDER(1, new RegisterOrder()),
    PAY_ORDER(2, new PayOrder()),
    EXIT_PROGRAM(3, new ExitProgram());

    private final int number;
    private final MainFunction mainFunction;

    MainFunctionFactory(int number, MainFunction mainFunction) {
        this.number = number;
        this.mainFunction = mainFunction;
    }

    public static MainFunction from(int mainFunctionNumber) {
        return Arrays.stream(values())
                .filter(mainFunctionFactory -> mainFunctionFactory.number == mainFunctionNumber)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당하는 번호의 기능은 존재하지 않습니다."))
                .mainFunction;
    }
}
