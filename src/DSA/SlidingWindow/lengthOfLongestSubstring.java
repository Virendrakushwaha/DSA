package DSA.SlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class lengthOfLongestSubstring {
//    Example 1:
//
//    Input: s = "abcabcbb"
//    Output: 3
//    Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
//    Example 2:
//
//    Input: s = "bbbbb"
//    Output: 1
//    Explanation: The answer is "b", with the length of 1.
//    Example 3:
//
//    Input: s = "pwwkew"
//    Output: 3
//    Explanation: The answer is "wke", with the length of 3.
//    Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxLen = 0;
        int i=0;
        for(int j=0;j<s.length();j++){
            //SHRINKING WINDOW
            while(set.contains(s.charAt(j))){
                set.remove(s.charAt(i));
                i++;
            }
            //expand window
            set.add(s.charAt(j));
            maxLen = Math.max(maxLen,j-i+1);

        }
        return maxLen;
    }

}
