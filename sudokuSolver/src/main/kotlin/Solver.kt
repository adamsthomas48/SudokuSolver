import java.io.File

class Solver(val inputFileName: String) {
    val file = File(inputFileName)
    val n = file.readLines()[0].toInt()
    val cells = createCellList()
    val puzzle: Puzzle = Puzzle(n, cells)
    val possibleValues = setPossibleValues()



    fun setPossibleValues(): List<String> {
        val possibleValues = mutableListOf<String>()
        file.readLines()[1].forEach {
            if (it != ' ') {
                possibleValues.add(it.toString())
            }
        }
        return possibleValues
    }

    fun createCellList(): List<List<Cell>> {
        val cells = mutableListOf<List<Cell>>()
        val n: Int

        //read each character from row 2 onwards and create a cell for each
        for (i in 2 until file.readLines().size) {
            val row = mutableListOf<Cell>()
            file.readLines()[i].forEach {
                if(it != ' ') {
                    val cell = createCell(it.toString(), i - 2, row.size)

                    row.add(cell)
                }
            }
            cells.add(row)
        }

        return cells
    }

    fun createCell(value: String, i: Int, j: Int): Cell {
        val col = i
        val row = j
        //determine what sudoku block the cell is in based on i j and size n
        val block = getBlockIndex(i, j)
        return Cell(value, row, col, block, (value == "-"))

    }

    fun getBlockIndex(i: Int, j: Int): Int {

        val x = Math.floor(j / Math.sqrt(n.toDouble())).toInt()
        val y = Math.floor(i / Math.sqrt(n.toDouble())).toInt()
        return x + (y * Math.sqrt(n.toDouble()).toInt())

    }


}