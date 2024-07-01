package LeetcodeDailyChallenge;

public class ThreeConsecutiveOdds_July1_2024 {
    public static void main(String[] args) {
        System.out.println("Hello world");
        int[] arr = {2,6,4,1};
        System.out.println(threeConsecutiveOdds(arr));
      System.out.println(threeConsecutiveOdds1(arr));
    }
    // Approach 1 : using If check. this will not work if consecutiveOdds increases
    public static boolean threeConsecutiveOdds(int[] arr) {
        int len = arr.length;
        if(len < 3) return false;
        for(int i=0;i<len-2;i++)
        {
            // If element is even, skip it
            if((arr[i] & 1) == 0) {
                continue;
            }
            // If element is odd, then check other two elements also.
            if(((arr[i+1] & 1) == 1) && ((arr[i+2] & 1) == 1))
            {
                return true;
            }

        }
        return false;
    }
    // Approach 2 : using count variable. This will work for all the problem if ConsecutiveOdds increased in the future.
    public static boolean threeConsecutiveOdds1(int[] arr) {
        int count =0;
        for (int i = 0; i < arr.length; i++) {
            if((arr[i] & 1) == 1 )
            {
                count++;
                if(count == 3) {
                    return true;
                }
            }
            else {
                count=0;
            }
        }
        return false;
    }
}
