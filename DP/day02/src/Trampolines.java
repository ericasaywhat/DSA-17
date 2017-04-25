public class Trampolines {
    public static int trampoline(int[] nums) {
        int[] memo = new int [nums.length];
        for (int i = 0; i <nums.length; i++) {
            memo[i] =-1;
        }
        memo[nums.length-1] = 0;


        for (int i = nums.length-2; i >= 0 ; i--) {
            trampolineHelper(nums, memo, i);
        }

        return memo[0];
    }


    private static int trampolineHelper(int[] nums, int[] memo, int i){
        if(memo[i] != -1) return memo[i];

        int currentMin = nums.length;
        int nextTramp = i + nums[i];
        if (nextTramp >= nums.length){
            memo[i] = 1;
            return memo[i];
        }

        for (int j = i+1; j <=nextTramp; j++) {
            int cost = memo[j];
            if(cost<currentMin){
                currentMin = cost;
            }
        }
        memo[i] = currentMin+1;
        return currentMin;
    }

    public static void main(String[] args){
        int[] w = {1,3,1,1,1};
        System.out.println(trampoline(w));
    }
}