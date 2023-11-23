## https://school.programmers.co.kr/learn/courses/30/lessons/72410
## 2021 kakao blind recruitment
def solution(new_id):
    '''
    3자 이상 15자 이하
    소문자, 숫자, -, _ , .  만
    단 . 는 끝에x, 연속x
    1. 대문자 다 소문자로
    2. 제외한 모든 문자 제거
    3. .. => .
    4. .가 처음이나 끝이면 제거
    5. 비었으면 a 대입
    6. 16자 이상이면 자름. 근데 .가 마지막이면 제거
    7. 2자 이하면 마지막 문자를 길이 3이상될때까지 반복
    '''
    new_id = new_id.lower() #1
    new = ""
    for i in range(len(new_id)): #2
        if new_id[i] in ["-","_","."] or new_id[i].isalpha() or new_id[i].isdigit():
            new += new_id[i]
    new_id = new
    while ".." in new_id:#3
        new = new_id.split("..")
        new_id = '.'.join(new)
    if new_id[0] == ".": #4
        if len(new_id) == 1:
            new_id = "a"
        else:
            new_id = new_id[1:]
    if new_id[-1] == ".":
        if len(new_id) == 1:
            new_id = "a"
        else:
            new_id = new_id[:-1]
    if len(new_id) > 15: #6
        new_id = new_id[:15]
        if new_id[-1] == ".":
            new_id = new_id[:-1]
    if len(new_id) == 1:
        new_id += new_id[0]
        new_id += new_id[0]
    if len(new_id) == 2:
        new_id += new_id[1]
    answer = new_id
    return answer
