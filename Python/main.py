a = 10
a = "aaa"

if a == "aaa":
    print("aaa입니다.")
elif a == 10:
    print('a는 10')
    print('여러 줄 작성 가능')
else:
    print("이도 저도 아님")

i = 0
a = 10
while i < a:
    print(i)
    i += 1

for item in range(1, 11, 1):
    print(item)

mydata = []
mydata.append(10)
mydata.append(20)
mydata.insert(1, 15)
for item in mydata:
    print(item)
