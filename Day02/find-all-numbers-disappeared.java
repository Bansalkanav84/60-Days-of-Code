//First approach using set and linked list takes O(n) time and O(n) space => optimize to O(1) space
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> al = new ArrayList<>();
        int idx=0;

        for(int i : nums){

            if(i > 0){
                idx = i-1;
            }
            else{
                idx = (i*-1)-1;
            }

            if(nums[idx] > 0){
                nums[idx] *= -1;
            }
        }

        for(int i=0; i<nums.length; i++){
            if(nums[i] > 0){
                al.add(i+1);
            }
        }
        return al;
    }
}

// Second approach , a very interesting technique
import java.util.*;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // Step 1: Mark visited indices as negative
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1; // get correct index, -1 bcz indexes are 0 based but nums are from 1 to n
            if (nums[index] > 0) {
                nums[index] = -nums[index];     // mark as visited
            }
        }

        // Step 2: Collect indices with positive values (unvisited)
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1); // missing number
            }
        }

        return result;
    }
}