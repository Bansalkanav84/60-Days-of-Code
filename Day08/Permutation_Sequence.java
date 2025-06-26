class Solution {
    public String getPermutation(int n, int k) {
    
    List<Integer> nums = new LinkedList();
    StringBuilder res = new StringBuilder();

    int[] f = new int[n];
    f[0] = 1;              // 0's factorial is 1

    for(int i = 1; i < n; i++){
      nums.add(i);
      f[i] = f[i - 1] * i;
    }
    nums.add(n);

    k--;   // 14th count from 1, turn to be 13th count from 0.


    for(int i = n; i > 0; i--){
      int idx = k / f[i - 1];
      k = k % f[i - 1];

      res.append(nums.get(idx));
      nums.remove(idx);
    }
    return res.toString();
  }
}