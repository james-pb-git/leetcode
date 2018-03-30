class ComplexNumberMultiplication(object):
    def __string_to_complex_coef__(self, str):
        m = int(str.split("+")[0])
        n = int(str.split("+")[1][:-1])
        return m, n

    def complexNumberMultiply(self, a, b):
        """
        :type a: str
        :type b: str
        :rtype: str
        """
        m, n = self.__string_to_complex_coef__(a)
        p, q = self.__string_to_complex_coef__(b)
        return str(m * p - n * q) + '+' + \
            str(m * q + n * p) + 'i'