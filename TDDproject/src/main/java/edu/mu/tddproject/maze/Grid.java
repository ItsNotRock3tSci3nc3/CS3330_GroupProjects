package edu.mu.tddproject.maze;

import java.util.ArrayList;

/**
 * Represents the grid of the maze
 */
public class Grid {
    private ArrayList<Row> rows;

    /**
     * Grid constructor
     * @param ArrayList<Row> rows 
     */
    public Grid(ArrayList<Row> rows) {
        this.rows = rows;
    }
    
    /**
     * Getter for rows
     * @return rows
     */
    public ArrayList<Row> getRows() {
        return rows;
    }

    /**
     * setter for rows
     * @param ArrayList<Row> rows
     */
    public void setRows(ArrayList<Row> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "Grid [rows=" + rows + "]";
    }
}
