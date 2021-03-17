package academy.pocu.comp3500samples.w09.tictactoe;

import java.util.ArrayList;

public class TicTacToe {
    public static final int BOARD_SIZE = 9;

    private TicTacToe() {
    }

    public static int getBestMoveIndex(final Player[] board, final Player player) {
        assert (board.length == BOARD_SIZE);

        Player opponent = player == Player.O
                ? Player.X : Player.O;

        Move move = getBestMoveRecursive(board,
                player,
                opponent,
                player);

        return move.getIndex();
    }

    private static Move getBestMoveRecursive(final Player[] board, final Player player, final Player opponent, final Player turn) {
        assert (board.length == BOARD_SIZE);

        if (hasWon(board, opponent)) {
            return new Move(-1, -10);
        }

        if (hasWon(board, player)) {
            return new Move(-1, 10);
        }

        ArrayList<Integer> availableIndexes = getEmptyIndexes(board);
        if (availableIndexes.isEmpty()) {
            return new Move(-1, 0);
        }

        ArrayList<Move> moves = new ArrayList<>();

        for (int i = 0; i < availableIndexes.size(); ++i) {
            int index = availableIndexes.get(i);

            Player[] newBoard = copyBoard(board);

            newBoard[index] = turn;

            Player nextPlayer = turn == player
                    ? opponent : player;

            int score = getBestMoveRecursive(newBoard,
                    player,
                    opponent,
                    nextPlayer)
                    .getScore();

            Move move = new Move(index, score);
            moves.add(move);
        }

        if (turn == player) {
            return getMaxScoreMove(moves);
        }

        return getMinScoreMove(moves);
    }

    private static Move getMaxScoreMove(final ArrayList<Move> moves) {
        assert (!moves.isEmpty());

        Move bestMove = moves.get(0);
        for (int i = 1; i < moves.size(); ++i) {
            if (moves.get(i).getScore() > bestMove.getScore()) {
                bestMove = moves.get(i);
            }
        }

        return bestMove;
    }

    private static Move getMinScoreMove(final ArrayList<Move> moves) {
        assert (!moves.isEmpty());

        Move bestMove = moves.get(0);
        for (int i = 0; i < moves.size(); ++i) {
            if (moves.get(i).getScore() < bestMove.getScore()) {
                bestMove = moves.get(i);
            }
        }

        return bestMove;
    }

    private static Player[] copyBoard(final Player[] board) {
        assert (board.length == BOARD_SIZE);

        Player[] newBoard = new Player[board.length];

        for (int i = 0; i < board.length; ++i) {
            newBoard[i] = board[i];
        }

        return newBoard;
    }

    private static ArrayList<Integer> getEmptyIndexes(final Player[] board) {
        assert (board.length == BOARD_SIZE);

        ArrayList<Integer> indexes = new ArrayList<>();

        for (int i = 0; i < board.length; ++i) {
            if (board[i] == null) {
                indexes.add(i);
            }
        }

        return indexes;
    }

    private static boolean hasWon(final Player[] board, final Player player) {
        assert (board.length == BOARD_SIZE);

        return (board[0] == player && board[1] == player && board[2] == player)
                || (board[3] == player && board[4] == player && board[5] == player)
                || (board[6] == player && board[7] == player && board[8] == player)
                || (board[0] == player && board[3] == player && board[6] == player)
                || (board[1] == player && board[4] == player && board[7] == player)
                || (board[2] == player && board[5] == player && board[8] == player)
                || (board[0] == player && board[4] == player && board[8] == player)
                || (board[2] == player && board[4] == player && board[6] == player);
    }
}
