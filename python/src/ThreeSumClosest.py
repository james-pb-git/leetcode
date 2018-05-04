class ThreeSumClosest(object):
    def threeSumClosest(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        sorted_nums = sorted(nums)
        closest_sum = 0
        min_distance = sys.maxint
        for idx in range(len(sorted_nums) - 2):
            if idx > 0 and sorted_nums[idx] == sorted_nums[idx - 1]: # Skip duplicates
                continue
            left = idx + 1
            right = len(sorted_nums) - 1
            while left < right:
                cur_sum = sorted_nums[idx] + sorted_nums[left] + sorted_nums[right]
                if cur_sum == target:
                    return target
                if abs(cur_sum - target) < min_distance:
                    min_distance = abs(cur_sum - target)
                    closest_sum = cur_sum
                if cur_sum < target:
                    left += 1
                if cur_sum > target:
                    right -= 1
        return closest_sum