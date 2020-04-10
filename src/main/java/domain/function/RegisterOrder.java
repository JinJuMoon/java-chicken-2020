package domain.function;

import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class RegisterOrder implements MainFunction {
    @Override
    public boolean execute() {
        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);

        final int tableNumber = InputView.inputTableNumber();
        Table table = TableRepository.findTableByNumber(tableNumber);

        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);

        return true;
    }
}
