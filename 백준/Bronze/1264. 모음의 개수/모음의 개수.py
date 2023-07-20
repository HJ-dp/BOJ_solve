while True:
    s = input()
    if s=='#':
        break;
    else:
        temp = 0
        for i in s.lower():
            if i =='a' or i=='e' or i == 'o' or i =='u' or i =='i':
                temp += 1
                
        print(temp)