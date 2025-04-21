package edu.mu.tddproject.player;


import edu.mu.tddproject.maze.Cell;
import edu.mu.tddproject.maze.Row;

/**
 * Player representation
 */
public class Player {
    private Row currentRow;
    private Cell currentCell;

    public Player(Row currentRow, Cell currentCell) {
        this.currentRow = currentRow;
        this.currentCell = currentCell;
    }

    public Row getCurrentRow() {
        return currentRow;
    }

    public Cell getCurrentCell() {
        return currentCell;
    }

    public void setCurrentRow(Row row) {
        this.currentRow = row;
    }

    public void setCurrentCell(Cell cell) {
        this.currentCell = cell;
    }

    @Override
    public String toString() {
        return "Player [currentCell=" + currentCell + ", currentRow=" + currentRow + "]";
    }
}
