import com.google.gson.Gson

class Puzzle(val n: Int, val cells: List<List<Cell>>, val possibleValues: List<String>) {
    val rows : List<Row>
    val columns : List<Column>
    val blocks : List<Block>

    init {
        rows = setRows(cells)
        columns = setColumns(cells)
        blocks = setBlocks(cells)

    }


    fun isSolved(): Boolean {
        // if all cells in puzzle have value that isn't "-" set to true else false
        for (row in this.cells) {
            for (cell in row) {
                if (cell.currentValue == "-") {
                    return false
                }
            }
        }
        // check all each row, column, and block for duplicates
        return true
    }



    fun deepCopy() : Puzzle {
        return Gson().fromJson(Gson().toJson(this), this.javaClass)
    }


    fun printPuzzle() {
        for (row in this.cells) {
            for (cell in row) {
                print(cell.currentValue + " ")
            }
            println()
        }
        println("-----------------------------------------------------")
    }

    fun getPuzzleString(): String {
        var puzzleString = ""
        for (row in this.cells) {
            for (cell in row) {
                puzzleString += cell.currentValue + " "
            }
            puzzleString += "\n"
        }
        return puzzleString + "\n \n"
    }
    fun setRows(cells: List<List<Cell>>): List<Row> {
        val rows = mutableListOf<Row>()
        for (i in 0 until n) {
            val row = Row(cells[i])
            rows.add(row)
        }
        return rows
    }

    fun setColumns(cells: List<List<Cell>>): List<Column> {
        val columns = mutableListOf<Column>()
        for (i in 0 until n) {
            val column = mutableListOf<Cell>()
            for (j in 0 until n) {

                column.add(cells[j][i])
            }
            columns.add(Column(column))
        }
        return columns
    }


    fun setBlocks(cells: List<List<Cell>>): List<Block> {
        val blocks = mutableListOf<Block>()
        val blockSize = Math.sqrt(n.toDouble()).toInt()
        for (i in 0 until n step blockSize) {
            for (j in 0 until n step blockSize) {
                val blockCells = mutableListOf<Cell>()
                for (k in i until i + blockSize) {
                    for (l in j until j + blockSize) {
                        blockCells.add(cells[k][l])
                    }
                }
                val block = Block(blockCells)
                blocks.add(block)
            }
        }
        return blocks
    }



}