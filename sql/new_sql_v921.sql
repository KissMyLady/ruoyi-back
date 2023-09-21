

-- 操作表
-- auto-generated definition
create table sys_oper_log
(
    oper_id        bigint auto_increment comment '日志主键' primary key,
    title          varchar(50)                            null comment '模块标题',
    business_type  int          default 0                 null comment '业务类型（0其它 1新增 2修改 3删除）',
    method         varchar(100)                           null comment '方法名称',
    request_method varchar(10)                            null comment '请求方式',
    operator_type  int          default 0                 null comment '操作类别（0其它 1后台用户 2手机端用户）',
    oper_name      varchar(50)                            null comment '操作人员',
    dept_name      varchar(50)                            null comment '部门名称',
    oper_url       varchar(255)                           null comment '请求URL',
    oper_ip        varchar(128)                           null comment '主机地址',
    oper_location  varchar(255) default ''                null comment '操作地点',
    req_agent      varchar(512)                           null comment '请求头',
    req_browser    varchar(64)                            null comment '浏览器',
    req_system     varchar(32)                            null comment '操作系统',
    oper_param     text                                   null comment '请求参数',
    json_result    text                                   null comment '返回参数',
    status         int          default 0                 null comment '操作状态（0正常 1异常）',
    error_msg      text                                   null comment '错误消息',
    oper_time      datetime                               null comment '操作时间',
    cost_time      bigint       default 0                 null comment '消耗时间',
    is_delete      tinyint(1)   default 0                 null comment '逻辑删除',
    create_time    timestamp    default CURRENT_TIMESTAMP null comment '创建时间',
    update_time    timestamp    default CURRENT_TIMESTAMP null comment '更新时间'
)
    comment '操作日志记录';

create index idx_sys_oper_log_bt
    on sys_oper_log (business_type);

create index idx_sys_oper_log_ot
    on sys_oper_log (oper_time);

create index idx_sys_oper_log_s
    on sys_oper_log (status);

