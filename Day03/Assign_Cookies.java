class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g); // Greed factors
        Arrays.sort(s); // Cookie sizes

        int i = 0, j = 0; // i -> children, j -> cookies

        while(i < g.length && j < s.length){
            if(s[j] >= g[i]){ // Cookie can satisfy the child
                i++; // Move to next child
            }
            j++; // Move to next cookie either way
        }

        return i; // Number of content children
    }
}
