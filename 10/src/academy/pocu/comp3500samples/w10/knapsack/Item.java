package academy.pocu.comp3500samples.w10.knapsack;

public class Item {
    private int value;
    private int space;

    public Item(final int value, final int space) {
        this.value = value;
        this.space = space;
    }

    public int getValue() {
        return this.value;
    }

    public int getSpace() {
        return this.space;
    }
}
