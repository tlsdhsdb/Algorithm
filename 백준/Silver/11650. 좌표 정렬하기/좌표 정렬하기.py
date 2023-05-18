class Point:
    def __init__(self,x,y):
        self.x = x
        self.y = y
    def __repr__(self):
        return str(self.x) + " " + str(self.y)

n = int(input())
points = []

for _ in range(n):
    x,y = map(int,input().split())
    points.append(Point(x,y))

points.sort(key=lambda k:(k.x,k.y))

for i in range(n):
    print(points[i])

