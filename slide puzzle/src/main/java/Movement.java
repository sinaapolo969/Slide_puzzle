import java.util.Scanner;

public class Movement
{
    static Scanner in = new Scanner(System.in);

    public static void moveOnTheBoard()
    {
        char move = ' ';
        while (move != 'F')
        {
            move = Movement.in.next().charAt(0);
            switch (move)
            {
                case 'd':
                    Display.X += 6;
                    if (Display.X > Game.col - 4)
                    {
                        Display.X = 3;
                    }
                    break;
                case 'a':
                    Display.X -= 6;
                    if (Display.X < 3)
                    {
                        Display.X = Game.col - 4;
                    }
                    break;
                case 's':
                    Display.Y += 2;
                    if (Display.Y > Game.row - 2)
                    {
                        Display.Y = 1;
                    }
                    break;
                case 'w':
                    Display.Y -= 2;
                    if (Display.Y < 1)
                    {
                        Display.Y = Game.row - 2;
                    }
                    break;
                case 'T':
                    checkForEmpty();
                    break;
                case 'F':
                    System.exit(0);
            }
            Game.checkSort();
            Game.win();
            Display.updateTheBoard();
        }

    }

    private static void checkForEmpty()
    {
        //check the right house
        if (Display.X != Game.col - 4)
        {
            if (Game.board[Display.Y][Display.X + 6].equals(" "))
            {
                moveToEmpty(Display.Y, Display.X + 6);
            }
        }
        //check the left house
        if (Display.X != 3)
        {
            if (Game.board[Display.Y][Display.X - 6].equals(" "))
            {
                moveToEmpty(Display.Y, Display.X - 6);
            }
        }
        //check the Up house
        if (Display.Y != 1)
        {
            if (Game.board[Display.Y - 2][Display.X].equals(" "))
            {
                moveToEmpty(Display.Y - 2, Display.X);
            }
        }

        //check the Down house
        if (Display.Y != Game.row - 2)
        {
            if (Game.board[Display.Y + 2][Display.X].equals(" "))
            {
                moveToEmpty(Display.Y + 2, Display.X);
            }
        }

    }

    private static void moveToEmpty(int newY, int newX)
    {
        Game.board[newY][newX] = Game.board[Display.Y][Display.X];
        Game.board[Display.Y][Display.X] = " ";
    }
}
