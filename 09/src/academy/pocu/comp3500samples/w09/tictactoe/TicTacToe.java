package academy.pocu.comp3500samples.w09.tictactoe;

import java.util.ArrayList;

public class TicTacToe {
    private static final int BOARD_SIZE = 9;

    private EMarker[] board;
    private EMarker player1;
    private EMarker player2;
    private int numFunctionCalls = 0;

    public int getNumFunctionCalls() {
        return this.numFunctionCalls;
    }

    public TicTacToe(final EMarker player) {
        this(player, getEmptyBoard());
    }

    public TicTacToe(final EMarker player, final EMarker[] board) {
        assert (player != EMarker.EMPTY);
        assert (board.length == BOARD_SIZE);

        this.board = board;
        this.player1 = player;
        this.player2 = player == EMarker.O ? EMarker.X : EMarker.O;
    }

    public Move getBestMove(final EMarker player) {
        return getBestMoveRecursive(this.board, player);
    }

    private Move getBestMoveRecursive(final EMarker[] newBoard, final EMarker player) {
        numFunctionCalls++;

        ArrayList<Integer> availableIndexes = getEmptyIndexes(newBoard);

        if (isWinningBoard(newBoard, this.player1)) {
            return new Move(-1, -10);
        }

        if (isWinningBoard(newBoard, this.player2)) {
            return new Move(-1, 10);
        }

        if (availableIndexes.size() == 0) {
            return new Move(-1, 0);
        }

        ArrayList<Move> moves = new ArrayList<>();

        for (int i = 0; i < availableIndexes.size(); ++i) {
            int index = availableIndexes.get(i);

            newBoard[availableIndexes.get(i)] = player;

            int score;
            if (player == this.player1) {
                score = getBestMoveRecursive(newBoard, this.player2).getScore();
            } else {
                score = getBestMoveRecursive(newBoard, this.player1).getScore();
            }

            newBoard[availableIndexes.get(i)] = EMarker.EMPTY;

            Move move = new Move(index, score);
            moves.add(move);
        }

        int bestIndex = 0;

        if (player == this.player2) {
            int maxScore = Integer.MIN_VALUE;
            for (int i = 0; i < moves.size(); ++i) {
                if (moves.get(i).getScore() > maxScore) {
                    maxScore = moves.get(i).getScore();
                    bestIndex = i;
                }
            }

        } else {
            int minScore = Integer.MAX_VALUE;
            for (int i = 0; i < moves.size(); ++i) {
                if (moves.get(i).getScore() < minScore) {
                    minScore = moves.get(i).getScore();
                    bestIndex = i;
                }
            }
        }

        return moves.get(bestIndex);
    }

    private static EMarker[] getEmptyBoard() {
        EMarker[] board = new EMarker[BOARD_SIZE];

        for (int i = 0; i < board.length; ++i) {
            board[i] = EMarker.EMPTY;
        }

        return board;
    }

    private static ArrayList<Integer> getEmptyIndexes(final EMarker[] board) {
        ArrayList<Integer> indexes = new ArrayList<>();

        for (int i = 0; i < board.length; ++i) {
            if (board[i] == EMarker.EMPTY) {
                indexes.add(i);
            }
        }

        return indexes;
    }

    private static boolean isWinningBoard(final EMarker[] board, final EMarker player) {
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
