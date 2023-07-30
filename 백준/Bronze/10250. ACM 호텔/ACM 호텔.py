n = int(input())
for _ in range(n):
    answer = 0
    fnum, rnum, count = map(int,input().split())
    a = count % fnum
    if a == 0:
        a = fnum
        answer += count // fnum
    else:
        answer += (count // fnum)+1
    answer += a * 100
    print(answer)