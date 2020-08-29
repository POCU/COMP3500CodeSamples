package academy.pocu.comp3500samples.w02.sumrecursive;

public class Program {
    public static void main(String[] args) {
        int sum = sumRecursive(10);

        System.out.println(sum); // 55

        sum = sumRecursive(100);

        System.out.println(sum); // 5050

        sum = sumRecursive(1000);

        System.out.println(sum); // 500500

        sum = sumRecursive(100000); // ??

        System.out.println(sum);
    }

    private static int sumRecursive(int n) {
        if (n <= 1) {
            return n;
        }

        return n + sumRecursive(n - 1);
    }
}
