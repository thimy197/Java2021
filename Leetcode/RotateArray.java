
public class RotateArray {

    /*
    * Rotate an array of n elements to the right by k steps.
    * For example: with n = 7 and k = 3,
    * the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
    * */
    public static void main(String[] args) {
        int n = 8 , k = 10;
        int[] test1 = new int[]{1,2,3,4,5,6,7,8};
        rotate(test1, n, k);
        for (int i = 0; i < test1.length; i++) {
            System.out.print(test1[i] + " ");
        }
    }

    public static void rotate(int[] arr, int n, int k) {
        if (k>n){
            k = k%n;
            System.out.println(k);
        }

        // k rotate
        for (int i = 0; i < k; i++) {
            // bubble lastValue to first
            for (int j = n-1; j > 0; j--) {
                int temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;
            }
        }
    }

}
