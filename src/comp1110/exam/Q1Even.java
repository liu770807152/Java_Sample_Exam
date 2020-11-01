package comp1110.exam;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * COMP1110 Final Exam, Question 1i
 */
public class Q1Even {
    /**
     * This function takes a positive integer, n,  and returns an array
     * of ints containing all even integers between 1 and n, inclusive of n.
     *
     * for example:
     *    n = 5
     * the result will be
     *        {2, 4}
     */
    public static int[] even(int n) {
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 2; i <= n; i += 2) {
            nums.add(i);
        }
        int[] result = new int[nums.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = nums.get(i);
        }
        return result;
    }
}
