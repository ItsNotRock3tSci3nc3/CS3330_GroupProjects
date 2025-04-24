package edu.mu.tddproject.maze;

import java.util.ArrayList;

/**
 * Represents a row in the maze
 */
public class Row {
    private ArrayList<Cell> cells;
    
    /**
     * Row constructor
     * @param ArrayList<Cell> cells
     */
    public Row(ArrayList<Cell> cells) {
        this.cells = cells;
    }

    /**
     * Getter for cells
     * @return cells
     */
    public ArrayList<Cell> getCells() {
        return cells;
    }

    /**
     * setter for cells
     * @param ArrayList<Cell> cells
     */
    public void setCells(ArrayList<Cell> cells) {
        this.cells = cells;
    }

    @Override
    public String toString() {
        return "Row [cells=" + cells + "]";
    }
}
