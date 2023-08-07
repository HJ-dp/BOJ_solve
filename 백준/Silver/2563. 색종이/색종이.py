n = int(input())
arr = [[0 for _ in range(100)] for _ in range(100)]

for _ in range(n):
    a,b = map(int,input().split())
    for i in range(10):
        for j in range(10):
            arr[99-b-i][a+j] = 1
sumr = 0
for i in range(100):
    sumr += sum(arr[i])
print(sumr)