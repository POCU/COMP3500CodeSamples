package academy.pocu.comp3500samples.w09.tictactoe;

public class Move {
    private int index;
    private int score;

    public Move(final int index, final int score) {
        this.index = index;
        this.score = score;
    }

    public int getIndex() {
        return this.index;
    }

    public int getScore() {
        return this.score;
    }
}
