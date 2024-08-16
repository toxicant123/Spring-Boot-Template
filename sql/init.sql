create database template;

use template;

create table user_auth
(
    id          bigint auto_increment
        primary key,
    username    varchar(20)  null,
    password    varchar(20)  null,
    phone       varchar(11)  null,
    email       varchar(128) null,
    exist_flag  tinyint      null,
    create_by   bigint       null,
    create_time timestamp    null,
    update_by   bigint       null,
    update_time timestamp    null,
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
    user_id     bigint      null,
    role        varchar(32) null,
    exist_flag  tinyint     null,
    create_by   bigint      null,
    create_time timestamp   null,
    update_by   bigint      null,
    update_time timestamp   null
);

create index idx_user_id_on_user_role
    on user_role (user_id);

INSERT INTO template.user_role (id, user_id, role, exist_flag, create_by, create_time, update_by, update_time)
VALUES (1, 1, 'admin', 1, 1, '2024-08-09 00:55:21', 1, '2024-08-09 00:55:21');
INSERT INTO template.user_role (id, user_id, role, exist_flag, create_by, create_time, update_by, update_time)
VALUES (2, 1, 'user', 1, 1, '2024-08-10 17:23:18', 1, '2024-08-10 17:23:22');
