package DSA.Prefix;

import java.util.HashMap;

public class SubarraySumK {
    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> freqMap = new HashMap<>();
        freqMap.put(0,1);
        int sum=0,count=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(freqMap.containsKey(sum-k))       //checking sum-k(jo ab dekh dekh chuke) is present in map
                count+=freqMap.get(sum-k);
                freqMap.put(sum, freqMap.getOrDefault(sum-k,0)+1);   //in case s-k is there in map(matlab pehle dekh chuke ) then uska count+1. agar nhi dekhke not in map then add in map & count+1

        }
        return count;
    }

    static void main() {
        System.out.println(subarraySum(new int[]{1,1,1},2));
    }
}
