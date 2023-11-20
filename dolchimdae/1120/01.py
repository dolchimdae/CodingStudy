# https://school.programmers.co.kr/learn/courses/30/lessons/42891

def solution(food_times, k):
    n = len(food_times)
    
    if sum(food_times) <= k:
        return -1
    
    # 각 음식의 소요 시간 : (음식 번호, 소요 시간)
    food_info = [(i, t) for i, t in enumerate(food_times, 1)]
    food_info.sort(key=lambda x: x[1])
    
    pre_time = 0  # 이전 음식의 소요 시간
    for i, (food_num, time) in enumerate(food_info):
        diff = time - pre_time 
        total_time = diff * (n - i) 
        
        if total_time <= k:
            k -= total_time
            pre_time = time
        else:
            sub_list = sorted(food_info[i:], key=lambda x: x[0])
            answer = sub_list[k % (n - i)][0]
            break
    
    return answer
