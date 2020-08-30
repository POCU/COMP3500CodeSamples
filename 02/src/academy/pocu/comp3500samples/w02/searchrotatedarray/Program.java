package academy.pocu.comp3500samples.w02.searchrotatedarray;

public class Program {

    public static void main(String[] args) {
        int[] arry = new int[]{20, 25, 26, 29, 33, 1, 3, 5, 6, 10, 11, 19};

        int index = indexOfRotatedArray(arry, 0, arry.length - 1, 0);

        System.out.println(index);

        index = indexOfRotatedArray(arry, 0, arry.length - 1, 1);

        System.out.println(index);

        index = indexOfRotatedArray(arry, 0, arry.length - 1, 29);

        System.out.println(index);

        index = indexOfRotatedArray(arry, 0, arry.length - 1, 6);

        System.out.println(index);
    }

    private static int indexOfRotatedArray(int[] arry, int start, int end, int num) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;

        if (arry[mid] == num) {
            return mid;
        }

        if (arry[start] <= arry[mid]) {
            if (num >= arry[start] && num <= arry[mid]) {
                return indexOfRotatedArray(arry, start, mid - 1, num);
            }

            return indexOfRotatedArray(arry, mid + 1, end, num);
        }

        if (num >= arry[mid] && num <= arry[end]) {
            return indexOfRotatedArray(arry, mid + 1, end, num);
        }

        return indexOfRotatedArray(arry, start, mid - 1, num);
    }
}
