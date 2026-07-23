package DSA.Stack;

import java.util.Collections;
import java.util.Queue;
import java.util.Stack;

public class DecodeString {

    static void main() {
        decodeString("2[abc]3[cd]ef");
    }
    public static String decodeString(String s) {
        //s = "3[a]2[bc]"
        //3 [ a
        //push till alphabet, opening brances  start pop when we get closing braces
        Stack<Character> st = new Stack<>();
        String res="";
        for(int i=0;i<s.length();i++){

            // open bracket ignore [
            if('['==(s.charAt(i)))
                continue;
            if(Character.isLetter(s.charAt(i)) || Character.isDigit(s.charAt(i))){
                st.push(s.charAt(i));
                continue;
            }
            String operand = "";
            String final_operand = "";
            while(!st.isEmpty()){
                char ch = st.pop();
                if(Character.isLetter(ch))
                    operand+=ch;
                if(Character.isDigit(ch)){
                    StringBuilder str = new StringBuilder(operand);
                         str = str.reverse();
                    int digit = Character.getNumericValue(ch);
                    for(int j=0;j<digit;j++)
                        final_operand+=str;
                }
            }
            res+=final_operand;


        }
        while(!st.isEmpty()){
            res+=st.pop();
        }

        System.out.println(res);
        return res;
    }
}
