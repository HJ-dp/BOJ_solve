t = int(input())
for i in range(t) :
    n = int(input())
    print("#" * n)
    mid = "#" + "J" * (n - 2) + "#"
    for _ in range(n - 2) : print(mid)
    if n != 1 : print("#" * n)
    if i != t - 1 : print()