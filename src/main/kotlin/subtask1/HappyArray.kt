package subtask1

class HappyArray {


    fun convertToHappy(sadArray: IntArray): IntArray {
        val result = sadArray.toMutableList()

        for (i in result.size - 3 downTo 0) {
            if (result[i + 2] + result[i] < result[i + 1]) {
                result.removeAt(i + 1)
            }
        }
        return result.toIntArray()
    }
}
