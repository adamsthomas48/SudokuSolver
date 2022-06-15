import java.io.File
import java.util.*

class Solver(val inputFileName: String) {
    val file = File(inputFileName)
    val n = file.readLines()[0].toInt()
    val cells = createCellList()
    val possibleValues = setPossibleValues()
    var currentPuzzle: Puzzle = Puzzle(n, cells, possibleValues)
    val puzzleStack: Stack<Puzzle> = Stack()


    fun solve() {
        currentPuzzle.printPuzzle()
        println()
        puzzleStack.push(currentPuzzle)
        while (!puzzleStack.empty() && !currentPuzzle.isSolved()) {
            if(GuessStrategy().execute(currentPuzzle)) {
                // push this version of the puzzle onto the stack
                puzzleStack.push(currentPuzzle.deepCopy())
            } else {
                println("Backtracking")
                currentPuzzle = puzzleStack.pop()

            }

        }
        currentPuzzle.printPuzzle()

    }



    fun setPossibleValues(): List<String> {
        val possibleValues = mutableListOf<String>()
        file.readLines()[1].forEach {
            if (it != '-' && it != ' ') {
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
        val col = j
        val row = i
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