class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0) return res;
        char[][] map = {{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};

        find(0,digits,res,new StringBuilder(),map);
        return res;
    }

    private static void find(int idx, String digits, List<String> res, StringBuilder sb, char[][] map){
        if(idx == digits.length()){
            res.add(new String(sb));
            return;
        }

        int num = digits.charAt(idx) - '0';
        for(int i=0; i<map[num].length; i++){
            sb.append(map[num][i]);
            find(idx+1,digits,res,sb,map);
            sb.deleteCharAt(sb.length()-1);
        }

    }
}