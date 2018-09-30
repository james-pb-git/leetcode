package pers.leetcode.solutions;

/**
 * Created by bopang on 18/4/2.
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicatesSol1(int[] nums) {
        if (null == nums || nums.length == 0)
            return 0;
        int outputIdx = -1;
        int inputIdx = 0;
        while(inputIdx < nums.length) {
            if(inputIdx == 0 || nums[inputIdx] != nums[inputIdx - 1]) {
                outputIdx ++;
                nums[outputIdx] = nums[inputIdx];
            }
            inputIdx ++;
        }
        return outputIdx+1;
    }

    // Since the first element will always stay, just scan from the second.
    // It also turns out "nums[++out] = nums[in]" is faster than "out++; nums[out] = nums[in]".
    public int removeDuplicatesSol2(int[] nums) {
        if (null == nums || nums.length == 0)
            return 0;
        int outputIdx = 0;
        int inputIdx = 1;
        while(inputIdx < nums.length) {
            if(nums[inputIdx] != nums[inputIdx - 1]) {
                nums[++outputIdx] = nums[inputIdx];
            }
            inputIdx ++;
        }
        return outputIdx+1;
    }
}
