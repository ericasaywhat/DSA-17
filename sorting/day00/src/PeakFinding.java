
public class PeakFinding {

    public static int findPeak(int[]nums, int low, int high) {
        int index = low + (high - low) / 2;

        if (low > high) {
            return -1;
        }
        if (index > 0 && index < nums.length - 1) {
            if (nums[index - 1] <= nums[index]) {
                if (nums[index + 1] <= nums[index]) {
                    return index;
                }
                return findPeak(nums, index + 1, high);
            } else {
                return findPeak(nums, low, index - 1);
            }

        } else if (index == 0) {
            if (nums[index + 1] <= nums[index]) {
                return index;
            }
            return findPeak(nums, index + 1, high);
        } else if (index == nums.length - 1) {
            if (nums[index - 1] <= nums[index]) {
                return index;
            }
            return findPeak(nums, low, index - 1);
        }

        return -1;
    }

    // Return -1 is left is higher, 1 if right is higher, 0 if peak
    private static int peak(int i, int[] nums) {
        if (i>0 && nums[i] < nums[i-1])
            return -1;
        if (i<nums.length-1 && nums[i] < nums[i+1])
            return 1;
        return 0;
    }

    // Return -1 is left is higher, 1 if right is higher, 0 if peak
    private static int peakX(int x, int y, int[][] nums) {
        if (x>0 && nums[y][x] < nums[y][x-1])
            return -1;
        if (x<nums[0].length-1 && nums[y][x] < nums[y][x+1])
            return 1;
        return 0;
    }

    // Return -1 is up is higher, 1 if down is higher, 0 if peak
    private static int peakY(int x, int y, int[][] nums) {
        if (y>0 && nums[y][x] < nums[y-1][x])
            return -1;
        if (y<nums.length-1 && nums[y][x] < nums[y+1][x])
            return 1;
        return 0;
    }

    // These two functions return the index of the highest value along the X or Y axis, with the given
    // value for the other axis. Searches between hi (exclusive) and lo (inclusive)
    private static int maxXIndex(int y, int lo, int hi, int[][] nums) {
        int maxIndex = -1;
        for (int x = lo; x < hi; x++) {
            if (maxIndex == -1 || nums[y][x] > nums[y][maxIndex])
                maxIndex = x;
        }
        return maxIndex;
    }
    private static int maxYIndex(int x, int lo, int hi, int[][] nums) {
        int maxIndex = -1;
        for (int y = lo; y < hi; y++) {
            if (maxIndex == -1 || nums[y][x] > nums[maxIndex][x])
                maxIndex = y;
        }
        return maxIndex;
    }

    public static int findOneDPeak(int[] nums){
        return findPeak(nums, 0, nums.length-1);

    }

    public static int[] findTwoDPeak(int[][] nums){
    	// TODO: Optionally due by 2/23. Will be due on 2/27.
        int[] answer = {-1,-1};
        return answer;
    }

}
