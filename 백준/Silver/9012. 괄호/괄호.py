n = int(input())

for _ in range(n):
    arr = [0]
    a = input()
    for i in a:
        if arr[-1] != 0 and arr[-1] == '(' and i == ')':
            arr.pop(-1)
        else:
            arr.append(i)
    
    if arr[-1] != 0:
        print("NO")
    else:
        print("YES")