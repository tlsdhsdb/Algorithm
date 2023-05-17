class Student:
    def __init__(self,age,name,order):
        self.age = age
        self.name = name
        self.order = order

    def __repr__(self):
        return str(self.age) + " " + self.name

n = int(input())
students = []

for i in range(n):
    age,name = map(str,input().split())
    students.append(Student(int(age),name,i+1))

students.sort(key=lambda x:(x.age,x.order))

for i in range(n):
    print(students[i])


