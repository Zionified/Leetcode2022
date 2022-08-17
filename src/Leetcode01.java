/* Description: Two Sum
 * Given an array of integers nums and an integer target, return 
 * indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not 
 * use the same element twice.
 * You can return the answer in any order. 
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Leetcode01 {

    // HashMap solution: 4ms 43mb
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

    // ArrayList solution: 360ms 45.8mb
    public int[] twoSum_ArrayList(int[] nums, int target) {
        ArrayList<Integer> complement = new ArrayList<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (complement.contains(nums[i])) {
                result[0] = i;

                /** add() ensures that the index of nums[i] is the index of its 
                    complement in the original array */
                result[1] = complement.indexOf(nums[i]);
            } else {

                // add by default will append elements at the end
                complement.add(target - nums[i]);
            }
        }
        return result;
    }

}
