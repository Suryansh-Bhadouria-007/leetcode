package seanp;

import java.util.*;
import java.util.stream.Collectors;

public class MinHeightTrees {
    class Node {
        int val;
        List<Node> neighbours;

        protected Node(int val) {
            this.val = val;
            this.neighbours = new ArrayList<>();
        }
    }

    private Map<Integer, Node> nodeMap = new HashMap<>();
    private int n;

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        this.n = n;
        if (n == 1) {
            ArrayList<Integer> objects = new ArrayList<>();
            objects.add(0);
            return objects;
        }

        createGraph(n, edges);
        TreeMap<Integer, List<Node>> heightMap = new TreeMap<>();
        int minHeight = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int h = getHeight(i);
            minHeight = Math.min(h, minHeight);
            if (!heightMap.containsKey(h)) {
                heightMap.put(h, new ArrayList<>());
            }
            heightMap.get(h).add(nodeMap.get(i));
        }
        return heightMap.get(minHeight).stream().map(x -> x.val).collect(Collectors.toList());
    }

    private void createGraph(int n, int edges[][]) {
        for (int edge[] : edges) {
            int p1 = edge[0];
            int p2 = edge[1];
            if (!nodeMap.containsKey(p1)) {
                nodeMap.put(p1, new Node(p1));
            }
            if (!nodeMap.containsKey(p2)) {
                nodeMap.put(p2, new Node(p2));
            }
            nodeMap.get(p1).neighbours.add(nodeMap.get(p2));
            nodeMap.get(p2).neighbours.add(nodeMap.get(p1));
        }
    }

    private int getHeight(int x) {
        Node node = nodeMap.get(x);
        return getHeightForNode(node, -1);
    }

    private int getHeightForNode(Node node, int parent) {
        if (node == null)
            return 0;
        int height = -1;
        for (Node neighbour : node.neighbours) {
            if (neighbour.val == parent)
                continue;
            int currHeight = getHeightForNode(nodeMap.get(neighbour.val), node.val);
            height = Math.max(currHeight, height);
        }
        return height + 1;
    }

    public static void main(String[] args) {
        MinHeightTrees minHeightTrees = new MinHeightTrees();
        minHeightTrees.findMinHeightTrees(1, new int[0][0]);
    }
}
