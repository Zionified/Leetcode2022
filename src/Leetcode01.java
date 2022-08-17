/* Description: Two Sum
 * Given an array of integers nums and an integer target, return 
 * indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not 
 * use the same element twice.
 * You can return the answer in any order. 
 */
import java.util.HashMap;
import java.util.Map;

public class Leetcode01 {

    // HashMap solution:
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> complement = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (complement.containsKey(nums[i])) {
                result[0] = i;
                result[1] = complement.get(nums[i]);
            } else {
                complement.put(target - nums[i], i);
            }
        }
        return result;
    }
}
