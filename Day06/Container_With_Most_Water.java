class Solution {
    public int maxArea(int[] height) {
        int i=0, j=height.length-1;
        int area=0, max_area=0;

        while(i<j){

            area = Math.min(height[i],height[j])*(j-i);
            max_area = Math.max(max_area,area);

            if(height[i] <= height[j]){
                i++;
            }
            else{
                j--;
            }            
        }
        return max_area;
    }
}