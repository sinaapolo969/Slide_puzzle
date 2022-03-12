import java.util.ArrayList;
import java.util.Scanner;

public class Game
{
    static String[][] board = new String[9][];
    final public static int row = 9;
    final public static int col = 25;
    Scanner in = new Scanner(System.in);

    public Game()
    {
        createBoard();
    }

    public static void createBoard()
    {
        for (int i = 0; i < row; i++)
        {
            board[i] = new String[col];
        }
        for(int i = 0; i < row; i += 2)
        {
            for(int j = 0; j < col; j++)
            {
                board[i][j] = "\u2501";
            }
        }

        for(int i = 1; i < row; i += 2)
        {
            for(int j = 0; j < col; j++)
            {
                board[i][j] = " ";
            }
        }

        for(int i = 1; i < row; i += 2)
        {
            for(int j = 0; j < col; j += 6)
            {
                board[i][j] = "\u2503";
            }
        }

        for(int i = 2; i < row - 2; i += 2)
        {
            board[i][0] = "\u2523";
        }

        for(int i = 2; i < row - 2; i += 2)
        {
            board[i][col - 1] = "\u252B";
        }

        for(int j = 0; j < col; j += 6)
        {
            board[0][j] = "\u2533";
            if(j == 0)
            {
                board[0][j] = "\u250F";
            }
            if(j == col - 1)
            {
                board[0][j] = "\u2513";
            }
        }

        for(int i = 2; i < row - 2; i += 2)
        {
            for(int j  = 6; j < col - 5; j += 6)
            {
                board[i][j] = "\u254B";
            }
        }

        for(int j = 0; j < col; j += 6)
        {
            board[row - 1][j] = "\u253B";

            if(j == 0)
            {
                board[row - 1][j] = "\u2517";
            }

            if(j == col - 1)
            {
                board[row -1][j] = "\u251B";
            }
        }
        fillTheBoard();
    }

    private static void fillTheBoard()
    {
        board[1][3] = "O";
        board[1][9] = "J";
        board[1][15] = "I";
        board[1][21] = "L";
        board[3][3] = "M";
        board[3][9] = "E";
        board[3][15] = "D";
        board[3][21] = "H";
        board[5][3] = "B";
        board[5][9] = "G";
        board[5][15] = "N";
        board[5][21] = "K";
        board[7][3] = "H";
        board[7][9] = "A";
        board[7][15] = "F";
        Display.ptintFirstTime();
    }

    public static boolean checkSort()
    {
        ArrayList<String> indexes = new ArrayList<>();
        for (int i = 1; i < row; i += 2)
        {
            for (int j = 3; j < col; j += 6)
            {
                if (i == 7 && j == col - 4)
                {
                    break;
                }
                indexes.add(board[i][j]);
            }
        }
        ArrayList<String> order = new ArrayList<>();
        int first = 65;
        for (int i = 0; i < 15; i++)
        {
            char alphabet = (char) (first + i);
            order.add(String.valueOf(alphabet));
        }
        return indexes.equals(order);
    }

    public static void win()
    {
        if (checkSort())
        {
            System.out.println("YOU WIN!");
            System.exit(0);
        }
    }
}

