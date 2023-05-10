package TicTacToePackage;

import java.util.Scanner;

public class Terminal 
{
    private GamePiece[][] gameBoard = new GamePiece[3][3];
    private Scanner sc = new Scanner(System.in);

    /*
     * Parameters: 'X' or 'O', row, column
     * Post Condition: Game Piece properly inserted in gameBoard 
     */
    public void playerTurn(Player p, int row, int c)
    {
        if(isCoordinateValid(row, c))
        {
            gameBoard[row][c] = new GamePiece(p.getValue());
            System.out.println("Game Piece Successfully Implemented");
            displayBoard();
        }
        else
        {
            while(isCoordinateValid(row, c) != true)
            {
                System.out.print("Please enter a row number: ");
                row = sc.nextInt();
                System.out.println();
                System.out.print("Please enter a column number: ");
                c = sc.nextInt();
            }
            playerTurn(p, row, c);
        }
    }

    public boolean isCoordinateValid(int row, int column)
    {
        if(gameBoard[row][column] == null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void fillBoard()
    {
        for(int i = 0; i < gameBoard.length; i++)
        {
            for(int c = 0; c < gameBoard.length; c++)
            {
                gameBoard[i][c] = new GamePiece("_");
            }
        }
    }

    public void displayBoard()
    {
        for(GamePiece[] g : gameBoard)
        {
            for(GamePiece obj : g)
            {
                System.out.print(obj.getValue() + " ");
            }
            System.out.println();
        }
    }

    public boolean win()
    {
        if(diagonal())
        {
            return true;
        }
        else if(row())
        {
            return true;
        }
        else if(column())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean diagonal()
    {
        boolean val1 = false;
        boolean val2 = false;

        for(int row = 1; row < gameBoard.length; row++)
        {
            for(int col = row; col < gameBoard.length; col++)
            {
                if(gameBoard[row][col].getValue().equals(gameBoard[row-1][col-1].getValue()))
                {
                    val1 = true;
                }
                else
                {
                    val1 = false;
                }
            }
        }

        for(int row = 2; row >= 1; row--)
        {
            for(int col = gameBoard.length - row - 1; col <= row; col++)
            {
                if(gameBoard[row][col].getValue().equals(gameBoard[row-1][col+1].getValue()))
                {
                    val2 = true;
                }
                else
                {
                    val2 = false;
                }
            }
        }

        if(val1 == true && val2 == true)
        {
            return true;
        }
        return false;
    }

    public boolean row()
    {
        boolean val = false;
        for(int row = 0; row < gameBoard.length; row++)
        {
            for(int col = 1; col < gameBoard.length; col++)
            {
                if(gameBoard[row][col].getValue().equals(gameBoard[row][col-1].getValue()))
                {
                    val = true;
                }
                else
                {
                    val = false;
                }
            }
            if(val == true) { return true; }
            val = false;
        }
        return val;
    }

    public boolean column()
    {
        boolean val = false;
        for(int col = 1; col < gameBoard.length; col++)
        {
            for(int row = 0; row < gameBoard.length; row++)
            {
                if(gameBoard[row][col].getValue().equals(gameBoard[row][col - 1].getValue()))
                {
                    val = true;
                }
                else
                {
                    val = false;
                }
            }
            if(val == true) { return true; }
            val = false;
        }
        return val;  
    }

    public boolean draw()
    {
        boolean val = false;

        for(int i = 0; i < gameBoard.length; i++)
        {
            for(int c = 0; c < gameBoard.length; c++)
            {
                if(gameBoard[i][c] != null)
                {
                    val = true;
                }
                else
                {
                    val = false;
                    return val;
                }
            }
        }

        return val;
    }

    public void run()
    {
        Player p1;
        Player p2;
        System.out.print("Choose a value for Player 1 (X or O): ");
        String s = sc.next();

        p1 = new Player(s);
        if(s.equals("X")) { p2 = new Player("O"); }
        else { p2 = new Player("X"); }

        fillBoard();
        displayBoard();

        while(win() == false || draw() == true)
        {
            //Game Loop
        }

        //System.out.println(p1.getValue() + " " + p1.getID()); Test --> Successfull
        //System.out.println(p2.getValue() + " " + p2.getID()); Test --> Successfull

        
        
    }

    public static void main(String[] args) {
        new Terminal().run();
    }
}
