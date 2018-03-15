package leetcode_in_java;

/**
 * Created by bopang on 18/3/15.
 */
public class MedianOfTwoSortedArrays {
    // target is a 1-based index.
    private double findKthElemRecursive(int[] nums1, int start1, int end1,
                                        int[] nums2, int start2, int end2,
                                        int target) {
        if(end1 - start1 > end2 - start2)
            return findKthElemRecursive(nums2, start2, end2, nums1, start1, end1, target);
        if (end1 < start1)
            return nums2[start2 + target - 1];
        if (target == 1)
            return Math.min(nums1[start1], nums2[start2]);

        int pos1 = Math.min(start1 + (target >> 1) - 1, end1);
        int pos2 = start2 + target - pos1 + start1 - 2;
        if (nums1[pos1] < nums2[pos2])
            return findKthElemRecursive(nums1, pos1 + 1, end1,
                    nums2, start2, pos2,
                    target - (pos1 - start1 + 1));
        //if (nums1[pos1] > nums2[pos2])
        return findKthElemRecursive(nums1, start1, pos1,
                nums2, pos2 + 1, end2,
                target - (pos2 - start2 + 1));
        //return nums1[pos1];
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (null == nums1 || null == nums2)
            return 0.0;

        if (nums1.length == 0 && nums2.length == 0)
            return 0.0;

        if (((nums1.length + nums2.length) >> 1 << 1) == (nums1.length + nums2.length)) // even
            return (findKthElemRecursive(nums1, 0, nums1.length - 1,
                    nums2, 0, nums2.length - 1,
                    ((nums1.length + nums2.length - 1) >> 1) + 1) +
                    findKthElemRecursive(nums1, 0, nums1.length - 1,
                            nums2, 0, nums2.length - 1,
                            ((nums1.length + nums2.length) >> 1) + 1)) / 2.0;
        return findKthElemRecursive(nums1, 0, nums1.length - 1,
                nums2, 0, nums2.length - 1,
                ((nums1.length + nums2.length - 1) >> 1) + 1);
    }
}
