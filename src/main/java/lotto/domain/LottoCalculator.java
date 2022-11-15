package lotto.domain;

import lotto.enums.WinningEnum;
import lotto.view.Output;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static lotto.domain.Constant.LOTTO_QUANTITY;

public class LottoCalculator {
    private boolean flag = false;
    private int quantityArray[] = new int[]{0, 0, 0, 0, 0, 0, 0};

    public HashMap<WinningEnum, Integer> lottoMap = new HashMap<>();

    public HashMap<WinningEnum, Integer> createResult(LottoTicket lottoTicket, WinningLottoTicket winningLottoTicket, int bonusNumber) {
        List<Integer> winningList = makeIntegerList(winningLottoTicket);
        lottoMap = init();
        for (Lotto lotto : lottoTicket.getLottoTicket()) {
            int matchCount = matchingCount(lotto.getNumbers(), winningList, bonusNumber);
            quantityArray[matchCount]++;
            lottoMap.put(compareCount(matchCount, flag), quantityArray[matchCount]);
            flag = false;
        }
        lottoMap.remove(WinningEnum.NONE);
        return (HashMap<WinningEnum, Integer>) lottoMap.clone();
    }

    public HashMap<WinningEnum, Integer> init() {
        HashMap<WinningEnum, Integer> init = new HashMap<>();
        for (WinningEnum winningEnum : WinningEnum.values()) {
            init.put(winningEnum, 0);
        }
        return init;
    }

    private int matchingCount(List<Integer> lottoTicket, List<Integer> winningLottoTicket, int bonusNumber) {
        int count = 0;
        for (Integer number : lottoTicket) {
            if (winningLottoTicket.contains(number) || bonusNumber == number) count++;
        }
        if (count == LOTTO_QUANTITY - 1 && lottoTicket.contains(bonusNumber)) {
            flag = true;
        }
        return count;
    }

    private List<Integer> makeIntegerList(WinningLottoTicket winningLottoTicket) {
        List<Integer> winningLottoList = new ArrayList<>();
        for (Lotto lotto : winningLottoTicket.getWinningLottoTicket()) {
            winningLottoList = lotto.getNumbers();
        }
        return winningLottoList;
    }

    private WinningEnum compareCount(int matchCount, boolean flag) {
        if (flag) {
            return WinningEnum.SECOND_PLACE;
        }
        for (WinningEnum winningEnum : WinningEnum.values()) {
            if (winningEnum.getWinningCount() == matchCount) {
                return winningEnum;
            }
        }
        return WinningEnum.NONE;
    }

    public double callTotalPrice() {
        return getTotalPrice(lottoMap);
    }

    public double getTotalPrice(HashMap<WinningEnum, Integer> result) {
        double totalPrice = 0;
        for (WinningEnum winningEnum : result.keySet()) {
            totalPrice += winningEnum.getWinningPrice() * result.get(winningEnum);

        }
        return totalPrice;
    }
}
