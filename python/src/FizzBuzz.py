class FizzBuzz(object):

    def fizzBuzz(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        res = []
        for idx in range(n):
            tmp_res = ''
            if (idx + 1) % 3 == 0:
                tmp_res += 'Fizz'
            if (idx + 1) % 5 == 0:
                tmp_res += 'Buzz'
            if ((idx + 1) % 3 != 0) and ((idx + 1) % 5 != 0):
                tmp_res = str(idx + 1)
            res.append(tmp_res)
        return res