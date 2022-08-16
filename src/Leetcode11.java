/* Description:
 * Find two lines that together with the x-axis form a container, such that the 
 * container contains the most water.
 * Return the maximum amount of water a container can store.
 */ 
public class Leetcode11 {
    public int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        int lo = 0, hi = height.length - 1;
        while (lo < hi) {
            int area = (hi - lo) * Math.min(height[lo], height[hi]);
            max = area > max ? area : max;
            if (height[lo] < height[hi]) {
                lo++;
            } else {
                hi--;
            }
        }
        return max;
    }

}