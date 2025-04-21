package edu.mu.tddproject.game;

import java.util.*;

import edu.mu.tddproject.maze.*;
import edu.mu.tddproject.player.*;

/**
 * Manages gamplay
 */
public class Game {
    private Grid grid;

    public Game(Grid grid) {
        this.grid = grid;
    }

    public Game(int size) {
        this.grid = createRandomGrid(size);
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public Grid createRandomGrid(int size) 
    {
        if (size < 3 || size > 7) { return null; }

        Random rand = new Random();
        ArrayList<Row> rows = new ArrayList<>();
        int exitRow = rand.nextInt(size);

        for (int i = 0; i < size; i++) 
        {
            ArrayList<Cell> cells = new ArrayList<>();
            
            for (int j = 0; j < size; j++) 
            {
                CellComponents left = CellComponents.WALL;
                CellComponents right = CellComponents.WALL;
                CellComponents up = CellComponents.WALL;
                CellComponents down = CellComponents.WALL;

                List<CellComponents> components = Arrays.asList(CellComponents.APERTURE, CellComponents.WALL);

                if (j == 0 && i == exitRow) {
                    left = CellComponents.EXIT;
                } 
                else {
                    left = components.get(rand.nextInt(components.size()));
                }

                right = components.get(rand.nextInt(components.size()));
                up = components.get(rand.nextInt(components.size()));
                down = components.get(rand.nextInt(components.size()));

                if (left != CellComponents.APERTURE && right != CellComponents.APERTURE &&
                    up != CellComponents.APERTURE && down != CellComponents.APERTURE &&
                    left != CellComponents.EXIT) {
                    left = CellComponents.APERTURE;
                }

                cells.add(new Cell(left, right, up, down));
            }
            rows.add(new Row(cells));
        }

        // Sync neighboring cell walls
        for (int i = 0; i < size; i++) 
        {
            for (int j = 0; j < size - 1; j++) 
            {
                Cell current = rows.get(i).getCells().get(j);
                Cell rightNeighbor = rows.get(i).getCells().get(j + 1);
                rightNeighbor.setLeft(current.getRight());
            }
        }

        for (int j = 0; j < size; j++) 
        {
            for (int i = 0; i < size - 1; i++) 
            {
                Cell current = rows.get(i).getCells().get(j);
                Cell downNeighbor = rows.get(i + 1).getCells().get(j);
                downNeighbor.setUp(current.getDown());
            }
        }

        return new Grid(rows);
    }

    public boolean play(Movement movement, Player player) {
        if (movement == null || player == null || grid == null) return false;

        ArrayList<Row> rows = grid.getRows();
        int rowIndex = rows.indexOf(player.getCurrentRow());
        int colIndex = player.getCurrentRow().getCells().indexOf(player.getCurrentCell());

        switch (movement) {
            case UP:
                if (player.getCurrentCell().getUp() == CellComponents.APERTURE && rowIndex > 0) {
                    player.setCurrentRow(rows.get(rowIndex - 1));
                    player.setCurrentCell(rows.get(rowIndex - 1).getCells().get(colIndex));
                    return true;
                }
                break;
            case DOWN:
                if (player.getCurrentCell().getDown() == CellComponents.APERTURE && rowIndex < rows.size() - 1) {
                    player.setCurrentRow(rows.get(rowIndex + 1));
                    player.setCurrentCell(rows.get(rowIndex + 1).getCells().get(colIndex));
                    return true;
                }
                break;
            case LEFT:
                if (player.getCurrentCell().getLeft() == CellComponents.APERTURE && colIndex > 0) {
                    player.setCurrentCell(player.getCurrentRow().getCells().get(colIndex - 1));
                    return true;
                } else if (player.getCurrentCell().getLeft() == CellComponents.EXIT && colIndex == 0) {
                    return true;
                }
                break;
            case RIGHT:
                if (player.getCurrentCell().getRight() == CellComponents.APERTURE && colIndex < rows.get(0).getCells().size() - 1) {
                    player.setCurrentCell(player.getCurrentRow().getCells().get(colIndex + 1));
                    return true;
                }
                break;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Game [grid=" + grid + "]";
    }
}
