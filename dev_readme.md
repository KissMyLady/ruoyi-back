

插入数据时, 设置当前用户字段
```java
SysUser user = SecurityUtils.getLoginUser().getUser();
dto.setUserId(user.getUserId());
```


list查询 分页封装
```java
//设置查询自己
//获取到用户
SysUser user = SecurityUtils.getLoginUser().getUser();
Long userId = user.getUserId();
if(userId == 1){
    dto.setUserId(null);
}else {
    //普通用户, 仅查询自己
    dto.setUserId(user.getUserId());
}
//分页
Integer page = dto.getPageNum();
if (page <= 0 || page == null) {
    page = 1;
}
Integer pageSize = dto.getPageSize();
page = (page - 1) * pageSize;
dto.setPageNum(page);

//sql排序字符串
if (ObjectUtil.isEmpty(dto.getSort())) {
dto.setSort("create_time");
}
String sort = dto.getSort();


//查询
//查询列表
List<Map<String, Object>> queryArticleList(QueryArticleListDto dto);
```

分页设置后, 使用sql查询
```sql
select * 
from  table_name

order by #{sort} desc
limit ${pageNum}, ${pageSize}
```



**获取当前用户**
```java
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.SecurityUtils;

// 获取用户信息
SysUser user = SecurityUtils.getLoginUser().getUser();


// 获取当前的用户
LoginUser loginUser = SecurityUtils.getLoginUser();
```


**Lambok注解**

@Data：作用于类上，是以下注解的集合：

```
@ToString   //覆盖默认的toString()方法，可以通过of属性限定显示某些字段，通过exclude属性排除某些字段。
@EqualsAndHashCode  //作用于类，覆盖默认的equals和hashCode
@Getter 
@Setter 
@RequiredArgsConstructor
```

@NonNull：主要作用于成员变量和参数中，标识不能为空，否则抛出空指针异常。
@NoArgsConstructor：生成无参构造器；
@RequiredArgsConstructor：生成包含final和@NonNull注解的成员变量的构造器；
@AllArgsConstructor：生成全参构造器
@Builder：作用于类上，将类转变为建造者模式
@Log：作用于类上，生成日志变量。针对不同的日志实现产品，有不同的注解：


magic-api 配置

```properties
# 配置参考 https://www.ssssssss.org/magic-api/pages/quick/start/
magic-api:
  #配置web页面入口
  web: /magic/web
  security: # 登录
    username: zhuying  # 用户名
    password: Zkil+-U)HwVE&k?qwJ+Aj5nUf@^{{}00  # 密码  11-89
  resource: #配置存储方式
    # 配置文件存储位置。当以classpath开头时，为只读模式
    # mac用户请改为可读写的目录
    # 如果不想存到文件中，可以参考配置将接口信息存到数据库、Redis中（或自定义）
    # location: E:/data/magic_data
    type: database # 配置存储在数据库中
    tableName: magic_api_file # 数据库中的表名
    # datasource: magic # 指定数据源（单数据源时无需配置，多数据源时默认使用主数据源，如果存在其他数据源中需要指定。）
    prefix: /magic-api # key前缀
    readonly: false  # 是否是只读模式
```