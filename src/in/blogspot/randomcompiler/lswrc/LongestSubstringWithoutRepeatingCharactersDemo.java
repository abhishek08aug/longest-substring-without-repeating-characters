package in.blogspot.randomcompiler.lswrc;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharactersDemo {

    private static void longestSubstringWithoutRepeatingCharacters(String str) {
        if(str == null) {
            System.out.println("Longest substring without repeated characters is: null, length is 0");
            return;
        }
        Map<Character, Integer> charVslargestIndex = new HashMap<Character, Integer>();
        int len = str.length();
        int maxSubstringStartIndex = 0;
        int maxSubstringEndIndex = 0;
        
        int currentSubstringStartIndex = 0;
        int currentSubstringEndIndex = 0;
        
        charVslargestIndex.put(str.charAt(0), 0);
        
        for(int i=1; i<len; i++) {
            if(charVslargestIndex.get(str.charAt(i)) == null) {
                currentSubstringEndIndex = i;
            } else if(charVslargestIndex.get(str.charAt(i)) < currentSubstringStartIndex){
                currentSubstringEndIndex = i;
            } else {
                currentSubstringStartIndex = charVslargestIndex.get(str.charAt(i))+1;
                currentSubstringEndIndex = i;
            }
            if(currentSubstringEndIndex - currentSubstringStartIndex + 1 > maxSubstringEndIndex - maxSubstringStartIndex + 1) {
                maxSubstringStartIndex = currentSubstringStartIndex;
                maxSubstringEndIndex = currentSubstringEndIndex;
            }
            charVslargestIndex.put(str.charAt(i), i);
        }
        System.out.println("Longest substring without repeated characters is: " + str.substring(maxSubstringStartIndex, maxSubstringEndIndex+1) + ",length is " + (maxSubstringEndIndex - maxSubstringStartIndex + 1));
    }

    
    public static void main(String[] args) {
        longestSubstringWithoutRepeatingCharacters("AABCDEBCDF");
        longestSubstringWithoutRepeatingCharacters("ABHISHEK");
        longestSubstringWithoutRepeatingCharacters("ABHIShEK");
        longestSubstringWithoutRepeatingCharacters("ABDEFGABEF");
        longestSubstringWithoutRepeatingCharacters("GEEKSFORGEEKS");
    }
}
