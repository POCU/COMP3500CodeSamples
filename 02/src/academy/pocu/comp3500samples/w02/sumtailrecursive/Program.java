package academy.pocu.comp3500samples.w02.sumtailrecursive;

public class Program {
    public static void main(String[] args) {
        int sum = sumTailRecursive(10);

        System.out.println(sum); // 55

        sum = sumTailRecursive(100);

        System.out.println(sum); // 5050

        sum = sumTailRecursive(1000);

        System.out.println(sum); // 500500

        sum = sumTailRecursive(100000); // ??

        System.out.println(sum);
    }

    private static int sumTailRecursive(int n) {
        return sumTailRecursiveHelper(n, 0);
    }

    private static int sumTailRecursiveHelper(int n, int sum) {
        if (n <= 0) {
            return sum;
        }

        return sumTailRecursiveHelper(n - 1, sum + n);
    }
}
