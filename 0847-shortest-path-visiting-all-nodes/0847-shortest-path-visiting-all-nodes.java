class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        char[] arr = new char[n], allVisited = new char[n];
        Arrays.fill(arr, '0');
        Arrays.fill(allVisited, '1');
        String dest = new String(allVisited);
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder(new String(arr));
            sb.setCharAt(i, '1');
            Node src = new Node(i, sb.toString());
            queue.offer(src);
            visited.add(src);
        }
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node parent = queue.poll();
                int node = parent.node;
                String state = parent.state;
                if (state.equals(dest)) {
                    return steps;
                }
                for (int neighbor : graph[node]) {
                    StringBuilder sb = new StringBuilder(state);
                    sb.setCharAt(neighbor, '1');
                    Node child = new Node(neighbor, sb.toString());
                    if (!visited.contains(child)) {
                        queue.offer(child);
                        visited.add(child);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
    class Node {
        int node;
        String state;
        public Node(int node, String state) {
            this.node = node;
            this.state = state;
        }
        @Override
        public int hashCode() {
            return Objects.hash(node, state);
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Node other = (Node) obj;
            return node == other.node && state.equals(other.state);
        }
    }
}