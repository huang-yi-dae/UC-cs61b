package DebugExercise;

/**
 * Exercise to showcase the step over button.
 * Code adapted from https://stackoverflow.com/questions/4895173/bitwise-multiply-and-add-in-java and https://stackoverflow.com/questions/1533131/what-useful-bitwise-operator-code-tricks-should-a-developer-know-about
 */
public class DebugExercise2 {
    /** Returns the max of a and b. Do not step into this function. */
    public static int max(int a, int b) {
        int w = (b - a) >> 31;
        /* If you're stepping into this function, click the
           step out button because you're not going to learn anything. */
        int z = ~(b - a) >> 31;

        int max = b & w | a & z;
        return max;
    }


    /** Returns the sum of a and b. Do not step into this function. */
    public static int add(int a, int b) {
        int x = a, y = b;
        /* If you're stepping into this function, click the
           step out button because you're not going to learn anything. */
        int xor, and, temp;
        and = x & y;
        xor = x ^ y;

        while (and != 0) {
            and <<= 1;
            temp = xor ^ and;
            and &= xor;
            xor = temp;
        }
        return xor;
    }

    /** Returns a new array where entry i is the max of
     * a[i] and compared[i]. For example, if a = {1, -10, 3}
     * and compared = {0, 20, 5}, this function will return {1, 20, 5}.
     * */
    public static int[] arrayMax(int[] returned, int[]compared) {
        /** Judge weather the length of the two array is same**/
        if (returned.length != compared.length) {

            System.out.println("ERROR! Arrays don't match");
            return null;
        }
        /** Iterate through the two array
         * if entry in array ruturned is bigger than or equal to that in
         * array compared then we keep it ,vice vs we replace it.
         */
        for (int i = 0; i < returned.length; i += 1) {
           if (returned[i] < compared[i]){
               returned[i] = compared[i];
           }
        }
        return returned;
    }

    /** Returns the sum of all elements in input. */
    public static int arraySum(int[] input) {
        int i = 0;
        int sum = 0;
        while (i < input.length) {
            sum = sum + input[i];
            i = i + 1;
        }
        return sum;
    }

    /** Returns the sum of the element-wise max of a and b.
     *  For example if a = {2, 0, 10, 14} and b = {-5, 5, 20, 30},
     *  the result should be 57.
     * */
    public static int sumOfElementwiseMaxes(int[] a, int[] b) {
        int[] maxes = arrayMax(a, b);
        int sumofMaxes = arraySum(maxes);
        return sumofMaxes;
    }


    public static void main(String[] args) {
        int[] a = {1, 11, -1, -11};
        int[] b = {3, -3, 2, -1};

        int sumOfElementwiseMaxes = sumOfElementwiseMaxes(a, b);
        System.out.println(sumOfElementwiseMaxes);
    }
}
