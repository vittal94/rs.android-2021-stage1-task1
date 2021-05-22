package subtask3

class StringParser {


    fun getResult(inputString: String): Array<String> {
        val result = mutableListOf<String>()

        for (i in inputString.indices){
            if (inputString[i] == '(' || inputString[i] == '[' || inputString[i] == '<') {
                val index = i + 1
                val element = inputString[i]
                val flipElement = when (element) {
                    '<' -> '>'
                    '(' -> ')'
                    else -> ']'
                }
                val exceptElement = when (element) {
                    '<' -> charArrayOf('(','[')
                    '[' -> charArrayOf('<','(')
                    else -> charArrayOf('<','[')
                }
                var isExceptElement = false

                for (j in index until inputString.length) {
                    if (inputString[j] in exceptElement)
                        isExceptElement = true

                    if (inputString[j] == element && !isExceptElement)
                        break

                    if (inputString[j] == flipElement)
                        result.add(inputString.substring(index,j))
                }
            }
        }
        return result.toTypedArray()
    }
}
