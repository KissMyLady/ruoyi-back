


## 表数据导入与导出

导出表结构

```sh
mysqldump ry_vue -urootb0c2ad110fbeed99 -p > ry_vue_925_910_2023.sql

mysqldump -umylady -p my_ry_vue > my_ry_vue_0925_1742.sql


mysqldump -uroot -p my_ry_vue > my_ry_vue_0925_1742.sql

```

导入表结构
```shell
mysql -uroot -p --default-character-set=utf8mb4 my_ry_vue < my_ry_vue_925_910_2023.sql

mysql -umylady -p --default-character-set=utf8mb4 my_ry_vue < my_ry_vue_925_910_2023.sql
```