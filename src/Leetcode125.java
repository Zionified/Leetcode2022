public class Leetcode125 {

    // two pointers from the middle solution: 21ms 44.2mb
    public boolean isPalindrome(String s) {

        // accept if only one character
        if (s.length() == 1) {
            return true;
        }

        // remove all punctuations and empty space and switch to lowercase
        String striped_str = s.replaceAll("\\p{Punct}", "").replaceAll(" ", "").toLowerCase();
        
        // odd length starts from the left and right of the middle char
        if (striped_str.length() % 2 == 0) {
            int left = striped_str.length() / 2 - 1;
            int right = striped_str.length() / 2;
            while (left >= 0 && right < striped_str.length()) {
                if (striped_str.charAt(left) != striped_str.charAt(right)) {
                    return false;
                }
                left--;
                right++;
            }
        } 
        
        // evan length starts from the middle two chars
        else {
            int left = striped_str.length() / 2 - 1;
            int right = striped_str.length() / 2 + 1;
            while (left >= 0 && right < striped_str.length()) {
                if (striped_str.charAt(left) != striped_str.charAt(right)) {
                    return false;
                }
                left--;
                right++;
            }
        }
        return true;
    }

    // two pointers from two end + manually ignore non-alphanumeric characters
    // 6ms 43.6mb
    public boolean isPalindrome2(String s) {
        if (s.length() == 1) {
            return true;
        }

        // lowercase the string
        String lowercase = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;

        /* left should be STRICTLY less than right. Otherwise left/right maybe
         * out of bound when ignoring characters
        */
        while (left < right) {

            // ignore non-alphanumeric characters
            while (left < right && (lowercase.charAt(left) < 'a' || lowercase.charAt(left) > 'z') 
                                && (lowercase.charAt(left) < '0' || lowercase.charAt(left) > '9')) 
            {
                left++;
            }
            while (left < right && (lowercase.charAt(right) < 'a' || lowercase.charAt(right) > 'z') 
                                && (lowercase.charAt(right) < '0' || lowercase.charAt(right) > '9')) 
            {
                right--;
            }

            // check non-alphanumeric characters
            if (lowercase.charAt(left) != lowercase.charAt(right)) {
                return false;
            }

            // move pointers
            left++;
            right--;
        }
        return true;
    }

    // use builtin functions: 18ms 42.7mb
    public boolean isPalindrome3(String s) {
        if (s.length() == 1) {
            return true;
        }
        String striped_s = s.replaceAll("\\p{Punct}| ", "").replaceAll(" ", "").toLowerCase();
        int left = 0;
        int right = striped_s.length() - 1;
        while (left <= right) {
            if (striped_s.charAt(left) != striped_s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
