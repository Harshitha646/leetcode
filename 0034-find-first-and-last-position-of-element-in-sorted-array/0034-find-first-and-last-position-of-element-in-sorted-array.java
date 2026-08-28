public class Solution {
    public static int[] searchRange(int[] nums, int target) {
        int first = findBound(nums, target, true);
        int last = findBound(nums, target, false);
        return new int[]{first, last};
    }

    private static int findBound(int[] nums, int target, boolean isFirst) {
        int left = 0, right = nums.length - 1;
        int bound = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                bound = mid;
                if (isFirst) {
                    // Continue searching left
                    right = mid - 1;
                } else {
                    // Continue searching right
                    left = mid + 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return bound;
    }

    public static void main(String[] args) {
        int[] nums1 = {5, 7, 7, 8, 8, 10};
        int[] nums2 = {5, 7, 7, 8, 8, 10};
        int[] nums3 = {};

        System.out.println(java.util.Arrays.toString(searchRange(nums1, 8)));  // [3, 4]
        System.out.println(java.util.Arrays.toString(searchRange(nums2, 6)));  // [-1, -1]
        System.out.println(java.util.Arrays.toString(searchRange(nums3, 0)));  // [-1, -1]
    }
}
