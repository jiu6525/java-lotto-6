package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoMatchTest {

    private LottoMatch lottoMatch;

    @BeforeEach
    public void setup() {
        lottoMatch = new LottoMatch(); // 필드 초기화
    }

    @ParameterizedTest
    @CsvSource({
            "11, 12, 13, 14, 15, 16, 7, 0",  // 일치하는 숫자 없음 6등
            "1, 2, 3, 7, 8, 9, 7, 1",  // 3개의 숫자가 일치 5등
            "1, 2, 3, 4, 8, 9, 7, 2",  // 4개의 숫자가 일치 4등
            "1, 2, 3, 4, 5, 8, 7, 3",  // 5개의 숫자만 일치 3등
            "1, 2, 3, 4, 5, 7, 7, 4",  // 5개의 숫자와 1개의 보너스번호 일치 2등
            "1, 2, 3, 4, 5, 6, 7, 5"   // 6개의 숫자가 일치 1등
    })
    @DisplayName("일치하는 숫자에 따른 결과값 확인 테스트")
    void scoredBoardTest(int first, int second, int third, int fourth, int five, int six, int bonus, int index) {
        Lotto lotto = new Lotto(List.of(first, second, third, fourth, five, six));
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), bonus);
        Map<Rank, Integer> rankIntegerMap = lottoMatch.scoreBoard(List.of(lotto), winningLotto);
        Rank[] ranks = Rank.values();
        rankIntegerMap.forEach((k, v) -> {
            if (v != 0) {
                assertThat(k).isEqualTo(ranks[index]);
            }
        });
    }

}