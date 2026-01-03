class Solution {
    public int numOfWays(int n) {
        final int MOD = 1_000_000_007;
        
        // For the first row:
        long fABA = 6; // patterns like a-b-a
        long fABC = 6; // patterns like a-b-c
        
        for (int i = 1; i < n; ++i) {
            long newABA = (fABA * 3 + fABC * 2) % MOD;
            long newABC = (fABA * 2 + fABC * 2) % MOD;
            
            fABA = newABA;
            fABC = newABC;
        }
        
        return (int)((fABA + fABC) % MOD);
    }
}