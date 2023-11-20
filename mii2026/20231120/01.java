// https://school.programmers.co.kr/learn/courses/30/lessons/67256

class Solution {
    public String solution(int[] numbers, String hand) {
        int[][] pos = {{4, 2}, {1, 1}, {1, 2}, {1, 3}, {2, 1},
                       {2, 2}, {2, 3}, {3, 1}, {3, 2}, {3, 3}};
        int[] leftHand = {4, 1};
        int[] rightHand = {4, 3};
        
        String answer = "";
        for(int num: numbers){
            if(num%3==1){
                leftHand[0] = pos[num][0];
                leftHand[1] = pos[num][1];
                answer += "L";
            }
            else if(num%3==0 && num!=0){
                rightHand[0] = pos[num][0];
                rightHand[1] = pos[num][1];
                answer += "R";
            }
            else{
                int leftDis = Math.abs(leftHand[0] - pos[num][0]) + Math.abs(leftHand[1] - pos[num][1]);
                int rightDis = Math.abs(rightHand[0] - pos[num][0]) + Math.abs(rightHand[1] - pos[num][1]);
                
                if(leftDis < rightDis || (leftDis == rightDis && hand.equals("left"))){
                    leftHand[0] = pos[num][0];
                    leftHand[1] = pos[num][1];
                    answer += "L";
                }
                else{
                    rightHand[0] = pos[num][0];
                    rightHand[1] = pos[num][1];
                    answer += "R";
                }
            }
        }      
        return answer;
    }
}
