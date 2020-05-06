package subtask1

import kotlin.math.abs

class PolynomialConverter {

    fun convertToStringFrom(numbers: Array<Int>): String? {
        var outputStr:String? = null;

        if(numbers.isNotEmpty()){
            var stringBuilder = StringBuilder()
            for((index,value) in numbers.withIndex()) {
                if (value == 0) continue
                if (index != 0 && value > 0) stringBuilder.append(" + ") else if (index != 0 && value < 0) stringBuilder.append( " - ")
                if (abs(value) != 1) stringBuilder.append("${abs(value)}") else if (index == numbers.lastIndex) stringBuilder.append( "1")
                var stepen = numbers.size - index - 1;
                if (index != numbers.lastIndex && stepen != 1) stringBuilder.append("x^${stepen}") else if (stepen == 1) stringBuilder.append( "x")
            }
            outputStr = stringBuilder.toString()
        }

        return outputStr
    }
}
