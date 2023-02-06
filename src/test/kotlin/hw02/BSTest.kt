package hw02

import BalanceService
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.comparables.shouldBeEqualComparingTo

class BSTest: BehaviorSpec({
    given("It's a positive test") {
        val balanceS = BalanceService()
        `when`("add balance") {
            balanceS.addBalance(50)
            then("added") {
                balanceS.getBalance() shouldBeEqualComparingTo 150
            }
        }
    }

    given("It's a negative test") {
        val balanceS = BalanceService()
        `when`("add balance") {
            balanceS.addBalance(50)
            then("added") {
                balanceS.getBalance() shouldBeEqualComparingTo 50
            }
        }
    }
})