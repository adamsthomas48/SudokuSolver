class Puzzle(val n: Int, val cells: List<List<Cell>>) {
    val rows = setRows(cells)
    val columns = setColumns(cells)
    val blocks = setBlocks(cells)

    fun printAttributes(){
        println("n: $n")
        //print value of cells
        for (row in cells) {
            for (cell in row) {
                print("${cell.value} ")
            }
            println()
        }
        //print each cell.value in each row of Rows

        //print each cell.value in each row of Blocks
        for (block in blocks) {
            print("Block: ")
            for (cell in block.cells) {
                print("${cell.value} ")
            }
            println()
        }

        //print each cell.value in each row of Columns
        for (column in columns) {
            print("Column: ")
            for (cell in column.cells) {
                print("${cell.value} ")
            }
            println()
        }


    }

    fun setRows(cells: List<List<Cell>>): List<Row> {
        val rows = mutableListOf<Row>()
        for (i in 0 until n) {
            val row = Row(this, cells[i])
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
            columns.add(Column(this, column))
        }
        return columns
    }

    //create list of blocks based on number of rows and columns
    //A block represents a sudoku puzzle square of size sqrt(n)
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
                val block = Block(this, blockCells)
                blocks.add(block)
            }
        }
        return blocks
    }


}