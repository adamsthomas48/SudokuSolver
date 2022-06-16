abstract class Container(val cells: List<Cell>) {
    fun search(value: String): Boolean{
        for (cell in cells) {
            if (cell.currentValue == value) {
                return false
            }
        }
        return true
    }

    fun update(cell: Cell, value: String) {
        for (c in cells) {
            if (c.rowIndex == cell.rowIndex && c.columnIndex == cell.columnIndex) {
                c.currentValue = value
            }
        }
    }

    fun print() {
        for (cell in cells) {
            print(cell.currentValue)
        }
        println()
    }

    fun getCell(index: Int): Cell {
        return cells[index]
    }

}