public class Leetcode103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ll = new LinkedList<>();
        if (root == null) return ll;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean oddLevel = true; //true for odd levels, false for even
        while (!queue.isEmpty()) {
            List<Integer> sublist = new LinkedList<>();
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                if (queue.peek().left != null) queue.offer(queue.peek().left);
                if (queue.peek().right != null) queue.offer(queue.peek().right);
                sublist.add(queue.poll().val);
            }
            if (!oddLevel) {
                Collections.reverse(sublist);
                oddLevel = true;
            } else {
                oddLevel = false;
            }
            ll.add(sublist);
        }
        return ll;
    }
}
