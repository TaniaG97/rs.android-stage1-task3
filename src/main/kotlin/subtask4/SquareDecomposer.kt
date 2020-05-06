package subtask4

import kotlin.math.sqrt

class SquareDecomposer {

    fun decomposeNumber(number: Int): Array<Int>? {
        return decomposer(number * number, number - 1)
    }

    private fun decomposer(square: Int, rootSquare: Int): Array<Int>? {
        if (sqrt(square.toDouble()) < 1) return null

        for (currentRoot in rootSquare downTo 1) {
            val remain = square - currentRoot * currentRoot

            if (remain < 0) return null

            if (remain == 0) return arrayOf(currentRoot)

            val nextSquare = sqrt(remain.toDouble()).toInt()
            val nextSquareRoot =
                if (nextSquare >= currentRoot) decomposer(remain, currentRoot - 1)
                else decomposer(remain, nextSquare)

            if (nextSquareRoot?.isNotEmpty() == true) return nextSquareRoot + arrayOf(currentRoot)
        }

        return null
    }
}
