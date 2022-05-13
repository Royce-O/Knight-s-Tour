import java.util.Scanner;
public class KnightsTour
{
    Scanner s = new Scanner(System.in);
    private int startRow;
    private int startCol;
    private int count;
    private int[][] board = new int[8][8];
    private final int[] x = {-2, -1, 1, 2, 2, 1, -1, -2};
    private final int[] y = {1, 2, 2, 1, -1, -2, -2, -1};

    //creates a new KnightTour
    public KnightsTour()
    {
        count = 1;
        System.out.println("Input a row coordinate between 0 and 7:");
        startRow = s.nextInt();
        while(startRow < 0 || startRow > 7)
        {
            System.out.println("Row is not within bounds");
            startRow = s.nextInt();
        }
        System.out.println("Input a column coordinate between 0 and 7");
        startCol = s.nextInt();
        while(startCol < 0 || startCol > 7)
        {
            System.out.println("Column is not within bounds");
            startCol = s.nextInt();
        }
    }

    //checks to see if an index is out of bounds
    public boolean checkIndex(int r, int c)
    {
        if((r < 0 || r > 7) || (c < 0 || c > 7))
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
        return false;
    }

    //Moves the night to a new space and assigns a number to its old space
    public void moveKnight(int times)
    {
        board[startRow][startCol] = count;
        count++;
        int[] coord = checkPossibleSpaces();
        startRow = coord[0];
        startCol = coord[1];
        if(times > 1)
        {
            moveKnight(times - 1);
        }
    }

    //Return the coordinate of the next space that the Knight will move to
    public int[] checkPossibleSpaces()
    {
        int lowestExits = 8;
        int[] coordinate = new int[2];
        for(int i = 0; i < x.length; i++)
        {
            if (checkIndex(startRow + x[i], startCol + y[i]) && checkSpace(startRow + x[i], startCol + y[i]))
            {
                if (lowestExits > checkExits(startRow + x[i], startCol + y[i]))
                {
                    lowestExits = checkExits(startRow + x[i], startCol + y[i]);
                    coordinate[0] = startRow + x[i];
                    coordinate[1] = startCol + y[i];
                }
            }
        }
        return coordinate;
    }

    //Returns the amount of exits that a certain space has
    public int checkExits(int r, int c)
    {
        int exits = 0;
        for(int i = 0; i < x.length; i++)
        {
            if (checkIndex(r + x[i], c + y[i]) && checkSpace(r + x[i], c + y[i]))
            {
                exits++;
            }
        }
        return exits;
    }

    public void returnBoard()
    {
        for(int r = 0; r < board.length; r++)
        {
            for(int c = 0; c < board[r].length; c++)
            {
                System.out.print(board[r][c] + "  ");
                if(board[r][c] < 10)
                {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }

    public static void main(String[] args)
    {
        KnightsTour k = new KnightsTour();
        k.moveKnight(64);
        k.returnBoard();
    }
}
