package DSA.Prefix;

import java.util.HashMap;

public class SubarraySumK {
    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> freqMap = new HashMap<>();
        freqMap.put(0,1);
        int sum=0,count=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(freqMap.containsKey(sum-k))
                count+=freqMap.get(sum-k);
                freqMap.put(sum, freqMap.getOrDefault(sum-k,0)+1);

        }
        return count;
    }

    static void main() {
        System.out.println(subarraySum(new int[]{1,1,1},2));
    }
}
