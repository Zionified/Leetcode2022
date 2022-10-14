public class Leetcode654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) return null;
        if (nums.length == 1) return new TreeNode(nums[0]);
        int max = Integer.MIN_VALUE;
        int idx = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                idx = i;
            }
        }
        // System.out.println("max="+max+" idx="+idx);
        int[] prefix = Arrays.copyOfRange(nums, 0, idx);
        // System.out.println("Prefix:");
        // for (int i = 0; i < prefix.length; i++) {
        //     System.out.println(prefix[i]);
        // }
        int[] suffix = Arrays.copyOfRange(nums, idx+1, nums.length);
        // System.out.println("Suffix:");
        // for (int i = 0; i < suffix.length; i++) {
        //     System.out.println(suffix[i]);
        // }
        TreeNode root = new TreeNode(nums[idx], constructMaximumBinaryTree(prefix), constructMaximumBinaryTree(suffix));
        return root;
    }
}
