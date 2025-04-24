package edu.mu.tddproject.simulation;

import edu.mu.tddproject.game.Game;
import edu.mu.tddproject.maze.Grid;
import edu.mu.tddproject.maze.Row;
import edu.mu.tddproject.player.Movement;
import edu.mu.tddproject.player.Player;

import java.util.ArrayList;
import java.util.Scanner;



/**
 * Main class to run the game
 * 
 * GITHUB: https://github.com/ItsNotRock3tSci3nc3/CS3330_GroupProjects/tree/main/TDDproject
 */
public class Simulation {
    public static void main(String[] args) {
        Game game = new Game(5);
        Grid grid = game.getGrid();
        ArrayList<Row> rows = grid.getRows();
        Player player = new Player(rows.get(rows.size() - 1), rows.get(rows.size() - 1).getCells().get(rows.get(0).getCells().size() - 1));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            printGrid(grid, player);
            System.out.println("Enter move (UP, DOWN, LEFT, RIGHT): ");
            try {
                Movement move = Movement.valueOf(scanner.nextLine().trim().toUpperCase());
                
                if (game.play(move, player)) {
                    
                	if (player.getCurrentCell().getLeft().toString().equals("EXIT")) {
                        System.out.println("You escaped the maze!");
                        break;
                    }
                } 
                else {
                    System.out.println("Invalid move. Try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Try UP, DOWN, LEFT, RIGHT.");
            }
        }
        scanner.close();
    }

    /**
     * Void method to print the grid
     * @param grid object
     * @param player object
     */
    private static void printGrid(Grid grid, Player player) {
        for (int i = 0; i < grid.getRows().size(); i++) {
            Row row = grid.getRows().get(i);
            
            for (int j = 0; j < row.getCells().size(); j++) {
                
            	if (player.getCurrentRow() == row && player.getCurrentCell() == row.getCells().get(j)) {
                    System.out.print("A ");
                } 
            	else if (row.getCells().get(j).getLeft().toString().equals("EXIT")) {
                    System.out.print("E ");
                } 
            	else {
                    System.out.print("S ");
                }
            }
            System.out.println();
        }
    }
}