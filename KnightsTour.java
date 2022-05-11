import java.util.Scanner;
public class KnightsTour
{
    Scanner s = new Scanner(System.in);
    private int startRow;
    private int startCol;
    private int nextRow;
    private int nextCol;
    private int count;
    private int[][] board = new int[8][8];

    //creates a new KnightTour
    public KnightsTour()
    {
        count = 1;
        startRow = s.nextInt();
        while(startRow < 0 || startRow > 8)
        {
            startRow = s.nextInt();
        }
        startCol = s.nextInt();
        while(startCol < 0 || startCol > 8)
        {
            startCol = s.nextInt();
        }
    }

    //checks to see if an index is out of bounds
    public boolean checkIndex(int r, int c)
    {
        if((r < 0 || r > 8) || (c < 0 || c > 8))
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    //Checks if a space has already been landed on
    public boolean checkSpace(int r, int c)
    {
        if(board[r][c] == 0)
        {
            return true;
        }
        return true;
    }

    //Moves the night to a new space and assigns a number to its old space
    public void moveKnight(int times)
    {
        board[startRow][startCol] = count;
        count++;
        int[] coord = checkPossibleSpaces();
        startRow = coord[0];
        startCol = coord[1];
        if(times > 0)
        {
            moveKnight(times - 1);
        }
    }

    //Return the coordinate of the next space that the Knight will move to
    public int[] checkPossibleSpaces()
    {
        int highestExits = 0;
        int[] coordinate = new int[2];
        if(checkIndex(startRow - 2, startCol - 1) && checkSpace(startRow - 2, startCol -1))
        {
            if(highestExits < checkExits(startRow - 2, startCol - 1))
            {
                highestExits = checkExits(startRow - 2, startCol - 1);
            }
        }

        return coordinate;
    }

    //Returns the amount of exits that a certain space has
    public int checkExits(int r, int c)
    {
        int exits = 0;
        return exits;
    }
}
