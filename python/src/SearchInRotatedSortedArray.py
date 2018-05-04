class SearchInRotatedSortedArray(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        if nums is None or len(nums) == 0:
            return -1
        left = 0
        right = len(nums) - 1
        while left < right:
            mid = left + ((right - left) >> 1)
            if nums[left] < nums[right]:
                if target <= nums[mid]:
                    right = mid
                else:
                    left = mid + 1
            else:
                if nums[mid] >= nums[left]:
                    if target > nums[mid] or target <= nums[right]:
                        left = mid + 1
                    else:
                        right = mid
                else:
                    if target >= nums[left] or target < nums[mid]:
                        right = mid - 1
                    else:
                        left = mid
        if left == right:
            return left if nums[left] == target else -1
        return -1