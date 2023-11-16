


## 表数据导入与导出

导出表结构

```sh
mysqldump -uroot -pYING123ZZ my_ry_vue > my_ry_vue_102_1315.sql
mysqldump -uroot -p zblog > zblog_102_1315.sql
mysqldump -uroot -p mydoc > mydoc_1315.sql
```

-- 表结构导出
mysqldump -h localhost -d ry_django_admin -uroot -pYING123ZZ >　ry_django_admin_105_table_struct.sql


导入表结构
```shell

102_1315.sql
mysql -uroot -pYING123ZZ --default-character-set=utf8mb4 zblog < zblog_102_1315.sql
mysql -uroot -pYING123ZZ --default-character-set=utf8mb4 mydoc < mydoc_102_1315.sql

mysql -umylady -p --default-character-set=utf8mb4 my_ry_vue < my_ry_vue_925_910_2023.sql
```