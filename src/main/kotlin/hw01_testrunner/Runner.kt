package hw01_testrunner

class Runner : TestRunner {

    override fun <T> runTest(steps: T, test: () -> Unit) {
        steps?.runStep("before")

        println("Some tests launched...")
        test()
        println("Some tests passed...")

        steps?.runStep("after")
    }

    fun Any.runStep(stepName: String) {
        this::class.members
            .filter { it.name.contains(stepName) }
            .forEach {
                println("Start step: ${it.name}")
                it.call(this)
                println("End step: ${it.name}")
            }
    }
}