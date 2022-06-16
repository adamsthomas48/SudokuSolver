import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class CellTest {
    val cell = Cell("-", 1,1,1,true)

    @Test
    fun getCurrentValue() {
        assertEquals("-", cell.currentValue)
    }

    @Test
    fun setCurrentValue() {
        cell.currentValue = "X"
        assertEquals("X", cell.currentValue)
    }

    @Test
    fun getPossibleValues() {
        cell.possibleValues.add("X")
        assertEquals("X", cell.possibleValues[0])
    }

    @Test
    fun setPossibleValues() {
        cell.possibleValues.add("X")
        assertEquals("X", cell.possibleValues[0])
    }

    @Test
    fun deepCopy() {
        val cell2 = cell.deepCopy()
        assertEquals(cell.value, cell2.value)

    }

    @Test
    fun getValue() {
        assertEquals("-", cell.value)
    }

    @Test
    fun setValue() {
        cell.value = "X"
        assertEquals("X", cell.value)
    }

    @Test
    fun getRowIndex() {
        assertEquals(1, cell.rowIndex)
    }

    @Test
    fun getColumnIndex() {
        assertEquals(1, cell.columnIndex)
    }

    @Test
    fun getBlockIndex() {
        assertEquals(1, cell.blockIndex)
    }

    @Test
    fun isEditable() {
        assertEquals(true, cell.isEditable)
    }

}