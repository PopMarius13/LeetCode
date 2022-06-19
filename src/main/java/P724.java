import java.util.Arrays;

public class P724 {

    public static void main(String[] args) {
        P724.Solution s = new P724.Solution();
        int[] n = new int[]{-1,-1,-1,-1,-1,0};
        int res = s.pivotIndex(n);
        System.out.println(res);
    }


    static class Solution {
        public int pivotIndex(int[] nums) {
            int sumR = 0;
            int pivot = 0, sumL = 0;
            for(int i = 1; i < nums.length; i++){
                sumR += nums[i];
            }
            while(sumR != sumL) {
                if(pivot + 1 >= nums.length ) {
                    return -1;
                }
                sumL += nums[pivot];
                sumR -= nums[++pivot];
            }
            return pivot;
        }
    }

}
