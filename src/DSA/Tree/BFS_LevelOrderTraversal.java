package DSA.Tree;

import java.util.*;

public class BFS_LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null)
            return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            while(size>0){
                TreeNode node = queue.poll();
                temp.add(node.val);

                if(node.left!=null)
                    queue.offer(node.left);

                if(node.right!=null)
                    queue.offer(node.right);

                size--;
            }

            Collections.reverse(temp);

            ans.add(temp);
        }
        return ans;

    }
}
