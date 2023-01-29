package hw01_testrunner

fun main() {
    val steps = Steps()
    val runner = Runner()

    runner.runTest<Steps>(steps = steps, test = ::runnerTest)
}

fun runnerTest() {
    println("Testing...")
}