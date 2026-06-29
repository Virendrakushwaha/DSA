package DSA.SlidingWindow;

public class MinimunSubarray {
    public static int minSubArrayLen(int target, int[] nums) {
        int i=0;
        int sumSoFar = 0;
        int minCount = Integer.MAX_VALUE;

        for(int j=0;j<nums.length;j++){
            sumSoFar+=nums[j];
            //expanding
            while(sumSoFar>=target && i<=j){
                minCount = Math.min(j-i+1,minCount);
                sumSoFar=sumSoFar-nums[i];
                i++;
            }

        }

        return minCount==Integer.MAX_VALUE?0:minCount;
    }

    static void main() {
        minSubArrayLen(7,new int[]{2,3,1,2,4,3});
    }
}
