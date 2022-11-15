package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static lotto.domain.Constant.*;

public class LottoBuilder {
    private List<Integer> createRandomNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUM, MAX_LOTTO_NUM, LOTTO_QUANTITY);
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }

    public LottoTicket createLotto(Money money) {
        List<Lotto> lottoTicket = new ArrayList<>();
        int ticketCount = money.getTicketCount();
        for (int i = 0; i < ticketCount; i++) {
            lottoTicket.add(new Lotto(createRandomNumber()));
        }
        return new LottoTicket(lottoTicket);
    }

    //당첨 티켓 생성
    public WinningLottoTicket createWinningLotto(String winningNumber) {
        List<Lotto> winningLottoTicket = new ArrayList<>();

        String[] tempArray = winningNumber.split(",");
        Integer[] makeIntegerArray = Stream.of(tempArray).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
        winningLottoTicket.add(new Lotto(Arrays.asList(makeIntegerArray)));

        return new WinningLottoTicket(winningLottoTicket);
    }

}
