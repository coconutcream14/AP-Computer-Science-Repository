package sorting;

import java.math.*;

public class Main {
    public static void main(String[] args)
    {
        // Task:
        // 1. Implement missing sorting algorithms.
        //    - InsertionSort.java
        //    - SelectionSort.java
        //
        //  2. Add a method to class Main to generate a random array.
        //  3. Provide random input to test suite and ensure your implementations
        //     of InsertionSort and Selection sort continue to work.
        //  4. Increase the loop count for TestSuite to get better performance results.

        int length = 0;
        int[] testInput;
        for(int i = 1; i < 9; i*=2){
            length = i * 100;
            testInput = randomArray(length);
            TestSuite.run(testInput, 1000);
        }

        // Increase the loop count to get better results once it works.
        // TestSuite.run(testInput, 10000);
    }

    public static int[] randomArray(int length)
    {
        // TODO: make this return an actual random array of the provided length.
        int[] ary = new int[length];
        for(int i = 0; i < length; i++){
            ary[i] = (int) (Math.random() * 9) + 1;
        }
        return ary;
    }

}
