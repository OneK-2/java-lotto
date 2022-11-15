package lotto.view;

import lotto.enums.WinningEnum;

public class Output {
    private static final String MESSAGE_ENTER_PURCHASE_MONEY = "구입금액을 입력해 주세요.";
    private static final String MESSAGE_ENTER_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String MESSAGE_ENTER_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String MESSAGE_WINNING_STATISTICS = "당첨 통계";
    private static final String FORMAT_TOTAL_RETURN = "총 수익률은 %.1f%% 입니다.";
    private static final String FORMAT_PURCHASE_MESSAGE = "%d개를 구매했습니다.";
    private static final String FORMAT_GRADE_PRINT = "%s - %d개";

    public static void getMessageEnterPurchaseMoney() {
        System.out.println(MESSAGE_ENTER_PURCHASE_MONEY);
    }

    public static void getMessageEnterWinningNumber() {
        System.out.println(MESSAGE_ENTER_WINNING_NUMBER);
    }

    public static void getMessageEnterBonusNumber() {
        System.out.println(MESSAGE_ENTER_BONUS_NUMBER);
    }

    public static void getMessageWinningStatistics() {
        System.out.println(MESSAGE_WINNING_STATISTICS);
    }

    public static void getFormatGradePrint(WinningEnum winningEnum, int quantity) {
        System.out.println(String.format(FORMAT_GRADE_PRINT, winningEnum.getSentence(), quantity));
    }

    public static void getFormatTotalReturn(double totalReturn) {
        System.out.println(String.format(FORMAT_TOTAL_RETURN, totalReturn));
    }

    public static void getFormatPurchaseMessage(int lottoCount) {
        System.out.println(String.format(FORMAT_PURCHASE_MESSAGE, lottoCount));
    }
}
