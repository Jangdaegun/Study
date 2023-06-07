import csv
import pymysql

f = open('data.csv', 'r', encoding='utf-8')
rdr = csv.reader(f)

count = 0
mydata = []
for line in rdr:
    if count == 0:
        pass
    else:
        mydata.append(line)
    count += 1

for item in mydata:
    print(item)
f.close()

sql = 'insert into mybook values(%d, "%s", %d)'

for item in mydata:
    conn = pymysql.connect(
        host='localhost',
        user='root',
        password='0000',
        db='myproject',
        charset='utf8')
    with conn:
        with conn.cursor() as cur:
            cur.execute(
                sql % (int(item[0]), item[1],
                       (int)(item[6].strip().replace(",","")))
            )
            conn.commit()

