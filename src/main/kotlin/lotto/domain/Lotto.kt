package lotto.domain

class Lotto(val lottoNumbers: List<LottoNumber>) {
    init {
        require(lottoNumbers.toSet().size == NUMBERS_SIZE) { "로또 숫자는 중복없이 $NUMBERS_SIZE 개여야 합니다." }
    }

    fun getMatchingCount(numbers: List<LottoNumber>): Int {
        return numbers.count { lottoNumbers.contains(it) }
    }

    companion object {
        const val NUMBERS_SIZE = 6
    }
}
