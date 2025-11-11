/** Class that prints the Collatz sequence starting from a given number.
 *  @author yihuang
 */
public class Collatz {

    /** if input n is even then return the half of n
     * if  input n is odd then return three times n puls one */
    public static int nextNumber(int n) {

        if (n % 2 ==0 ) {
            return n/2 ;
        } else if (n % 2== 1 ) {
            return 3 * n + 1;
        }
        return n;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.print(n + " ");
        while (n != 1) {
            n = nextNumber(n);
            System.out.print(n + " ");
        }
        System.out.println();
    }
}

