package lotto.enums;

import java.util.Arrays;

public enum WinningEnum {
    FIRST_PLACE(6, "6개 일치 (2,000,000,000원)", 2000000000),
    SECOND_PLACE(5, "5개 일치, 보너스 볼 일치 (30,000,000원) ", 30000000),
    THIRD_PLACE(5, "5개 일치 (1,500,000원)", 1500000),
    FOURTH_PLACE(4, "4개 일치 (50,000원)", 50000),
    FIFTH_PLACE(3, "3개 일치 (5,000원)", 5000),
    NONE(0, "", 0);

    private int winningCount;
    private String sentence;
    private int winningPrice;

    WinningEnum(int winningCount, String sentence, int winningPrice) {
        this.winningCount = winningCount;
        this.sentence = sentence;
        this.winningPrice = winningPrice;
    }

    public static WinningEnum from(int matchCount, boolean bonus) {
        if (matchCount == 5 && bonus) {
            return SECOND_PLACE;
        }
        return Arrays.stream(WinningEnum.values())
                .filter(r -> r.winningCount == matchCount)
                .findFirst()
                .orElse(NONE);
    }

    public int getWinningCount() {
        return winningCount;
    }

    public int getWinningPrice() {
        return winningPrice;
    }

    public String getSentence() {
        return sentence;
    }
}
