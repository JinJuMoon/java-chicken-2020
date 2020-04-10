import domain.function.MainFunction;
import domain.function.MainFunctionFactory;
import view.InputView;
import view.OutputView;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        boolean programIsRunning = true;

        while (programIsRunning) {
            OutputView.printMainFunctions();

            MainFunction mainFunction = inputMainFunction();

            programIsRunning = mainFunction.execute();
        }
    }

    private static MainFunction inputMainFunction() {
        try {
            final int mainFunctionNumber = InputView.inputMainFunctionNumber();
            return MainFunctionFactory.from(mainFunctionNumber);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return inputMainFunction();
        }
    }
}
