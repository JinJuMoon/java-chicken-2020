package domain.function;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class RegisterOrder implements MainFunction {
    @Override
    public boolean execute() {
        printTables();
        Table table = inputTable();

        printMenus();
        Menu menu = inputMenu();

        OrderAmount orderAmount = inputOrderAmount();

        table.addOrder(menu, orderAmount);

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

    private void printMenus() {
        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);
    }

    private Menu inputMenu() {
        try {
            final int menuNumber = InputView.inputMenuNumber();
            return MenuRepository.findMenuByNumber(menuNumber);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return inputMenu();
        }
    }

    private OrderAmount inputOrderAmount() {
        try {
            final int orderAmountValue = InputView.inputOrderAmount();
            return new OrderAmount(orderAmountValue);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return inputOrderAmount();
        }
    }
}