public class Solution {
    public int solve(int[][] A) {
        int n = A.length;
        if(n==0) return 0;
        int m = A[0].length+1;
        int[][] sum = new int[n][m]; 
        for (int i = 0; i < sum.length; i++){
            for (int j = 1; j < sum[0].length; j++){
                sum[i][j] = sum[i][j - 1] + A[i][j - 1];
            }
        }
        int count = 0;
        for (int start = 0; start < m; start++){
            for (int end = start + 1; end < m; end++ ){
                
                int sumOfSubMatrix = 0;
                Map<Integer, Integer> map = new HashMap<Integer, Integer>();
                map.put(0, 1);
                for(int l = 0; l < n ; l++){
                    sumOfSubMatrix += sum[l][end] - sum[l][start];
                    if (map.containsKey(sumOfSubMatrix))
                        count += map.get(sumOfSubMatrix);
                    map.put(sumOfSubMatrix, map.getOrDefault(sumOfSubMatrix, 0) + 1);
                    
                }
            }
        }
        
        return count; 
       
    }
}
