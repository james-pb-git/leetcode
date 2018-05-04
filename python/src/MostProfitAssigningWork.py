class MostProfitAssigningWork(object):
    # Takes too much space and time as well!!
    def maxProfitAssignmentSol1(self, difficulty, profit, worker):
        """
        :type difficulty: List[int]
        :type profit: List[int]
        :type worker: List[int]
        :rtype: int
        """
        MAX_VAL = 100000
        arr_max_profit = [0] * MAX_VAL
        for idx, diff in enumerate(difficulty):
            arr_max_profit[diff - 1] = max(profit[idx], arr_max_profit[diff - 1])
        for idx in range(1, len(arr_max_profit)):
            arr_max_profit[idx] = max(arr_max_profit[idx - 1], arr_max_profit[idx])
        res = 0
        for wk in worker:
            res += arr_max_profit[wk - 1]
        return res

    # Saves space by not creating large recording array, and it gets faster.
    def maxProfitAssignment(self, difficulty, profit, worker):
        """
        :type difficulty: List[int]
        :type profit: List[int]
        :type worker: List[int]
        :rtype: int
        """
        tasks = []
        for idx in range(len(difficulty)):
            tasks.append([difficulty[idx], profit[idx]])
        sorted_tasks = sorted(tasks, key = lambda task: task[0])
        sorted_worker = sorted(worker)

        res = 0
        cur_idx = 0
        cur_max_profit = 0
        for wk in sorted_worker:
            while cur_idx < len(sorted_tasks) and sorted_tasks[cur_idx][0] <= wk:
                if sorted_tasks[cur_idx][1] > cur_max_profit:
                    cur_max_profit = sorted_tasks[cur_idx][1]
                cur_idx += 1
            res += cur_max_profit
        return res