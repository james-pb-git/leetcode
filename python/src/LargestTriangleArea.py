class LargestTriangleArea(object):
    def __triangle_area__(self, p1, p2, p3):
        return abs(0.5 * (p1[0] * p2[1] + p2[0] * p3[1] + p3[0] * p1[1] -
                      p1[0] * p3[1] - p2[0] * p1[1] - p3[0] * p2[1]))

    def largestTriangleArea(self, points):
        """
        :type points: List[List[int]]
        :rtype: float
        """
        max_area = -1
        for idx1 in range(0, len(points) - 2):
            for idx2 in range(idx1 + 1, len(points) - 1):
                for idx3 in range(idx2 + 1, len(points)):
                    area = self.__triangle_area__(points[idx1], points[idx2], points[idx3])
                    if area > max_area:
                        max_area = area
        return max_area