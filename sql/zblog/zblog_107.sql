-- auto-generated definition
create table blog_doc
(
    id              int auto_increment comment '主键' primary key,
    create_user_id  int null comment '创建用户id',
    project_id      int      default 0 null comment '所属文集id',
    parent_doc      int      default 0 null comment '父级文档',
    name            varchar(128) null comment '标题',
    editor_mode     int      default 1 null comment '编辑器模式.1md,2富文本',
    content         longtext null comment '文档内容',
    pre_content     longtext null comment '文档内容_预览_纯文本',
    sort            int      default 9999 null comment '排序',
    status          int      default 1 null comment '状态码.0表示草稿状态,1表示发布状态,2表示删除状态',
    open_children   tinyint(1) null comment '打开下级',
    show_children   tinyint(1) null comment '显示下级',
    data_row_auth   int      default 0 null comment '数据行权限,0表示公开，1表示私密,2表示指定用户可见,3表示访问码可见',
    is_watermark    tinyint(1) default 0 null comment '水印状态',
    watermark_type  int null comment '水印类型 1表示文字水印 2表示图片水印',
    watermark_value varchar(250) null comment '水印内容',
    visitor         int      default 1 null comment '浏览次数',
    is_delete       tinyint(1) default 0 null comment '逻辑删除',
    create_time     datetime default CURRENT_TIMESTAMP null comment '创建时间',
    modify_time     datetime default CURRENT_TIMESTAMP null comment '更新时间'
) comment '文档表';
-- auto-generated definition
create table blog_history
(
    id          int auto_increment comment '主键' primary key,
    blog_doc_id int not null comment '文档id',
    pre_content longtext null comment '文档历史编辑内容',
    user_id     int null comment '创建用户',
    is_delete   tinyint(1) default 0 null comment '逻辑删除',
    create_time timestamp default CURRENT_TIMESTAMP null comment '创建时间',
    update_time timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间'
) comment '文档历史记录' collate = utf8mb4_bin;

-- auto-generated definition
create table blog_project
(
    id              int auto_increment comment '主键' primary key,
    create_user_id  int not null comment '创建用户id',
    name            varchar(50) null comment '文集名称',
    intro           longtext null comment '介绍',
    icon            varchar(50) null comment '图标',
    cover_img       varchar(255) null comment '封面图',
    role            int      default 1 null comment '权限值0表示公开，1表示私密,2表示指定用户可见,3表示访问码可见',
    role_value      text null comment '权限值',
    is_watermark    tinyint(1) default 0 null comment '水印',
    watermark_type  int null comment '水印类型',
    watermark_value varchar(250) null comment '水印值',
    is_top          tinyint(1) default 0 null comment '是否置顶',
    visitor         int      default 1 null comment '浏览次数',
    sort            int      default 9999 null comment '排序',
    sort_field      varchar(32) null comment '子类排序方式(sql字段)',
    is_delete       tinyint(1) default 0 null comment '逻辑删除',
    create_time     datetime default CURRENT_TIMESTAMP null comment '创建时间',
    modify_time     datetime default CURRENT_TIMESTAMP null comment '更新时间'
) comment '文集表';


-- auto-generated definition
create table ideal_category
(
    id               int auto_increment comment '主键' primary key,
    name             varchar(128) null comment '分类名称',
    cover_image      varchar(255) null comment '封面图',
    editor_mode      int null comment '编辑器模式.1md,2富文本',
    content          longtext null comment '文档内容_含html格式',
    pre_content      longtext null comment '文档内容_预览_纯文本',
    visitor          int       default 1 null comment '浏览次数',
    role             int       default 0 null comment '权限值0表示公开，1表示私密,2表示指定用户可见,3表示访问码可见',
    role_value       text null comment '权限值',
    sort             int       default 9999 null comment '排序',
    child_sort_field varchar(64) null comment '子类的排序字段',
    is_top           tinyint(1) default 0 null comment '置顶',
    is_comment       tinyint(1) default 1 null comment '当前分类是否允许评论',
    is_delete        tinyint(1) default 0 null comment '逻辑删除',
    create_time      timestamp default CURRENT_TIMESTAMP null comment '创建时间',
    update_time      timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间'
) comment '看理想-分类';

-- auto-generated definition
create table ideal_detail_content
(
    id                    int auto_increment comment '主键' primary key,
    uuid                  varchar(128) null comment 'uuid',
    for_ideal_category_id int null comment '关联类别',
    parent_doc            int       default 0 null comment '上级文档',
    title                 varchar(255) null comment '标题',
    desc_note             varchar(255) null comment '简单描述',
    editor_mode           int null comment '编辑器模式.1md,2富文本',
    content               longtext null comment '文档内容_含html格式',
    pre_content           longtext null comment '文档内容_预览_纯文本',
    role                  int       default 0 null comment '权限值0表示公开，1表示私密,2表示指定用户可见,3表示访问码可见',
    role_value            text null comment '权限值',
    index_img_static      varchar(256) null comment '封面图',
    dtl_music             varchar(256) null comment '音频地址',
    visitor               int       default 1 null comment '浏览次数',
    allow_comment         tinyint(1) default 0 null comment '当前是否允许评论',
    is_delete             tinyint(1) default 0 null comment '删除标记',
    create_time           timestamp default CURRENT_TIMESTAMP null comment '创建时间',
    update_time           timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间'
) comment '看理想-详情';

