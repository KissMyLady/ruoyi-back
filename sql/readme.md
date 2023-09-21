


## 表数据导入与导出

导出表结构

```sh
mysqldump ry_vue -uroot -p > ry_vue.sql
```

导入表结构
```shell
mysql -uroot -p --default-character-set=utf8 ry_vue < ry_vue_2023_9_21_1705.sql
```