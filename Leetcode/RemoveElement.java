
public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,2,3,0,4,2};//
        int val = 2;
        System.out.println(removeElement(nums, val));
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]); // 5, nums = [0,1,4,0,3,_,_,_]
        }
    }

    public static int removeElement(int[] nums, int val) {
        int diff = 0;
        int curr = 0;
        while (curr < nums.length) {
            if (nums[curr] == val) {
                // find the next difference index
                while(diff <= curr || (diff < nums.length && nums[diff] == val)) {
                    diff++;
                }
                if (diff < nums.length) {
                    // swap current with diff Val
                    nums[curr] = nums[diff];
                    nums[diff] = val;
                } else {
                    // no more diff Val
                    return curr;
                }
            }
            curr++;
        }
        return curr;
    }
}
