package lotto.domain;

import java.util.List;

public class WinningLottoTicket {
    private List<Lotto> winningLottoTicket;

    public WinningLottoTicket(List<Lotto> winningLottoTicket){
        this.winningLottoTicket = winningLottoTicket;
    }

    public List<Lotto> getWinningLottoTicket() {
        return winningLottoTicket;
    }
}
