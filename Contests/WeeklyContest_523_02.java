class Solution {
    public List<Integer> maxPrimes(int n, int s) {
        
        List<Integer> ans = new ArrayList<>();
        boolean[] prime = new boolean[n + 1];

        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;

        for (int i = 2; i * i <= n; i++){
            
            if (prime[i]){
                
                for (int j = i * i; j <= n; j += i){
                    prime[j] = false;    
                }
            }
        }

        for (int i = 2; i <= n; i++){
            
            if (prime[i] && i <= s){
                ans.add(i);
                s -= i;
            }
        }
        return ans;
    }
}