import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode15 {
    public List<List<Integer>> threeSum(int[] nums) { 

        // sort array in ascending order
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            int left = i+1;
            int right = nums.length - 1;

            /*  skip same consecutive numbers except the first element because the 
            solution can contain same numbers; if this is the case, then skip the
            second number because it is already added as one solution*/
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            // start two pointers
            while (left < right) {
            if (nums[left] + nums[right] + nums[i] == 0) {
                result.add(Arrays.asList(nums[left], nums[right], nums[i]));
                
                /* find new solutions other than the current nums[left] */
                while (left < nums.length - 1 && nums[left] == nums[left+1]) {
                    left++;
                }

                /* current index still points at same number as nums[left] so
                 * we should increase index one more time
                 */
                left++;

                /* find new solutions other than the current nums[right] */
                while (right - 1 > 0 && nums[right] == nums[right-1]) {
                    right--;
                } 
                right--;
            } 
            
            // too big, decrease right
            else if (nums[left] + nums[right] + nums[i] > 0) {
                right--;
            } 
            
            // too small, increase left
            else {
                left++;
            }
        }  
        }
        return result;
    }
}
