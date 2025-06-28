class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String,Integer> mp = new HashMap<>();
        List<String> al = new ArrayList<>();

        for(int i=0; i<list1.length; i++){
            mp.put(list1[i],i);
        }
        
        int sum=0;
        int res=2000;
        for(int i=0; i<list2.length; i++){
            if(mp.containsKey(list2[i])){
                sum = i + mp.get(list2[i]);
                if(sum < res){
                    res = sum;
                    al.clear();
                    al.add(list2[i]);
                }
                else if(sum == res){
                    al.add(list2[i]);
                }
            }
        }
        return al.toArray(new String[0]);
    }
}