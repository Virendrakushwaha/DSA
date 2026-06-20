package DSA.TwoPointers;

import java.util.*;

public class ThreeSum {

//    Input: nums = [-1,0,1,2,-1,-4,2,2]
//    Output: [[-1,-1,2],[-1,0,1]]

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> results  = new ArrayList<>();

        int total=0;
        Arrays.sort(nums);       //[-4,-1,-1,0,1,2,2,2]
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1])              //[-4,-4,-4,-1,-1,0,1,2,2,2] here i=0 to 2 same -4 .so remove duplicacy by moving till i=2
                continue;
            int left = i+1 ,right=nums.length-1;
            while(left<right){
                total = nums[i]+nums[left]+nums[right];

                if(total==0){
                    results.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while(left<right && nums[left]==nums[left+1])            //[-4,-1,-1,0,1,2,2,2] here i=0,left=1 . so nums[left]=-1 and left ke next bhi -1  so to remove such duplicacy , move left till last similar value
                        left++;
                    while(left<right && nums[right]==nums[right-1])   //[-4,-1,-1,0,1,2,2,2] here i=0,left=1 . so nums[right]=2 and right ke before bhi 2  so to remove such duplicacy , move right till last similar value
                        right--;
                    left++;                                   //once duplicacy remove , left is at 2 and right is at 5 . but element at 2,5 already added in results array. so taking next left++ and right--
                    right--;
                }
                if(total<0)
                    left++;
                if(total>0)
                    right--;
            }

        }
        return results;
    }
}
