package lotto.domain;

import static lotto.domain.Constant.LOTTO_PRICE;

public class Money {
    private int purchasePrice;

    public Money(String money) {
        if (isNumber(money)) {
            validate(money);
            this.purchasePrice = Integer.parseInt(money);
        }
    }

    private void validate(String money) {

        if (Integer.parseInt(money) % LOTTO_PRICE != 0) {
            System.out.println("[ERROR] 구매금액은 1000원 단위입니다.");
            throw new IllegalArgumentException();
        }
    }

    public static boolean isNumber(String money) {
        if (money.chars().allMatch(Character::isDigit) == false) {
            System.out.println("[ERROR] 숫자를 입력해주세요.");
            throw new IllegalArgumentException();
        }
        return money.chars().allMatch(Character::isDigit);
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public int getTicketCount() {
        return purchasePrice / LOTTO_PRICE;
    }
}
