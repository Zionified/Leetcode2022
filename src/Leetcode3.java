public class Leetcode3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) return s.length();
        Map<Character, Integer> map = new HashMap<>();
        int length = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            
//             to ensure that the current character is not within the current substring we are tracking
            if (!map.containsKey(s.charAt(i)) ||
                i - map.get(s.charAt(i)) > length) {
                length++;
            } else {
                length = i - map.get(s.charAt(i));
            }
            
//             always update max because length may be modified
            max = max < length ? length : max;
            
//             add the current character to map for later duplicates checking or updating to the latest position
            map.put(s.charAt(i), i);
            // System.out.println("current max="+max+" updated length="+length+" at idx "+ i);
        }
        return max;
    }

    public int lengthOfLongestSubstring(String s) {
        int[] nextIdx = new int[128];
        int max = 0;
        for (int l = 0, r = 0; r < s.length(); r++) {
//             update left pointer to the next idx of current character: to ensure that this portion is duplicates free
//             or remain unchanged if l is not covered in the duplicate zone
            l = Math.max(l, nextIdx[s.charAt(r)]);
            max = max > (r - l + 1) ? max : (r - l + 1);
            nextIdx[s.charAt(r)] = r + 1;
        }
        return max;
    }
}
