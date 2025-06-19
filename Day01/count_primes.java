/*  The intuitive approach was to do it using two for loops. one for iterating numbers less than n and other 
to check if its prime or not. its time complexity was O(n^1.5).

then came the second approach THE SIEVE OF ERATOSTHENES
*/

// Approach 1
class Solution {
    public int countPrimes(int n) {
        
        if(n<=2) return 0;

        int count = 1;
        for(int i=3; i<n; i+=2){
            if(isPrime(i)) count++;        
        }
        return count;
    }

    private boolean isPrime(int i){
        for(int j=3; j<= Math.sqrt(i); j+=2){
            if(i%j==0) return false;
        }
        return true;
    }
}

// Approach 2
class Solution {
    public int countPrimes(int n) {

        if(n<=2) return 0;

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime,true);

        isPrime[0] = false;
        isPrime[1] = false;

        for(int i=2; i<Math.sqrt(n); i++){
            if(isPrime[i] == true){
                for(int j=i*i; j<n; j+=i){
                    isPrime[j] = false;
                }
            }
        }

        int count=1;
        for(int i=3; i<n; i+=2){
            if(isPrime[i]) count++;
        }
        return count;
    }
}