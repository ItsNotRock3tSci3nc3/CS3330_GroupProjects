package edu.mu.tddproject.player;

import edu.mu.tddproject.maze.Cell;
import edu.mu.tddproject.maze.Row;

/**
 * Represents agent
 */
public class Player {
    private Row currentRow;
    private Cell currentCell;

    /**
     * Player constructor, initializes variables
     * @param currentRow: starting row
     * @param currentCell: starting cell
     */
    public Player(Row currentRow, Cell currentCell) {
        this.currentRow = currentRow;
        this.currentCell = currentCell;
    }

    /**
     * getter for current row
     * @return currentRow
     */
    public Row getCurrentRow() {
        return currentRow;
    }

    /**
     * getter for current cell
     * @return currentCell
     */
    public Cell getCurrentCell() {
        return currentCell;
    }
    
    /**
     * setter for current row
     * @param row object
     */
    public void setCurrentRow(Row row) {
        this.currentRow = row;
    }

    /**
     * setter for current cell
     * @param cell object
     */
    public void setCurrentCell(Cell cell) {
        this.currentCell = cell;
    }

    @Override
    public String toString() {
        return "Player [currentCell=" + currentCell + ", currentRow=" + currentRow + "]";
    }
}