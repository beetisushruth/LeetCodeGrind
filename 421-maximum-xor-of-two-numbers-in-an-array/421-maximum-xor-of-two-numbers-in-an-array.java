class Solution {
//     public int findMaximumXOR(int[] nums) {
//         int maxNum = nums[0];
//         for(int num : nums) maxNum = Math.max(maxNum, num);
//         int l = (Integer.toBinaryString(maxNum)).length();
        
//         int maxXor = 0, currXor;
//         Set<Integer> prefixes = new HashSet<>();
//         for(int i=l-1; i>=0; i--) {
//             maxXor =  maxXor << 1;
//             currXor = maxXor | 1;
//             prefixes.clear();
//             for(int num : nums) prefixes.add(num >> i);
//             for(int p : prefixes) {
//                 if(prefixes.contains(currXor^p)) {
//                     maxXor = currXor;
//                     break;
//                 }
//             }
//         }
//         return maxXor;
//     }
    public static class Node {
        Node left, right;
    }
    
    public static class Trie {
        int bitsLength = 0;
        Node root = null;
        public Trie(int bitsLength) {
            this.bitsLength = bitsLength;
            root = new Node(); 
        }
        
        public void insert(int num) {
            Node curr = root;
            for(int i=bitsLength - 1; i>=0; i--) {
                int bit  = (num & (1 << i)) != 0 ? 1 : 0;
                if(bit == 0) {
                    if(curr.left == null) curr.left = new Node();
                    curr = curr.left;
                } else {
                    if(curr.right == null) curr.right = new Node();
                    curr = curr.right;
                 }
            }
        }
        
        public int findNum(int num) {
            int max = 0;
            Node curr = root;
            for(int i=bitsLength - 1; i>=0; i--) {
                max <<= 1;
                int bit  = (num & (1 << i)) != 0 ? 1 : 0;
                if((bit == 1 && curr.right != null) || (bit == 0 && curr.left == null)) {
                    max |= 1;
                    curr = curr.right;
                } else {
                    curr = curr.left;
                }
            }
            return max;
        }
    }
    
    public int findMaximumXOR(int[] nums) {
        int maxNum = nums[0];
        for(int num : nums) maxNum = Math.max(maxNum, num);
        int l = (Integer.toBinaryString(maxNum)).length();
        
        int maxXor = 0;
        Trie trie = new Trie(l);
        for(int num : nums) {
            trie.insert(num);
        }
        for(int num : nums) {
            int find = Integer.MAX_VALUE ^ num;
            int found = trie.findNum(find);
            maxXor = Math.max(maxXor, found^num);
        }
        return maxXor;
    }
}