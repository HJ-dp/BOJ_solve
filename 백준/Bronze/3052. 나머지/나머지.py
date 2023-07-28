b = []
for _ in range(10):
    a = int(input())
    c = a%42
    if c in b:
        continue
    else:
        b.append(c)
print(len(b))