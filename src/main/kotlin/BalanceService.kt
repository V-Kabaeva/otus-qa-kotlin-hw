class BalanceService {
    private var userBalance = 100

    fun addBalance(count: Int) {
        userBalance += count
    }

    fun removeBalance(count: Int) {
        userBalance -= count
    }

    fun getBalance() = userBalance
}