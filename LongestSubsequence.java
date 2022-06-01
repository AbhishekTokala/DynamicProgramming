public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int longestSubsequenceLength(final int[] A) {
        int n = A.length;
        int[][][] dp = new int[n][n][2];
        for(int[][] two : dp){
            for(int[] arr : two) 
               Arrays.fill(arr,-1);
        }
        return find(A,0,-1,1,dp);
    }
    public static int find(int[] A, int ind, int prev, int opt, int[][][] dp){
       
        if(ind == A.length) return 0;

        if(dp[ind][prev+1][opt]!=-1) return dp[ind][prev+1][opt];
        int ntake = find(A,ind+1,prev,opt,dp);
        int itake = 0;
        if(prev == -1 || (A[ind] > A[prev] && opt == 1)) {
         itake = 1 + find(A,ind+1,ind,1,dp);
        }
        int dtake = 0;
        if(prev != -1 && (A[ind] < A[prev])) {
             dtake = 1 + find(A,ind+1,ind,0,dp);
        }
         return dp[ind][prev+1][opt] = Math.max(ntake,Math.max(itake,dtake));
    }
}
