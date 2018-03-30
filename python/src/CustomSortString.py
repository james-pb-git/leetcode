class CustumSortString(object):
    def customSortString(self, S, T):
        """
        :type S: str
        :type T: str
        :rtype: str
        """
        count_map = dict()
        res = ''
        for ch in T:
            if ch not in S:
                res += ch
            else:
                cnt = count_map.get(ch, 0)
                cnt += 1
                count_map[ch] = cnt
        for ch in S:
            res += ch * count_map.get(ch, 0)
        return res