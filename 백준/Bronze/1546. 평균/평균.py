n = int(input())
re = list(map(int,input().split()))
be = max(re)

for i in range(len(re)):
    re[i] = re[i]/be*100
print(sum(re)/n)