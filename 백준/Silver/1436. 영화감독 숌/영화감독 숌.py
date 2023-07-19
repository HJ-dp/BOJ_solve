n = int(input())
arr= []
num= 666
while len(arr) < n:
    temp = str(num)
    cnt = 0
    for i in range(len(temp)-2):
        if temp[i]=='6' and temp[i+1]=='6' and temp[i+2]=='6':
            cnt+=1
            arr.append(num)
            break;
    num += 1
    
print(arr[n-1])