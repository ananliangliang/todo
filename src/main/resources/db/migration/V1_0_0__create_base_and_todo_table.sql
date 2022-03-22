-- base table
create table hibernate_sequence
(
    next_val bigint null
);


create table user
(
    id                      bigint auto_increment
        primary key,
    username                varchar(50)                        not null,
    password                varchar(256)                       not null,
    account_non_expired     bit      default b'1'              not null,
    account_non_locked      bit      default b'1'              not null,
    credentials_non_expired bit      default b'1'              not null,
    enabled                 bit      default b'1'              not null,
    create_time             datetime default CURRENT_TIMESTAMP not null,
    update_time             datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
    constraint user_username_uindex
        unique (username)
);


create table authority
(
    id          bigint auto_increment
        primary key,
    user_id     bigint                             not null,
    authority   varchar(32)                        not null,
    create_time datetime default CURRENT_TIMESTAMP not null,
    update_time datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
    constraint authority_user_id_authority_uindex
        unique (user_id, authority)
);


-- task table
create table task
(
    id            bigint auto_increment
        primary key,
    title         varchar(255)                       null comment '标题',
    comment       varchar(1024)                      null comment '备注',
    is_complete   bit      default b'0'              not null comment '是否完成',
    complete_time datetime                           null comment '完成时间',
    task_list_id  bigint                             null comment '所属列表id：空则表示为默认列表',
    create_time   datetime default CURRENT_TIMESTAMP not null,
    update_time   datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP
)
    comment '任务表';

create index task_is_complete_index
    on task (is_complete);


create table task_list
(
    id                 bigint auto_increment
        primary key,
    name               varchar(64)                        not null comment '名称',
    task_list_group_id bigint                             null comment '任务列表组id',
    create_time        datetime default CURRENT_TIMESTAMP not null,
    update_time        datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP
)
    comment '任务列表表';


create table task_list_group
(
    id                 bigint auto_increment
        primary key,
    name               varchar(64)                        not null comment '名称',
    create_time        datetime default CURRENT_TIMESTAMP not null,
    update_time        datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP
)
    comment '任务列表组表';

