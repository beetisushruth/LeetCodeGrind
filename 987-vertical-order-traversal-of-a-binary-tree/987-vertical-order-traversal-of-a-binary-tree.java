class QNode {
    TreeNode n;
    int level;
    
    public QNode(TreeNode n, int level) {
        this.n = n;
        this.level = level;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,List<Integer>> map = bfs(root);
        List<List<Integer>> ans = new ArrayList<>();
        for(int key : map.keySet()) {
            ans.add(map.get(key));
        }
        return ans;
    }
    
    public TreeMap<Integer,List<Integer>> bfs(TreeNode node) {
        TreeMap<Integer,List<Integer>> map = new TreeMap<>();
        Queue<QNode> q = new LinkedList<>();
        q.add(new QNode(node, 0));
        
        while(!q.isEmpty()) {
            QNode[] arr = new QNode[q.size()];
            for(int i=0; i<arr.length; i++) {
                QNode qn = q.remove();
                if(qn.n.left != null) q.add(new QNode(qn.n.left, qn.level - 1));
                if(qn.n.right != null) q.add(new QNode(qn.n.right, qn.level + 1));
                arr[i] = qn;
            }
            Arrays.sort(arr, (a, b) -> {
                if(a.level == b.level) return a.n.val - b.n.val;
                return a.level - b.level;
            });
            for(int i=0; i<arr.length; i++) {
                List<Integer> list = map.getOrDefault(arr[i].level, new ArrayList<>());
                list.add(arr[i].n.val);
                map.put(arr[i].level, list);
            }
        }
        return map;
    }
}