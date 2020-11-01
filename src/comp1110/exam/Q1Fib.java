package comp1110.exam;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * COMP1110 Final Exam, Question 1ii
 */
public class Q1Fib {
    /**
     * This function takes a positive integer, n, and returns the corresponding Fibonacci
     * number, fib(N), where
     *    fib(0) = 0,
     *    fib(1) = 1, and
     *    fib(N) = fib(N-1) + fib(N-2) for all N > 1.
     *
     * for example:
     *   if n = 1 the result will be 1, and
     *   if n = 3 the result will be 2 because 2 = 1 + 1, and
     *   if n = 5 the result will be 5 because 5 = 3 + 2
     */
    public static int fib(int n) {
        Map<Integer, Integer> visited = new HashMap<>();
        return getResult(n, visited);
    }

    private static int getResult(int n, Map visited) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        if (visited.containsKey(n)) {
            return (int) visited.get(n);
        }
        int value = getResult(n - 1, visited) + getResult(n - 2, visited);
        visited.put(n, value);
        return value;
    }

    public static int fib_2(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        return fib_2(n - 1) + fib_2(n - 2);
    }


    public static void main(String[] args) {
        long startTime = System.nanoTime(); //获取开始时间

        fib(50);

        long endTime = System.nanoTime(); //获取结束时间

        System.out.println("程序1运行时间：" + (endTime - startTime) + "ns"); //输出程序运行时间

        startTime = System.nanoTime(); //获取开始时间

        fib_2(50);

        endTime = System.nanoTime(); //获取结束时间

        System.out.println("程序1运行时间：" + (endTime - startTime) + "ns"); //输出程序运行时间
    }
}
