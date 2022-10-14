public class Leetcode42 {
    public int trap(int[] height) {
        int[] leftMaxHeight = new int[height.length];
        int[] rightMaxHeight = new int[height.length];
        
        for (int i = 0; i < height.length; i++) {
            if (i == 0) {
                leftMaxHeight[0] = height[0];
                rightMaxHeight[0] = height[height.length-1];
                continue;
            }
            leftMaxHeight[i] = height[i] > leftMaxHeight[i-1] 
                             ? height[i] : leftMaxHeight[i-1];
            rightMaxHeight[i] = height[height.length-i-1] > rightMaxHeight[i-1]
                              ? height[height.length-i-1] : rightMaxHeight[i-1];
            System.out.println("left: " + leftMaxHeight[i]);
            System.out.println("right: " + rightMaxHeight[i]);
        }
        int result = 0;
        for (int k = 0; k < height.length; k++) {
            result += Math.min(leftMaxHeight[k], rightMaxHeight[height.length-k-1]) - height[k];
        }
            return result;
    }
}
