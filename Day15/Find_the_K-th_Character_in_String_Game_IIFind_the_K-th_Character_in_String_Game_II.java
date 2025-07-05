class Solution {
    public char kthCharacter(long k, int[] operations) {
        // Base case: if we want the first character, it is always 'a'
        if(k == 1) return 'a';

        int n = operations.length;
        long len = 1;          // keeps track of the length of the string as it grows 
        long newK = -1;        // used to store the mapped position in the previous string
        int operation = -1;    // The operation at the level where k fits

        // Find the level (operation index) where k-th character lies
        for(int i = 0; i < n; i++) {
            len *= 2; // Each operation doubles the length of the string

            // If the string is long enough to contain position k
            if(len >= k) {
                operation = operations[i]; // the operation type at this level
                newK = k - len/2;          // Map k to position in the previous string
                break;                     // Stop since we've found the level where k lies
            }
        }

        // Recurse to find prev char
        char ch = kthCharacter(newK, operations);

        // apply the operation to the char
        if(operation == 0) {
            // Operation 0 means just copy, so no change
            return ch;
        }

        // Operation 1 means increment the char
        if(ch == 'z') {
            // If it's 'z', wrap around to 'a'
            return 'a';
        }

        // Otherwise increment the char by 1
        return (char)('a' + ((ch - 'a') + 1));
    }
}
