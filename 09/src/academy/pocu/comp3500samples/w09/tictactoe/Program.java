package academy.pocu.comp3500samples.w09.tictactoe;

import java.time.Duration;
import java.time.Instant;

public class Program {
    public static void main(String[] args) {
        TicTacToe tictactoe = new TicTacToe(EMarker.O);

        Instant start = Instant.now();
        Move bestMove = tictactoe.getBestMove(EMarker.X);
        Instant finish = Instant.now();

        long timeElapsed = Duration.between(start, finish).toMillis();

        System.out.println(String.format("elapsed (ms): %d", timeElapsed));
        System.out.println(String.format("best move index: %d", bestMove.getIndex()));
        System.out.println(String.format("function calls: %d", tictactoe.getNumFunctionCalls()));

        // -------------------------------------------------------

        EMarker[] board = new EMarker[] { EMarker.O, EMarker.EMPTY, EMarker.X, EMarker.X, EMarker.EMPTY, EMarker.X, EMarker.EMPTY, EMarker.O, EMarker.O };

        tictactoe = new TicTacToe(EMarker.O, board);

        start = Instant.now();
        bestMove = tictactoe.getBestMove(EMarker.X);
        finish = Instant.now();

        timeElapsed = Duration.between(start, finish).toMillis();

        System.out.println(String.format("elapsed (ms): %d", timeElapsed));
        System.out.println(String.format("best move index: %d", bestMove.getIndex()));
        System.out.println(String.format("function calls: %d", tictactoe.getNumFunctionCalls()));
    }
}
