import json
import pymysql

with open('data2.json', encoding='utf-8') as f:
    json_object = json.load(f)

print(json_object)
conn = pymysql.connect(
    host='localhost',
    user='root',
    password='0000',
    db='myproject',
    charset='utf8')
sql = 'insert into mybook values(%d, "%s", %d)'
json_arr = json_object['data']
cur = conn.cursor()
for item in json_arr:
    cur.execute(sql % ((int)(item['연번']) + 3000, item['서명'], (int)(item['가격'])))
conn.commit()
conn.close()
