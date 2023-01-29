package hw01_testrunner

interface TestRunner {
    fun <T> runTest(steps: T, test: () -> Unit)
}