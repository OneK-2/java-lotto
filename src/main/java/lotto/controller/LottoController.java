package lotto.controller;

import lotto.domain.*;
import lotto.enums.WinningEnum;
import lotto.view.Input;
import lotto.view.Output;

import java.util.HashMap;

public class LottoController {
    private Input input = new Input();
    private LottoCalculator lottoCalculator = new LottoCalculator();
    public int bonusNumber;

    // 구매금액 입력
    public void run() {
        try {
            Money money = purchaseTicket();
            LottoTicket lottoTicket = createLottoTickets(money);
            printLottoTickets(lottoTicket);
            WinningLottoTicket winningLottoTicket = createWinningLottoTicket();
            bonusNumber = createBonusNumber();
            isWinningLotto(lottoTicket, winningLottoTicket, bonusNumber);
            printTotalReturn(money);
        } catch (NullPointerException e) {
            System.out.println("[ERROR] NullPointerException");
        }
    }

    public Money purchaseTicket() {
        Output.getMessageEnterPurchaseMoney();
        Money money = new Money(input.getPurchaseMoney());
        Output.getFormatPurchaseMessage(money.getTicketCount());
        return money;
    }

    public LottoTicket createLottoTickets(Money money) {
        LottoBuilder lottoBuilder = new LottoBuilder();
        LottoTicket lottoTicket = lottoBuilder.createLotto(money);
        return lottoTicket;
    }

    public WinningLottoTicket createWinningLottoTicket() {
        LottoBuilder lottoBuilder = new LottoBuilder();
        WinningLottoTicket winningLottoTicket = lottoBuilder.createWinningLotto(input.getWinningNumber());
        return winningLottoTicket;
    }

    public int createBonusNumber() {
        int bonusNumber;
        bonusNumber = input.getBonusNumber();
        return bonusNumber;
    }

    public void printLottoTickets(LottoTicket lottoTicket) {
        for (Lotto lotto : lottoTicket.getLottoTicket()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void isWinningLotto(LottoTicket lottoTicket, WinningLottoTicket winningLottoTicket, int bonusNumber) {
        HashMap<WinningEnum, Integer> result = new HashMap<>();
        result = lottoCalculator.createResult(lottoTicket, winningLottoTicket, bonusNumber);
        int resultSize = result.size();
        for (int i = 0; i < resultSize; i++) {
            WinningEnum minKey = null;
            for(WinningEnum key : result.keySet()){
                if(minKey==null || minKey.getWinningCount()>key.getWinningCount())
                    minKey=key;
            }

            Output.getFormatGradePrint(minKey, result.get(minKey));
            result.remove(minKey);
        }
    }

    private void printTotalReturn(Money money) {
        double totalReturn = 0;
        totalReturn = lottoCalculator.callTotalPrice() * 100 / (double) money.getPurchasePrice();
        Output.getFormatTotalReturn(totalReturn);
    }
}
