//https://school.programmers.co.kr/learn/courses/30/lessons/67257

import java.util.*;

class Solution {
    public long solution(String expression) {
        String[] nums = expression.split("[-+*]");
        char[] opers = expression.replaceAll("[0-9]", "").toCharArray();
        
        long answer = 0;
        char[][] priorities = {{'+', '-', '*'}, {'+', '*', '-'}, {'-', '+', '*'}, {'-', '*', '+'}, {'*', '+', '-'}, {'*', '-', '+'}};
        for(char[] priority: priorities)
            answer = Math.max(answer, calculateMax(nums, opers, priority));
        return answer;
    }
    
    long calculateMax(String[] nums, char[] opers, char[] priority){
        ArrayList<Long> numList = new ArrayList<>();
        for(String str: nums)
            numList.add(Long.valueOf(str));
        ArrayList<Character> operList = new ArrayList<>();
        for(char c: opers)
            operList.add(c);
        
        for(char oper: priority){
            for(int i = 0; i < operList.size(); i++){
                if(oper == operList.get(i)){
                    long n1 = numList.get(i);
                    long n2 = numList.get(i+1);
                    if(oper == '+')
                        numList.add(i, n1+n2);
                    else if(oper == '-')
                        numList.add(i, n1-n2);
                    else
                        numList.add(i, n1*n2);
                    
                    numList.remove(i+1);
                    numList.remove(i+1);
                    operList.remove(i);
                    i--;
                }
            }
        }
        
        return Math.abs(numList.get(0));
    }
}
