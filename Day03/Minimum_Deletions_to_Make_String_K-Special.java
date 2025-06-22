class Solution {
    public int minimumDeletions(String word, int k) {
    // Frequency array to store count of each character (a-z)
    int[] freq = new int[26];
    for (char c : word.toCharArray()) {
        freq[c - 'a']++;
    }

    int minDeletions = Integer.MAX_VALUE;

    // Try every possible base frequency x
    for (int baseFreq : freq) {
        int deletions = 0;
        if(baseFreq == 0) continue;

        for (int f : freq) {
            if (f < baseFreq) {
                // If frequency is already less than base, delete all
                deletions += f;
            } else if (f > baseFreq + k) {
                // If frequency exceeds allowed range, delete excess
                deletions += f - (baseFreq + k);
            }
        }

        minDeletions = Math.min(minDeletions, deletions);
    }

    return minDeletions;
}

}