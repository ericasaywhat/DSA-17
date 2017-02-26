import java.util.Arrays;

/**
 * Created by sidd on 2/20/17.
 */
public class PeakFinding {

    public static int findPeak(int[]nums, int low, int high){
        int index = low + (high-low)/2;

        if (low > high){
            return -1;
        }
        if(index > 0 && index < nums.length-1){
            if(nums[index-1] <= nums[index]){
                if(nums[index+1] <= nums[index]){
                    return index;
                }
                return findPeak(nums, index+1, high);
            } else {
                return findPeak(nums, low, index-1);
            }

        } else if (index == 0) {
            if (nums[index + 1] <= nums[index]) {
                return index;
            }
            return findPeak(nums, index+1, high);
        } else if (index == nums.length-1){
            if (nums[index-1]<=nums[index]) {
                return index;
            }
            return findPeak(nums, low, index-1);
        }

        return -1;

    }

    public static int findOneDPeak(int[] nums){
        return findPeak(nums, 0, nums.length-1);

    }

    public static int[] findTwoDPeak(int[][] nums){
    	// TODO
        int[] answer = {-1,-1};
        return answer;
    }

}
