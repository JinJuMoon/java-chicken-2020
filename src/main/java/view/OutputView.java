package view;

import domain.Menu;
import domain.Order;
import domain.OrderAmount;
import domain.Table;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String ENTER = System.lineSeparator();
    private static final String SPACE = " ";
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";

    public static void printMainFunctions() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("## 메인 화면" + ENTER);
        stringBuilder.append("1 - 주문등록" + ENTER);
        stringBuilder.append("2 - 결제하기" + ENTER);
        stringBuilder.append("3 - 프로그램 종료" + ENTER);

        System.out.println(stringBuilder.toString());
    }

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printLine(BOTTOM_LINE, size);
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    private static void printLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(line);
        }
        System.out.println();
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    public static void printOrder(Order order) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("메뉴 수량 금액" + ENTER);

        Map<Menu, OrderAmount> orderValue = order.getMenuAndOrderAmount();
        for (Menu menu : orderValue.keySet()) {
            stringBuilder.append(menu.getName());
            stringBuilder.append(SPACE);
            stringBuilder.append(orderValue.get(menu));
            stringBuilder.append(SPACE);
            stringBuilder.append(menu.getPrice());
            stringBuilder.append(ENTER);
        }

        System.out.println(stringBuilder.toString());
    }

    public static void printPayOrderMessage(Table table) {
        System.out.println(table.getNumber() + "번의 결제를 진행합니다.");
    }
}
