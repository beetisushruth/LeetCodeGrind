class Solution {
    class Node {
        String val;
        Set<Node> nodes;
        int cost;
        
        public Node(String val) {
            this.val = val;
        }
        
        public void add(Node n) {
            if(nodes == null) {
                nodes = new HashSet<>();
            }
            nodes.add(n);
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        Map<String, Node> map = new HashMap<>();
        for(int i=0; i<wordList.size(); i++) {
            String word = wordList.get(i);
            Node n1 = getNode(map, word);
            for(int j=i + 1; j<wordList.size(); j++) {
                if(isWordDiff(word, wordList.get(j))) {
                    Node n2 = getNode(map, wordList.get(j));
                    n1.add(n2);
                    n2.add(n1);
                }
            }
        }
        return  bfs(beginWord, endWord, map);
    }
    
    
    
    public int bfs(String begin, String end, Map<String, Node> map) {
        System.out.println(isWordDiff("lest", "leet"));
        Queue<Node> q = new LinkedList<>();
        Set<Node> set = new HashSet<>();
        if(!map.containsKey(begin)) return 0;
        Node s = map.get(begin);
        s.cost = 1;
        q.add(s);
        set.add(s);
        while(!q.isEmpty()) {
            Node curr = q.poll();
            if(curr.val.equals(end)) {
                return curr.cost ;
            }
            if(curr.nodes != null) {
                for(Node next : curr.nodes) {
                    if(!set.contains(next)) {
                        next.cost = curr.cost + 1;
                        q.add(next);
                        set.add(next);
                    }
                } 
            }
        }
        return 0;
    }
    
    public Node getNode(Map<String, Node> map, String word) {
        if(!map.containsKey(word)) {
            Node n = new Node(word);
            map.put(word, n);
        }
        return map.get(word);
    }
    
    public boolean isWordDiff(String s1, String s2) {
        boolean fault = false;
        for(int i=0; i<s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                if(!fault) fault = true;
                else return false;
            }
        }
        return fault;
    }
}