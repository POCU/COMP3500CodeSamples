package academy.pocu.comp3500samples.w03.minimumdiff;

import java.util.Arrays;
import java.util.Random;

public class Program {

    public static void main(String[] args) {
        Random random = new Random(512);

        int[] nums = new int[15];

        for (int i = 0; i < nums.length; ++i) {
            nums[i] = random.nextInt(1000);
        }

        printNums(nums);

        Arrays.sort(nums);

        int minDiff = Integer.MAX_VALUE;
        int num1 = 0;
        int num2 = 0;

        for (int i = 0; i < nums.length - 1; ++i) {
            int diff = Math.abs(nums[i] - nums[i + 1]);

            if (diff < minDiff) {
                minDiff = diff;
                num1 = nums[i];
                num2 = nums[i + 1];
            }
        }

        System.out.println(String.format("minimum difference: %d", minDiff));
        System.out.println(String.format("num1: %d, num2: %d", num1, num2));
    }

    private static void printNums(int[] nums) {
        String[] s = new String[nums.length];

        for (int i = 0; i < nums.length; ++i) {
            s[i] = String.format("%d", nums[i]);
        }

        System.out.println(String.format("[ %s ]", String.join(", ", s)));
    }
}
