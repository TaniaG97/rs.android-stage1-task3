package subtask2

class Combinator {

    fun checkChooseFromArray(array: Array<Int>): Int? {
        val inputC = array[0]
        val inputN = array[1]
        var currentC: Long = 0
        var k = 0

        for (i in 1..inputN) {
            k = i
            currentC = factorial(inputN) / (factorial(inputN - k) * factorial(k))
            if (currentC >= inputC) return k
        }
        return null
    }

    fun factorial(n: Int): Long = if (n < 2) 1 else n * factorial(n - 1)

}
