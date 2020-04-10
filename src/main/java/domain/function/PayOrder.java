package domain.function;

import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class PayOrder implements MainFunction {
    @Override
    public boolean execute() {
        printTables();
        Table table = inputTable();

        OutputView.printOrder(table.getOrder());

        OutputView.printPayOrderMessage(table);

        final int paymentSystemNumber = InputView.inputPaymentSystem();

        return true;
    }

    private void printTables() {
        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);
    }

    private Table inputTable() {
        try {
            final int tableNumber = InputView.inputTableNumber();
            return TableRepository.findTableByNumber(tableNumber);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return inputTable();
        }
    }
}
