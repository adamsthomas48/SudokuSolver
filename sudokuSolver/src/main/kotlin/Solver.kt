import java.io.File

class Solver(val inputFileName: String) {
    val possibleValues = mutableListOf<String>()

    fun createCellList(): List<List<Cell>> {
        val cells = mutableListOf<List<Cell>>()
        val n: Int
        //create file from inputFile
        val file = File(inputFileName)
        n = file.readLines()[0].toInt()
        //add any non whitespace characters from second line to possibleValues
        file.readLines()[1].forEach {
            if (it != ' ') {
                possibleValues.add(it.toString())
            }
        }

        //read each character from row 2 onwards and create a cell for each
        for (i in 2 until file.readLines().size) {
            val row = mutableListOf<Cell>()
            file.readLines()[i].forEach {
                if(it != ' ') {
                    row.add(Cell(it.toString()))
                    print(it + " ")
                }


            }
            cells.add(row)
            println()
        }



        return cells
    }

    fun createCell(value: String): Cell {
        return Cell(value)
    }
}