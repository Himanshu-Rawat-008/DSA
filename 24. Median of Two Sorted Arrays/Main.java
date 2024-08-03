public class Main {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int nums[] = new int[m + n];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j])
                nums[k++] = nums1[i++];
            else
                nums[k++] = nums2[j++];
        }

        while (i < m) {
            nums[k++] = nums1[i++];
        }

        while (j < n) {
            nums[k++] = nums2[j++];
        }

        int mid1 = (m + n) / 2;
        int mid2 = (m + n) - mid1 - 1;
        return (double) (nums[mid1] + nums[mid2]) / 2;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2 };
        int[] nums2 = { 3, 4 };
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
