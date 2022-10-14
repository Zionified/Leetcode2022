public class Leetcode41 {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> tree = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) continue;
            tree.add(nums[i]);
        }
        int counter = 0;
        int size = tree.size();
        while (counter < nums.length) {
            if (!tree.contains(counter+1)) {
                return counter+1;
            }
            counter++;
        }
        return size+1;
    }
}
