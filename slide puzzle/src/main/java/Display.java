import java.io.IOException;
import java.io.PrintStream;

public class Display
{
    public static int X = 3;
    public static int Y = 1;

    public static void updateTheBoard()
    {
        String[] temp = new String[2];
        temp[0] = Game.board[Display.Y - 1][Display.X - 3];
        temp[1] = Game.board[Display.Y + 1][Display.X + 3];
        Game.board[Display.Y - 1][Display.X - 3] = "\u2554";
        Game.board[Display.Y + 1][Display.X + 3] = "\u255D";
        printTheBoard();
        normal(temp);
    }

    public static void ptintFirstTime()
    {
        String[] temp = new String[2];
        temp[0] = Game.board[Display.Y - 1][Display.X - 3];
        temp[1] = Game.board[Display.Y + 1][Display.X + 3];
        Game.board[Display.Y - 1][Display.X - 3] = "\u2554";
        Game.board[Display.Y + 1][Display.X + 3] = "\u255D";
        printTheBoard();
        normal(temp);
    }

    private static void normal(String[] temp)
    {
        Game.board[Display.Y - 1][Display.X - 3] = temp[0];
        Game.board[Display.Y + 1][Display.X + 3] = temp[1];
        Movement.moveOnTheBoard();
    }

    private static void clearConsole()
    {
        try
        {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
        catch (IOException | InterruptedException error)
        {

        }

    }

    private static void printTheBoard()
    {
        clearConsole();
        PrintStream out = null;
        try
        {
            for (int i = 0; i < Game.row; i++)
            {
                for (int j = 0; j < Game.col; j++)
                {
                    out = new PrintStream(System.out, true, "UTF-8");
                    out.print(Game.board[i][j]);
                }
                System.out.println();
            }
        }
        catch (Exception ignored)
        {

        }
    }
}
