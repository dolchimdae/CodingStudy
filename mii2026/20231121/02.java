// https://school.programmers.co.kr/learn/courses/30/lessons/67258

import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        Set<String> set = new HashSet<>();
        for(String gem: gems){
            set.add(gem);
        }
        int gemNum = set.size();
        
        int[] min = {gems.length, 1, gems.length};
        Map<String, Integer> map = new HashMap<>();
        int i = 0; 
        int j = 0;
        while(i<gems.length && j<=gems.length){
            if(map.size() < gemNum){
                if(j<gems.length){
                    if(map.containsKey(gems[j]))
                        map.put(gems[j], map.get(gems[j])+1);
                    else
                        map.put(gems[j], 1);
                }
                j++;
            }else if(map.size() == gemNum && min[0]>j-i){
                min[0] = j - i;
                min[1] = i + 1;
                min[2] = j;
            }else{
                map.put(gems[i], map.get(gems[i])-1);
                if(map.get(gems[i]) == 0)
                    map.remove(gems[i]);
                i++;
            }
        }
        return new int[] {min[1], min[2]};
    }
}
