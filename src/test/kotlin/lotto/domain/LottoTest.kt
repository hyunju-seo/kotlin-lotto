package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.test.FakeGenerator

class LottoTest : StringSpec({
    "로또 번호는 6개이다." {
        shouldNotThrowAny {
            FakeGenerator.lotto(1, 2, 3, 4, 5, 6)
        }
    }

    "로또 번호가 6개가 아니면 예외를 던진다." {
        shouldThrow<IllegalArgumentException> {
            FakeGenerator.lotto(1, 2, 3, 4, 5)
        }

        shouldThrow<IllegalArgumentException> {
            FakeGenerator.lotto(1, 2, 3, 4, 5, 6, 7)
        }
    }

    "로또 번호중에 중복되는 숫자가 있으면 예외를 던진다." {
        shouldThrow<IllegalArgumentException> {
            FakeGenerator.lotto(1, 1, 2, 3, 4, 5)
        }
    }

    "로또 번호와 일치하는 숫자의 개수를 구한다." {
        val lotto = FakeGenerator.lotto(1, 2, 3, 4, 5, 6)
        listOf(
            FakeGenerator.lotto(1, 2, 3, 14, 15, 16) to 3,
            FakeGenerator.lotto(10, 11, 12, 13, 14, 15) to 0
        ).forEach { (inputLotto, matchingCount) ->
            lotto.getMatchingCount(inputLotto) shouldBe matchingCount
        }
    }
})
