


list查询 分页封装
```java
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