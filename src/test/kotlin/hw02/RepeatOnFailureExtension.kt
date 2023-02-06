package hw02

import io.kotest.core.annotation.AutoScan
import io.kotest.core.extensions.TestCaseExtension
import io.kotest.core.test.TestCase
import io.kotest.core.test.TestResult

@AutoScan
class RepeatOnFailureExtension(): TestCaseExtension {
    private val maxReps = 3

    override suspend fun intercept(testCase: TestCase, execute: suspend (TestCase) -> TestResult): TestResult {
        var testResult = execute(testCase)
        if (testResult.isSuccess) {
            println("Test was successful!")
            return testResult
        } else {
            repeat((1..maxReps).count()) {
                println("Test was failed. Attempt #${it + 1}...")
                testResult = execute(testCase)
                if (testResult.isSuccess) {
                    return testResult
                }
            }
            println("Test was failed. Check it.")
            return testResult
        }
    }
}