import java.io.File

class Solver(val inputFileName: String) {
    val possibleValues = mutableListOf<String>()
    val file = File(inputFileName)
    val n = file.readLines()[0].toInt()
    val cells = createCellList()
    val puzzle: Puzzle = Puzzle(n, cells)

    init {
        setPossibleValues()
        puzzle.printAttributes()
    }


    fun setPossibleValues() {
        file.readLines()[1].forEach {
            if (it != ' ') {
                possibleValues.add(it.toString())
            }
        }
    }

    fun createCellList(): List<List<Cell>> {
        val cells = mutableListOf<List<Cell>>()
        val n: Int

        //read each character from row 2 onwards and create a cell for each
        for (i in 2 until file.readLines().size) {
            val row = mutableListOf<Cell>()
            file.readLines()[i].forEach {
                if(it != ' ') {
                    row.add(Cell(it.toString()))
                }
            }
            cells.add(row)
        }

        return cells
    }

    fun createCell(value: String): Cell {
        return Cell(value)
    }
}