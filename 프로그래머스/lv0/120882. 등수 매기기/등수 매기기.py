def solution(score):
    class Student:
        def __init__(self,math,eng):
            self.math = math
            self.eng = eng

    students = []
    for i in score:
        students.append(Student(i[0],i[1]))

    students.sort(key=lambda x: -x.math -x.eng)
    tower = []
    for i in range(len(students)):
        cnt = 0;
        for j in students:
            if j.math+j.eng > students[i].math +students[i].eng:
                cnt += 1

        tower.append([students[i].math,students[i].eng,cnt+1])
        
    answer = []
    for i in score:
        for j in tower:
            if i[0] == j[0] and i[1] == j[1]:
                answer.append(j[2])
                break

    return answer