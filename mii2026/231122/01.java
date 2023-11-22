// https://school.programmers.co.kr/learn/courses/30/lessons/118668

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int maxAlp = alp;
        int maxCop = cop;
        for(int i = 0; i < problems.length; i++){
            maxAlp = Math.max(maxAlp, problems[i][0]);
            maxCop = Math.max(maxCop, problems[i][1]);
        }
        
        int[][] dp = new int[maxAlp+1][maxCop+1];
        for(int i = 0; i <= maxAlp; i++){
            for(int j = 0; j <= maxCop; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[alp][cop] = 0;
        
        for(int i = alp; i <= maxAlp; i++){
            for(int j = cop; j <= maxCop; j++){
                if(i+1 <= maxAlp)
                    dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j]+1);
                if(j+1 <= maxCop)
                    dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j]+1);
                for(int k =0; k < problems.length; k++){
                     if(i>=problems[k][0] && j>= problems[k][1]){
                         int newAlp = Math.min(i+problems[k][2], maxAlp);
                         int newCop = Math.min(j+problems[k][3], maxCop);
                         dp[newAlp][newCop] = Math.min(dp[newAlp][newCop], dp[i][j]+problems[k][4]);
                     }
                }
            }
        }
        return dp[maxAlp][maxCop];
    }
}
