package academy.pocu.comp3500samples.w02.searchrotatedarray;

public class Program {

    public static void main(String[] args) {
        int[] numbers = new int[]{20, 25, 26, 29, 33, 1, 3, 5, 6, 10, 11, 19};

        int index = indexOfRotatedArray(numbers, 0, numbers.length - 1, 0);

        System.out.println(index);

        index = indexOfRotatedArray(numbers, 0, numbers.length - 1, 1);

        System.out.println(index);

        index = indexOfRotatedArray(numbers, 0, numbers.length - 1, 29);

        System.out.println(index);

        index = indexOfRotatedArray(numbers, 0, numbers.length - 1, 6);

        System.out.println(index);
    }

    private static int indexOfRotatedArray(int[] numbers, int start, int end, int num) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;
        if (numbers[mid] == num) {
            return mid;
        }

        if (numbers[start] <= numbers[mid]) {
            if (numbers[start] <= num && num <= numbers[mid]) {
                return indexOfRotatedArray(numbers, start, mid - 1, num);
            }

            return indexOfRotatedArray(numbers, mid + 1, end, num);
        }

        if (numbers[mid] <= num && num <= numbers[end]) {
            return indexOfRotatedArray(numbers, mid + 1, end, num);
        }

        return indexOfRotatedArray(numbers, start, mid - 1, num);
    }
}
