public class PeakFinding {

    // Return -1 if left is higher, 1 if right is higher, 0 if peak
    private static int peak(int i, int[] nums) {
        if (i>0 && nums[i] < nums[i-1])
            return -1;
        if (i<nums.length-1 && nums[i] < nums[i+1])
            return 1;
        return 0;
    }

    // Return -1 if left is higher, 1 if right is higher, 0 if peak
    private static int peakX(int x, int y, int[][] nums) {
        if (x>0 && nums[y][x] < nums[y][x-1])
            return -1;
        if (x<nums[0].length-1 && nums[y][x] < nums[y][x+1])
            return 1;
        return 0;
    }

    // Return -1 if up is higher, 1 if down is higher, 0 if peak
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
        int lo = 0;
        int hi = nums.length;
        while (lo < hi) {
            int mid = (hi+lo)/2;
            int direction = peak(mid, nums);
            if (direction == 0) return mid;
            else if (direction == -1) hi = mid;
            else if (direction == 1) lo = mid+1;
        }
        return -1;
    }

    public static int[] findTwoDPeak(int[][] nums) {
        int lowX = 0;
        int highX= nums[0].length;
        int lowY = 0;
        int highY = nums.length;

        int indexX = (highX+lowX)/2;
        int indexY = (highY+lowY)/2;

        while(lowX< highX-1 && lowY< highY-1){
            indexX = (highX+lowX)/2;
            indexY = (highY+lowY)/2;

            if (maxXIndex(indexY, lowX, highX, nums) == indexX && maxYIndex(indexX, lowY, highY, nums) == indexY)
                return new int[] {indexX, indexY};
            if (peakY(indexX, indexY, nums) == 0 && peakX(indexX, indexY, nums) == 0)  return new int[] {indexY, indexX}; //lolol omg ;A;
            else if (peakY(indexX, indexY, nums) == 1) {
                lowY = indexY;
                if (peakX(indexX, indexY, nums) == 1) lowX = indexX;
                else if (peakX(indexX, indexY, nums) == -1) highX = indexX;
            } else if (peakY(indexX, indexY, nums) == -1) {
                highY = indexY;
                if (peakX(indexX, indexY, nums) == 1) lowX = indexX;
                else if (peakX(indexX, indexY, nums) == -1) highX = indexX;
            } else {
                if (peakX(indexX, indexY, nums) == 1) lowX = indexX;
                else if (peakX(indexX, indexY, nums) == -1) highX = indexX;
            }
        }

        return new int[] {0,0};
    }

}
