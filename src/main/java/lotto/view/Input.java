package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.domain.Constant.MAX_LOTTO_NUM;
import static lotto.domain.Constant.MIN_LOTTO_NUM;

public class Input {
    public String getPurchaseMoney() {
        String money = Console.readLine();

        return money;
    }

    public String getWinningNumber() {
        Output.getMessageEnterWinningNumber();
        String winningNumber = Console.readLine();
        return winningNumber;
    }

    public int getBonusNumber() {
        Output.getMessageEnterBonusNumber();
        String bonusNumber = Console.readLine();
        validateInRange(Integer.parseInt(bonusNumber));
        return Integer.parseInt(bonusNumber);
    }

    private void validateInRange(int bonusNumber) {
        if (bonusNumber > MAX_LOTTO_NUM || bonusNumber < MIN_LOTTO_NUM) {
            System.out.println("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }
}
