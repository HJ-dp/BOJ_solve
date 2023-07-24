import sys

class s:
    def __init__(self):
        self.items=[]
        
    def push(self,a):
        self.items.append(a)
        
    def pop(self):
        if self.isEmpty():
            return -1
        else:
            return self.items.pop()
        
    def isEmpty(self):
        if self.items:
            return 0
        else:
            return 1
        
    def size(self):
        return len(self.items)
    
    def top(self):
        if self.isEmpty():
            return -1
        else:
            return self.items[-1]

s = s()
a = int(sys.stdin.readline())
for i in range(a):
    z = sys.stdin.readline().split()
    if z[0] == "push":
        s.push(z[1])
    elif z[0] == "pop":
        print(s.pop())
    elif z[0] == "empty":
        print(s.isEmpty())
    elif z[0] == "size":
        print(s.size())
    elif z[0] == "top":
        print(s.top())