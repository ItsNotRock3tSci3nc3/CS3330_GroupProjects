package edu.mu.tddproject.maze;

import java.util.ArrayList;

/**
 * Represents a row in the maze
 */
public class Row {
    private ArrayList<Cell> cells;

    public Row(ArrayList<Cell> cells) {
        this.cells = cells;
    }

    public ArrayList<Cell> getCells() {
        return cells;
    }

    public void setCells(ArrayList<Cell> cells) {
        this.cells = cells;
    }

    @Override
    public String toString() {
        return "Row [cells=" + cells + "]";
    }
}
