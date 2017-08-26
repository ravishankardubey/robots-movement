package robot;

public class Robot 
{
    private static int x = 4; /* no. of columns and rows in the q=square matrix*/
    public static void main(String[] args) 
    {
        
        int[][] grid = new int[100][100]; /* grid creation of 100 X 100 */
        Robot rb = new Robot();
        int paths = rb.countPaths(grid, 0, 0); /* calling methd, to count paths */
        System.out.println("Total No. of Possible Paths : "+ paths );
    }
    int countPaths(int[][] grid, int i, int j)
    {

        if ( i < 0 || j < 0 || i >= x || j >= x ) 
            return 0;       /* if on traversal, the robot moves outside the grid */
        if ( grid[i][j] == 1 ) 
            return 0;       /* if the path has already been traversed then return 0  */
        if ( i == x-1 && j == x-1 ) 
            return 1;       /* if the robot is at the end point, then return 1 */
        
        int[][] newGrid = new int[100][100]; /* creation of new grid, on each traversal for complete check of paths */
        for(int m = 0; m < x; m++)
        {
            for( int n = 0; n < x; n++)
            {
                newGrid[m][n] = grid[m][n]; /* assigning all the values of grid to newGrid, form which it has been created */
            }
        }

        newGrid[i][j] = 1;  /* Assign 1 to the current position of Robot */
        return countPaths(newGrid, i, j+1) + countPaths(newGrid, i, j-1) +  countPaths(newGrid, i+1, j) + countPaths(newGrid, i-1, j);  /* calling of recursive function in all four directions of th current location of grid*/
    }
}