package academy.pocu.comp3500samples.w02.searchrotatedarray;

public class Program {

    public static void main(String[] args) {
        int[] arry = new int[]{20, 25, 26, 29, 33, 1, 3, 5, 6, 10, 11, 19};

        int index = indexOfRotatedArray(arry, 0, 0, arry.length - 1);

        System.out.println(index);

        index = indexOfRotatedArray(arry, 1, 0, arry.length - 1);

        System.out.println(index);

        index = indexOfRotatedArray(arry, 29, 0, arry.length - 1);

        System.out.println(index);

        index = indexOfRotatedArray(arry, 6, 0, arry.length - 1);

        System.out.println(index);
    }

    private static int indexOfRotatedArray(int[] arry, int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;

        if (arry[mid] == target) {
            return mid;
        }

        if (arry[start] <= arry[mid]) {
            if (target >= arry[start] && target <= arry[mid]) {
                return indexOfRotatedArray(arry, target, start, mid - 1);
            }

            return indexOfRotatedArray(arry, target, mid + 1, end);
        }

        if (target >= arry[mid] && target <= arry[end]) {
            return indexOfRotatedArray(arry, target, mid + 1, end);
        }

        return indexOfRotatedArray(arry, target, start, mid - 1);
    }
}
