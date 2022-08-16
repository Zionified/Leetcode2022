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