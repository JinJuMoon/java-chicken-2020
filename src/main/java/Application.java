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

            final int mainFunctionNumber = InputView.inputMainFunctionNumber();
            MainFunction mainFunction = MainFunctionFactory.from(mainFunctionNumber);

            programIsRunning = mainFunction.execute();
        }
    }
}
