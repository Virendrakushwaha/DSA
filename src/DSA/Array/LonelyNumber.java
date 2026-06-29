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
                if(i==0 && checkLonely(nums[i],map))
                    res.add(nums[i]);
                else if(i==nums.length-1 && checkLonely(nums[i],map))
                    res.add(nums[i]);

                else if ((i!=0 && i!=nums.length-1) && checkLonely(nums[i], map))
                    res.add(nums[i]);

            }
        }
        return res;
    }
    static boolean checkLonely(int x, HashMap<Integer,Integer> map){
        if(map.containsKey(x-1) || map.containsKey(x+1))
            return false;

        return true;
    }

    static void main() {
        System.out.println(findLonely(new int[]{62,35,59,55,84,61,38,87,55,82}));
    }
}
