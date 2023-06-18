package lotto.domain

class LottoResult(val lottoRanks: List<LottoRank>) {
    fun getLottoRankStatistic(): Map<LottoRank, Int> {
        val rankCountMap = lottoRanks
            .groupingBy { it }
            .eachCount()
        return LottoRank.values().associateWith { rankCountMap[it] ?: 0 }
    }

    fun getProfitRate(lottoPrice: Int): Double {
        require(lottoPrice > 0) { "로또의 가격은 0원보다 커야합니다." }
        val lottoTotalPrice = lottoRanks.size * lottoPrice
        if (lottoTotalPrice < 0) {
            return 0.0
        }
        return calculateWinningPrice() / lottoTotalPrice
    }

    private fun calculateWinningPrice(): Double {
        return lottoRanks
            .fold(0) { acc, next -> acc + next.price }
            .toDouble()
    }
}
