package pers.leetcode.solutions;

/**
 * Created by bopang on 8/28/18.
 */
public class RedundantConnection {
    private int getIslandID(int node, int[] islands) {
        if (islands[node] == node)
            return node;
        return getIslandID(islands[node], islands);
    }

    public int[] findRedundantConnectionImproved(int[][] edges) {
        int numNodes = edges.length;
        int[] islands = new int[numNodes + 1];
        for (int ind = 0; ind <= numNodes; ind ++)
            islands[ind] = ind;

        int island1, island2;
        for (int[] edge : edges) {
            island1 = getIslandID(edge[0], islands);
            island2 = getIslandID(edge[1], islands);
            if (island1 == island2)
                return edge; // No need to create a new int[].
            islands[island2] = island1; // island2 is the root of its group. islands[edge[1]] = island1 would be incorrect.
        }
        return null;
    }

    public int[] findRedundantConnection(int[][] edges) {
        int numNodes = edges.length;
        int[] islands = new int[numNodes];
        for (int ind = 0; ind < numNodes; ind ++) {
            islands[ind] = ind;
        }
        int island1, island2;
        for (int ind = 0; ind < numNodes; ind ++) {
            island1 = islands[edges[ind][0] - 1];
            island2 = islands[edges[ind][1] - 1];
            if (island1 == island2)
                return new int[]{edges[ind][0], edges[ind][1]};
            islands[edges[ind][1] - 1] = island1;
            for (int node = 0; node < numNodes; node ++) {
                if (islands[node] == island2)
                    islands[node] = island1;
            }
        }
        return null;
    }
}
