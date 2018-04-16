class AmbiguousCoordinates(object):
    def __is_valid__(self, num):
        if num[0] == '.':
            return False
        if len(num) >= 2 and num[0] == '0' and num[1] != '.':
            return False
        if '.' in num and num[-1] == '0':
            return False
        return True

    def __all_possible_strings__(self, str):
        res = []
        if self.__is_valid__(str):
            res.append(str)
        for idx in range(1, len(str)):
            if self.__is_valid__(str[:idx] + '.' + str[idx:]):
                res.append(str[:idx] + '.' + str[idx:])
        return res

    def ambiguousCoordinates(self, S):
        """
        :type S: str
        :rtype: List[str]
        """
        res = []
        digit = S[1:-1]
        for idx in range(1, len(digit)):
            valid_list1 = self.__all_possible_strings__(digit[:idx])
            valid_list2 = self.__all_possible_strings__(digit[idx:])
            for ele1 in valid_list1:
                for ele2 in valid_list2:
                    res.append("(%s, %s)" % (ele1, ele2))
        return res