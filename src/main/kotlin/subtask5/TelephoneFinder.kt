package subtask5

import kotlin.reflect.KClass

class TelephoneFinder {

    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        var inputList = number.toMutableList()
        var outputList = mutableListOf<String>()

        for (i in inputList.indices){
             when(number[i]){
                '0' -> listOf('8').forEach{ outputList.add(number.replaceRange(i, i + 1,it.toString() ))}
                '1' -> listOf('2', '4').forEach{ outputList.add(number.replaceRange(i, i + 1,it.toString() ))}
                '2' -> listOf('1', '3', '5').forEach{ outputList.add(number.replaceRange(i, i + 1,it.toString() ))}
                '3' -> listOf('2', '6').forEach{ outputList.add(number.replaceRange(i, i + 1,it.toString() ))}
                '4' -> listOf('1', '5', '7').forEach{ outputList.add(number.replaceRange(i, i + 1,it.toString() ))}
                '5' -> listOf('2', '4', '6', '8').forEach{ outputList.add(number.replaceRange(i, i + 1,it.toString() ))}
                '6' -> listOf('3', '5', '9').forEach{ outputList.add(number.replaceRange(i, i + 1,it.toString() ))}
                '7' -> listOf('4', '8').forEach{ outputList.add(number.replaceRange(i, i + 1,it.toString() ))}
                '8' -> listOf('5', '7', '9', '0').forEach{ outputList.add(number.replaceRange(i, i + 1,it.toString() ))}
                '9' -> listOf('6', '8').forEach{ outputList.add(number.replaceRange(i, i + 1,it.toString() ))}
                else -> return null
            }
        }
        return outputList.toTypedArray()
    }
}
