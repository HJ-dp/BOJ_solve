import math
n,m,d = map(int,input().split())

day = (d-n)/(n-m)+1

print(math.ceil(day))