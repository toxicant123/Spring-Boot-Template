create database template;

use template;

create table user_auth
(
    id          bigint auto_increment
        primary key,
    username    varchar(20)  not null,
    password    varchar(20)  not null,
    phone       varchar(11)  null,
    email       varchar(128) null,
    exist_flag  tinyint      not null,
    create_by   bigint       not null,
    create_time timestamp    not null,
    update_by   bigint       not null,
    update_time timestamp    not null,
    constraint idx_username_on_user_auth
        unique (username)
);

INSERT INTO template.user_auth (id, username, password, phone, email, exist_flag, create_by, create_time, update_by,
                                update_time)
VALUES (1, 'acc', '123456Aa@', null, null, 1, 1, '2024-08-09 00:50:41', 1, '2024-08-09 00:50:41');


create table user_role
(
    id          bigint auto_increment
        primary key,
    user_id     bigint      not null,
    role        varchar(32) null,
    exist_flag  tinyint     not null,
    create_by   bigint      not null,
    create_time timestamp   not null,
    update_by   bigint      not null,
    update_time timestamp   not null
);

create index idx_user_id_on_user_role
    on user_role (user_id);

INSERT INTO template.user_role (id, user_id, role, exist_flag, create_by, create_time, update_by, update_time)
VALUES (1, 1, 'admin', 1, 1, '2024-08-09 00:55:21', 1, '2024-08-09 00:55:21');
INSERT INTO template.user_role (id, user_id, role, exist_flag, create_by, create_time, update_by, update_time)
VALUES (2, 1, 'user', 1, 1, '2024-08-10 17:23:18', 1, '2024-08-10 17:23:22');

create table template
(
    id          bigint auto_increment primary key,
    template    varchar(8192) not null,
    params      varchar(1024) null,
    exist_flag  tinyint       not null,
    create_by   bigint        not null,
    create_time timestamp     not null,
    update_by   bigint        not null,
    update_time timestamp     not null
);
