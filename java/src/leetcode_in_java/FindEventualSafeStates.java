package leetcode_in_java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bopang on 8/27/18.
 */
public class FindEventualSafeStates {
    /* Notes
    1) Use boolean[] instead of HashSet to accelerate.
    2) There's no need to initialize state array every time when the starting point changes.
    3) Detecting cycles in directed graphs is different, since revisiting a node doesn't mean a loop exists.
     */

    // Return true if this node is eventually safe.
    private boolean dfs(int node, int[][] graph, byte[] state, boolean[] safe) {

        if (state[node] == 1) // Encountering one of the ancestors of current node means there is a cycle.
            return false;

        if (state[node] == 2)
            return safe[node];

        state[node] = 1;
        for (int neighbor: graph[node]) {
            if (!dfs(neighbor, graph, state, safe)) {
                state[node] = 2;
                return false;
            }
        }
        safe[node] = true;
        state[node] = 2;
        return true;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {

        int len = graph.length;
        List<Integer> ret = new ArrayList<Integer>();

        // 0: not visited 1: processing 2: processed
        byte[] state = new byte[len];
        boolean[] safe = new boolean[len];

        for (int ind = 0; ind < len; ind ++) {
            if (dfs(ind, graph, state, safe))
                ret.add(ind);
        }
        return ret;
    }
}
