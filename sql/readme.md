


## 表数据导入与导出

导出表结构

```sh
mysqldump ry_vue -uroot -p > ry_vue_925_910_2023.sql

mysqldump xo_com -uroot -p> xo_com_923_2023.sql
```

导入表结构
```shell
mysql -uroot -p --default-character-set=utf8mb4 ry_vue < ry_vue_925_910_2023.sql
```