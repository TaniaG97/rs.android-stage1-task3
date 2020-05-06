package subtask3

import java.util.function.Consumer

class ArrayCalculator {

    fun maxProductOf(numberOfItems: Int, itemsFromArray: Array<Any>): Int {
        var inputList = itemsFromArray.filterIsInstance<Int>().sortedDescending().toMutableList()
        var outputValue: Int = 1

        if (inputList.isEmpty()) outputValue = 0

        if (inputList.size <= numberOfItems){
            inputList.forEach { outputValue*=it }
        }else{
            var remainder = numberOfItems%2

            if(remainder == 1){
                outputValue*=inputList.first()
                inputList.removeAt(0)
            }

            val pairsList = mutableListOf<Int>()
            for(index in 0 until inputList.size-1){
                pairsList.add(inputList[index] * inputList[index+1])
            }

            pairsList.sortDescending()

            for(index in 0 until numberOfItems/2)
                outputValue*=pairsList[index]
        }

        return outputValue
    }
}
