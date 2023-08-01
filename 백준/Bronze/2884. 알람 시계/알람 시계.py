a=input().split()
b= int(a[0])
c= int(a[1])
if c>45:
    print(b,c-45)

elif c==45:
    print(b,0)
else:
    c -=45
    if b==0:
        b = 24
    print(b-1,60+c)