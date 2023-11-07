package lotto.domain;

public enum Rank {
    MISS(0, 0, ""),
    FIFTH(3, 5000, "3개 일치 (5,000원) - "),
    FOURTH(4, 50000, "4개 일치 (50,000원) - "),
    THIRD(5, 1500000, "5개 일치 (1,500,000원) - "),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),

    FIRST(6, 2000000000, "6개 일치 (2,000,000,000원) - ");


    public final int countOfMatch;
    public final double winningMoney;
    public final String message;

    Rank(int countOfMatch, int winningMoney, String message) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.message = message;
    }

    public boolean matchCount(int countOfMatch) {
        return this.countOfMatch == countOfMatch;
    }
}
