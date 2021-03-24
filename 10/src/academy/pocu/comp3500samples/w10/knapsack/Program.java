package academy.pocu.comp3500samples.w10.knapsack;

public class Program {
    public static void main(String args[]) {
        Item[] items = new Item[5];

        items[0] = new Item(3, 5);
        items[1] = new Item(9, 12);
        items[2] = new Item(1, 2);
        items[3] = new Item(5, 4);
        items[4] = new Item(7, 9);

        int maxValue = getMaxValue(15, items);

        System.out.println(String.format("Max Value: %d", maxValue));
    }

    private static int getMaxValue(int maxSpace, Item[] items) {
        int numItems = items.length;

        int cache[][] = new int[numItems][maxSpace + 1];

        for (int s = 1; s <= maxSpace; ++s) {
            if (items[0].getSpace() > s) {
                continue;
            }

            cache[0][s] = items[0].getValue();
        }

        for (int i = 1; i < numItems; ++i) {
            for (int s = 1; s <= maxSpace; ++s) {
                if (items[i].getSpace() > s) {
                    cache[i][s] = cache[i - 1][s];
                    continue;
                }

                int choice1 = items[i].getValue()
                        + cache[i - 1][s - items[i].getSpace()];
                int choice2 = cache[i - 1][s];

                cache[i][s] = Math.max(choice1, choice2);
            }
        }

        return cache[numItems - 1][maxSpace];
    }
}
