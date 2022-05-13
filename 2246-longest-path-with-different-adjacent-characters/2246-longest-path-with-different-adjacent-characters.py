class Solution:
    def height(self, graph, node):
        self.seen.add(node)
		
		# A node with no children has height 0
        if not graph[node]:
            return 0
			
		# A null node has height -1 (a convention and for ease of calculation)
        max1, max2 = -1, -1
        for nei in graph[node]:
            height_nei = self.height(graph, nei)
            if height_nei > max1:
                max2 = max1
                max1 = height_nei
            elif height_nei > max2:
                max2 = height_nei
				
		# diameter = heights of tallest children + two edges connecting to parent
        self.diam = max(self.diam, 2+max1+max2)
        return 1 + max1
        
    def longestPath(self, parent: List[int], s: str) -> int:
        self.diam = 0
		
		# To keep track of unvisited trees
        self.seen = set()
		
		# Only store valid edges
        graph = [[] for i in range(len(parent))]
        for node, par in enumerate(parent):
            if par == -1: continue
            if s[par] != s[node]:
                graph[par].append(node)
        
        for i in range(len(parent)):
            if i not in self.seen:
                self.height(graph, i)
				
		# +1 since number of nodes is required, not the length
        return self.diam+1