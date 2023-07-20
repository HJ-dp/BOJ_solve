arr = []
for i in range(5):
    a = int(input())
    if a < 40:
        a = 40
    arr.append(a)

print(sum(arr)//len(arr))
    