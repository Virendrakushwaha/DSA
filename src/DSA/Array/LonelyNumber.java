package DSA.Array;

import java.util.*;

public class LonelyNumber {
    public  static List<Integer> findLonely(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i]) && map.get(nums[i])==1){
                if(i==0 && !checkRightAdjacent(nums[i],map))
                    res.add(nums[i]);
                else if(i==nums.length-1 && !checkLeftAdjacent(nums[i],map))
                    res.add(nums[i]);

                else if ((i!=0 && i!=nums.length-1) && !checkAdjacent(nums[i], map))
                    res.add(nums[i]);

            }
        }
        return res;
    }
    static boolean checkAdjacent(int x, HashMap<Integer,Integer> map){
        if(map.containsKey(x-1) || map.containsKey(x+1))
            return true;

        return false;
    }

    static boolean checkRightAdjacent(int x, HashMap<Integer,Integer> map){
        if(map.containsKey(x+1))
            return true;

        return false;
    }

    static boolean checkLeftAdjacent(int x, HashMap<Integer,Integer> map){
        if(map.containsKey(x-1))
            return true;

        return false;
    }
}
