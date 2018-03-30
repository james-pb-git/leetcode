class PartitionLabels(object):
    def partitionLabels(self, S):
        """
        :type S: str
        :rtype: List[int]
        """
        indices = []
        for char in string.lowercase:
            if S.find(char) != -1:
                indices.append([S.find(char), S.rfind(char)])
        res = []
        left = 0
        right = 0
        indices = sorted(indices, key=lambda pair: pair[0])
        for pair in indices:
            if pair[0] <= right:
                right = max(right, pair[1])
            else:
                res.append(right - left + 1)
                left, right = pair[0],  pair[1]
        res.append(right - left + 1)
        return res