class SelfDividingNumbers(object):
    def selfDividingNumbers(self, left, right):
        """
        :type left: int
        :type right: int
        :rtype: List[int]
        """
        res = []
        for num in range(left, right+1):
            str_num = str(num)
            if '0' in str_num:
                continue
            correct = True
            for digit in range(2,10):
                if str(digit) in str_num and num % digit != 0:
                    correct = False
                    break
            if correct:
                res.append(num)
        return res