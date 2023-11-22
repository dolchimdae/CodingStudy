##  https://school.programmers.co.kr/learn/courses/30/lessons/67256
## 카카오 2020 인턴 키패드 누르기

import math

def solution(numbers, hand):
    '''
    양손 엄지로만 숫자 입력
    왼 - * 오 - #
    엄지손가락 사용규칙 : 상하좌우 가능,
    147- 왼, 369-오.
    2580은 더 가까운 엄지로. 
    두 엄지의 거리가 같으면 오른손잡이-오, 왼-왼.
    각 번호를 누른 엄지손가락이 왼인지 오른인지 리턴.
    
    1 2 3
    4 5 6
    7 8 9
    * 0 #
    '''
    keypad = [[1,2,3],[4,5,6],[7,8,9],[-1,0,-1]]
    d = dict()
    d[1] = [0,0]
    d[2] = [0,1]
    d[3] = [0,2]
    d[4] = [1,0]
    d[5] = [1,1]
    d[6] = [1,2]
    d[7] = [2,0]
    d[8] = [2,1]
    d[9] = [2,2]
    d[0] = [3,1]
    
    curL = [3,0]
    curR = [3,2]
    
    answer = ''
    for num in numbers:
        # 147 인 경우
        if num in [1,4,7]:
            answer += "L"
            curL = d[num]
        # 369 인 경우
        if num in [3,6,9]:
            answer += "R"
            curR = d[num]
        # 2580 인 경우
        if num in [2,5,8,0]:
            disL = abs(d[num][0]-curL[0])+abs(d[num][1]-curL[1])
            disR = abs(d[num][0]-curR[0])+abs(d[num][1]-curR[1])         
            if disL < disR :
                answer += "L"
                curL = d[num]
            ## 거리 같으면 hand로 추가
            elif disL == disR: 
                if hand == "left":
                    answer += "L"
                    curL = d[num]
                else:
                    answer += "R"
                    curR = d[num]
            else:
                answer += "R"
                curR = d[num]
                
    return answer
