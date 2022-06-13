class Solution {
    class E {
        int p;
        int t;
        
        public E(int p, int t) {
            this.p = p;
            this.t = t;
        }
    }
    
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        List<E>[] G = new ArrayList[n];
        for(int i=0; i<meetings.length; i++) {
            int[] meeting = meetings[i];
            int x = meeting[0];
            int y = meeting[1];
            int t = meeting[2];
            List<E> edges = (G[x] == null) ? new ArrayList<E>() : G[x];
            edges.add(new E(y, t));
            G[x] = edges;
            edges = (G[y] == null) ? new ArrayList<E>() : G[y];
            edges.add(new E(x, t));
            G[y] = edges;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int[]{0, firstPerson, 0});
        pq.add(new int[]{firstPerson, 0, 0});
        boolean[] visited = new boolean[n+1];
        Set<Integer> secret = new HashSet<>();
        secret.add(0); secret.add(firstPerson);
        while(!pq.isEmpty()) {
            int[] meeting = pq.remove();
            if(visited[meeting[1]]) continue;
            visited[meeting[1]] = true;
            secret.add(meeting[0]); secret.add(meeting[1]);
            if(G[meeting[1]] == null) continue;
            for(E next : G[meeting[1]]) {
                if(next.t >= meeting[2] && !visited[next.p]) {
                    pq.add(new int[]{meeting[1], next.p, next.t});
                }
            }
        }
        return new ArrayList<>(secret);
    }
}