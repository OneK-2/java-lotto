package lotto.domain;

import java.util.List;

import static lotto.domain.Constant.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateQuantity(numbers);
        validateInRange(numbers);
        this.numbers = numbers;
    }

    private void validateQuantity(List<Integer> numbers) {
        if (numbers.size() != LOTTO_QUANTITY) {
            System.out.println("[ERROR] 로또 번호는 총 6자리 입니다.");
            throw new IllegalArgumentException();
        }
    }

    private void validateInRange(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) > MAX_LOTTO_NUM || numbers.get(i) < MIN_LOTTO_NUM) {
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                throw new IllegalArgumentException();
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
