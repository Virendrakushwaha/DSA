package DSA.SlidingWindow;

public class MaxConsecutivesOne {
    public int longestOnes(int[] nums, int k) {
        //[1,1,1,0,0,0,1,1,1,1,0]
        // i
        //           j          //here zeroCount=3 and maxLen=5 ,so shrink start

        //[1,1,1,0,0,0,1,1,1,1,0]
        //          i
        //            j          //here zeroCount=1 and maxLen=5 ,so again expading start

        //[1,1,1,0,0,0,1,1,1,1,0]
        //         i
        //                      j          //here zeroCount=2 and maxLen=6 , here main while loop end
        int j=0,i=0,maxLen=0,zeroCount=0;
        while(j<nums.length){
            //count zero
            if(nums[j]==0)
                zeroCount++;
            //do shrinkage only when zeroCount is more than k (afford 2 time 0's only)
            while(i<=j && zeroCount>k){
                if(nums[i]==0){
                    zeroCount--;
                }
                i++;
            }
            //do expand
            maxLen = Math.max(maxLen,j-i+1);
            j++;
        }
        return maxLen;
    }
}