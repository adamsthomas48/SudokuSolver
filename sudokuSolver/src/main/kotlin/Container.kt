abstract class Container(val puzzle: Puzzle, val cells: List<Cell>) {
    fun search(value: String): Boolean{
        for (cell in cells) {
            if (cell.value == value) {
                return true
            }
        }
        return false
    }

}