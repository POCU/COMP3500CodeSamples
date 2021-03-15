package academy.pocu.comp3500samples.w09.tictactoe;

public class Program {
    public static void main(String[] args) {
        {
            Player[] board = new Player[TicTacToe.BOARD_SIZE];

            int index = TicTacToe.getBestPlayIndex(board, Player.X);

            System.out.println(String.format("best move index: %d", index));
        }

        {
            Player[] board = new Player[] { null, Player.O, Player.X, Player.X, Player.O, Player.O, null, null, Player.X };

            int index = TicTacToe.getBestPlayIndex(board, Player.X);

            System.out.println(String.format("best move index: %d", index));
        }

        {
            Player[] board = new Player[] { Player.O, null, Player.X, Player.X, null, Player.X, null, Player.O, Player.O };

            int index = TicTacToe.getBestPlayIndex(board, Player.X);

            System.out.println(String.format("best move index: %d", index));
        }
    }
}
