package practice;

import java.util.*;

class Dijkstra {

    public static void main(String... args) {
        System.out.println(networkDelayTime(new int[][]{{2,1,1},{2,3,1},{3,4,1}}, 4 ,2));
    }
    public static int networkDelayTime(int[][] times, int N, int K) {
        Node[] nodes = new Node[N];
        int[] visited = new int[N];
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        int INF = 1 << 29;

        for (int i = 0; i < N; i++) {
            nodes[i] = new Node();
            visited[i] = INF;
        }

        for (int[] time : times) {
            nodes[time[0] - 1].edges.add(new Edge(time[1] - 1, time[2]));
        }

        pq.add(new Edge(K - 1, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            if (current.weight >= visited[current.to]) continue;
            visited[current.to] = current.weight;
            for (Edge edge: nodes[current.to].edges) {
                if (current.weight + edge.weight >= visited[edge.to]) continue;
                visited[edge.to] = current.weight + edge.weight;
                pq.add(new Edge(edge.to, current.weight + edge.weight));
            }
        }

        int max = 0;
        for (int i : visited) {
            max = Math.max(i, max);
        }

        return max == INF ? -1 : max;
    }

    static class Node {
        List<Edge> edges;
        public Node() {
            this.edges = new ArrayList<>();
        }

    }

    static class Edge {
        int to;
        int weight;
        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}