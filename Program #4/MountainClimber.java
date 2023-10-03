package student;

/* 
 * This class is meant to contain your algorithm.
 * You should implement the static method: findRoute
 * The input is:
 *   the number of rows and columns of
 *   a 2D array of integer heights
 *   a staring Point where row = start.y and col = start.x
 *   a goal Point
 * 
 * You should return an ArrayList of Points(x = col, y = row) for the least cost path
 * from the start to the goal.
 */
import java.awt.Point;
import java.util.ArrayList;

public class MountainClimber
{
    // Example routine that finds the most direct path.
    // This is a greedy algorithm that would minimize the distance traveled, 
    // however it does not find the least cost path when you also consider the
    // cost of height changes.
    public static ArrayList<Point> findRoute(int rows, int cols, int[][] grid, 
                                             Point start, Point goal) {
        ArrayList<Point> path = new ArrayList<Point>();
        path.add(start);
        Point current = start;
        double cost = 0.0; // calculating cost even though it is not used by
        // this simple example code
        final double SQRT2 = Math.sqrt(2.0);

        // just head as straight (as possible) for the goal
        do {
            // decide which cell to move to
            int dcol = goal.x - current.x; // (delta) change in columns needed
            if (dcol > 0) dcol = 1; // movement change in column is 1
            if (dcol < 0) dcol = -1;  // or -1 or else stays at 0

            int drow = goal.y - current.y; // change in rows needed
            if (drow > 0) drow = 1; // movement dir
            if (drow < 0) drow = -1;

            int newCol = current.x + dcol;
            int newRow = current.y + drow;

            // change in height		
            int dheight = grid[newRow][newCol] - grid[current.y][current.x];
            dheight = Math.abs(dheight);

            // add cost for this move
            if (dcol == 0 || drow == 0) // moving horiz or vertical
                cost += 1.0 + dheight * dheight * dheight;
            else    // moving diagonally
                cost += SQRT2 + dheight * dheight * dheight / 2.0;

            // add this new location to our path
            current = new Point(newCol, newRow); // move to this point
            path.add(current);               // add it to the path we are building
        } while (!current.equals(goal)); 

        System.out.println("Cost = "+cost);
        return path; 
    }	


}