-- auto-generated definition
create table book_book
(
    id                int auto_increment comment '主键' primary key,
    uuid              varchar(128) null comment 'UUID',
    book_name         varchar(128) null comment '书籍名称',
    book_cover        varchar(255) null comment '书籍封面图',
    b_author          varchar(64) null comment '作者',
    b_publisher       varchar(64) null comment '出版社',
    b_public_data     datetime null comment '出版时间',
    b_translate       varchar(64) null comment '翻译人',
    b_read_start_time datetime null comment '开始阅读时间',
    b_read_end_time   datetime null comment '阅读完毕时间',
    b_is_over         tinyint(1) default 0 null comment '是否读完',
    editor_mode       int null comment '编辑器模式.1md,2富文本',
    content           longtext null comment '介绍内容_含html格式',
    pre_content       longtext null comment '介绍内容_预览_纯文本',
    visitor           int       default 1 null comment '浏览次数',
    role              int       default 0 null comment '权限值0表示公开，1表示私密,2表示指定用户可见,3表示访问码可见',
    role_value        text null comment '权限值',
    sort_field        varchar(64) null comment '子类的排序字段',
    sort              int       default 9999 null comment '排序',
    is_comment        tinyint(1) default 1 null comment '当前分类是否允许评论',
    is_top            tinyint(1) default 0 null comment '置顶',
    is_delete         tinyint(1) default 0 null comment '逻辑删除',
    create_time       timestamp default CURRENT_TIMESTAMP null comment '创建时间',
    update_time       timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间'
) comment '书籍信息';

-- auto-generated definition
create table book_article
(
    id               int auto_increment comment '主键' primary key,
    uuid             varchar(128) null comment 'uuid',
    for_book_book_id int null comment '关联类别',
    parent_doc       int       default 0 null comment '上级文档',
    title            varchar(255) null comment '标题',
    desc_note        varchar(255) null comment '简单描述',
    cover_img        varchar(256) null comment '封面图',
    editor_mode      int null comment '编辑器模式.1md,2富文本',
    content          longtext null comment '文档内容_含html格式',
    pre_content      longtext null comment '文档内容_预览_纯文本',
    visitor          int       default 1 null comment '浏览次数',
    role             int       default 0 null comment '权限值0表示公开，1表示私密,2表示指定用户可见,3表示访问码可见',
    role_value       text null comment '权限值',
    allow_comment    tinyint(1) default 0 null comment '当前是否允许评论',
    is_delete        tinyint(1) default 0 null comment '删除标记',
    create_time      timestamp default CURRENT_TIMESTAMP null comment '创建时间',
    update_time      timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间'
) comment '书籍-详情列表内容';

-- auto-generated definition
create table file_attachment
(
    id          int auto_increment comment '主键' primary key,
    user_id     int null comment '用户ID',
    title       varchar(255) null comment '名称,描述',
    file_path   varchar(255) null comment '文件路径',
    file_name   varchar(255) null comment '文件名',
    file_size   varchar(100) null comment '文件大小',
    file_suffix varchar(12) null comment '文件后缀',
    md5         varchar(255) null comment 'md5校验值',
    is_delete   tinyint(1) default 0 null comment '逻辑删除',
    create_time timestamp default CURRENT_TIMESTAMP null comment '创建时间',
    update_time timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间',
    constraint md5
        unique (md5)
) comment '附件表';

-- auto-generated definition
create table file_image_group
(
    id          int auto_increment comment '主键' primary key,
    user_id     int null comment '创建用户id',
    group_name  varchar(128) null comment '图片组名',
    is_delete   tinyint(1) default 0 null comment '逻辑删除',
    create_time timestamp default CURRENT_TIMESTAMP null comment '创建时间',
    update_time timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间'
) comment '图片分组';

-- auto-generated definition
create table file_image
(
    id          int auto_increment comment '主键' primary key,
    user_id     int null comment '创建用户id',
    group_id    int null comment '图片分组',
    title       varchar(255) null comment '名称,描述',
    file_name   varchar(255) null comment '图片名称',
    file_path   varchar(255) null comment '图片路径',
    md5         varchar(255) null comment 'md5校验值',
    file_suffix varchar(12) null comment '图片后缀',
    is_delete   tinyint(1) default 0 null comment '逻辑删除',
    create_time timestamp default CURRENT_TIMESTAMP null comment '创建时间',
    update_time timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间',
    constraint md5 unique (md5)
) comment '素材图片';

