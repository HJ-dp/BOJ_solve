def palindrome(s):
    for i in range(len(s)):
        if s[i] != s[len(s) - i - 1]:
            return False
    return True


str = input()

if palindrome(str):
    print(1)
else:
    print(0)