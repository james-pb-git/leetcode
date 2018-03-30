class BaseballGame(object):
    def calPoints(self, ops):
        """
        :type ops: List[str]
        :rtype: int
        """
        point_list = []
        for ch in ops:
            if ch == 'C':
                del point_list[-1]
            elif ch == 'D':
                point_list.append(point_list[-1] * 2)
            elif ch == '+':
                point_list.append(point_list[-1] + point_list[-2])
            else:
                point_list.append(int(ch))
        return sum(point_list)