import java.util.*;

class RelativeDistance {
    
    /**
     * Adjacency list representing the family network. 
     * Using Set for neighbors to ensure O(1) lookup and idempotency during construction.
     */
    private final Map<String, Set<String>> adjList;

    /**
     * Constructs the family graph from a parent-to-children mapping.
     * * @param familyTree A map where the key is the parent and the value is a list of children.
     */
    RelativeDistance(Map<String, List<String>> familyTree) {
        Map<String, Set<String>> graph = new HashMap<>();
        
        familyTree.forEach((parent, children) -> {
            if (parent == null || children == null) return;

            for (int i = 0; i < children.size(); i++) {
                String childA = children.get(i);
                if (childA == null) continue;

                // Establish Bi-directional Parent-Child relationship
                addEdge(graph, parent, childA);

                // Direct Sibling Linkage
                // Per requirements, siblings must have a degree of separation of 1.
                // We create a complete subgraph (clique) for all children of this parent.
                for (int j = i + 1; j < children.size(); j++) {
                    String childB = children.get(j);
                    if (childB != null) {
                        addEdge(graph, childA, childB);
                    }
                }
            }
        });

        // Ensure the internal state is effectively immutable after construction.
        this.adjList = Collections.unmodifiableMap(graph);
    }

    /**
     * Finds the shortest path between two individuals.
     * * @param personA Starting node name.
     * @param personB Target node name.
     * @return The minimum degree of separation, or -1 if no path exists.
     */
    public int degreeOfSeparation(String personA, String personB) {
        // Fast-fail validation
        if (personA == null || personB == null) return -1;
        if (personA.equals(personB)) return 0;
        if (!adjList.containsKey(personA) || !adjList.containsKey(personB)) return -1;

        // Dual-frontier search to minimize the search space (Bidirectional BFS)
        Map<String, Integer> distA = new HashMap<>(Map.of(personA, 0));
        Map<String, Integer> distB = new HashMap<>(Map.of(personB, 0));
        Queue<String> queueA = new LinkedList<>(List.of(personA));
        Queue<String> queueB = new LinkedList<>(List.of(personB));

        while (!queueA.isEmpty() && !queueB.isEmpty()) {
            // as close to the theoretical minimum as possible.
            int result = (queueA.size() <= queueB.size()) 
                ? expandFrontier(queueA, distA, distB) 
                : expandFrontier(queueB, distB, distA);

            if (result != -1) return result;
        }

        return -1;
    }

    /**
     * Performs a single-level expansion for one side of the bidirectional search.
     */
    private int expandFrontier(Queue<String> queue, Map<String, Integer> sourceDist, Map<String, Integer> targetDist) {
        int nodesInLevel = queue.size();
        
        for (int i = 0; i < nodesInLevel; i++) {
            String current = queue.poll();
            int d = sourceDist.get(current);

            for (String neighbor : adjList.getOrDefault(current, Collections.emptySet())) {
                // If the neighbor is already in the opposing frontier, the shortest path is found.
                if (targetDist.containsKey(neighbor)) {
                    return d + 1 + targetDist.get(neighbor);
                }
                
                // standard BFS visit logic
                if (!sourceDist.containsKey(neighbor)) {
                    sourceDist.put(neighbor, d + 1);
                    queue.add(neighbor);
                }
            }
        }
        return -1;
    }

    private void addEdge(Map<String, Set<String>> graph, String u, String v) {
        graph.computeIfAbsent(u, k -> new HashSet<>()).add(v);
        graph.computeIfAbsent(v, k -> new HashSet<>()).add(u);
    }
}