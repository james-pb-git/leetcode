class AllPathsFromSourceToTarget(object):
    def all_paths_source_target_recursive(self, graph, cur_path, total_path):

        if cur_path[-1] == len(graph) - 1:
            total_path.append(cur_path[:]) # Attention
            return
        for neighbor in graph[cur_path[-1]]:
            cur_path.append(neighbor)
            self.all_paths_source_target_recursive(graph, cur_path, total_path)
            cur_path.pop()

    def allPathsSourceTarget(self, graph):
        """
        :type graph: List[List[int]]
        :rtype: List[List[int]]
        """
        if len(graph) == 0:
            return []
        total_paths = []
        cur_path = [0]
        self.all_paths_source_target_recursive(graph, cur_path, total_paths)
        return total_paths
