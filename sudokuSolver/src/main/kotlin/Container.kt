abstract class Container(val cells: List<Cell>) {
    fun search(value: String): Boolean{
        for (cell in cells) {
            if (cell.value == value) {
                return false
            }
        }
        return true
    }

    fun print() {
        for (cell in cells) {
            print(cell.value)
        }
        println()
    }

}