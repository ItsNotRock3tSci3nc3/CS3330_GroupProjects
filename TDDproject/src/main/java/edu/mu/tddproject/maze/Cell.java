package edu.mu.tddproject.maze;


/**
 * Represents a cell
 */
public class Cell {
    private CellComponents left;
    private CellComponents right;
    private CellComponents up;
    private CellComponents down;

    /**
     * Cell constructor
     * @param left
     * @param right
     * @param up
     * @param down
     */
    public Cell(CellComponents left, CellComponents right, CellComponents up, CellComponents down) {
        this.left = (left != null) ? left : CellComponents.WALL;
        this.right = (right != null) ? right : CellComponents.WALL;
        this.up = (up != null) ? up : CellComponents.WALL;
        this.down = (down != null) ? down : CellComponents.WALL;
    }

    public CellComponents getLeft() { return left; }
    public CellComponents getRight() { return right; }
    public CellComponents getUp() { return up; }
    public CellComponents getDown() { return down; }

    /**
     * setter for left cell component
     * @param left CellComponent
     */
    public void setLeft(CellComponents left) {
        this.left = (left != null) ? left: CellComponents.WALL;
    }
    /**
     * setter for right cell component
     * @param right CellComponent
     */
    public void setRight(CellComponents right) {
    	this.right = (right != null) ? right: CellComponents.WALL;
    }
    
    /**
     * setter for up cell component
     * @param up CellComponent
     */
    public void setUp(CellComponents up) {
    	this.up = (up != null) ? up: CellComponents.WALL;
    }

    /**
     * setter for down cell component
     * @param down CellComponent
     */
    public void setDown(CellComponents down) {
    	this.down = (down != null) ? down: CellComponents.WALL;
    }

    @Override
    public String toString() {
        return "Cell [left=" + left + ", right=" + right + ", up=" + up + ", down=" + down + "]";
    }
}
