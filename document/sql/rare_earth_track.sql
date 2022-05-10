DROP DATABASE IF EXISTS rare_earth_track;
CREATE DATABASE IF NOT EXISTS rare_earth_track;
USE rare_earth_track;
DROP TABLE IF EXISTS ret_resource;
CREATE TABLE IF NOT EXISTS ret_resource
(
    id          int PRIMARY KEY,
    create_time datetime COMMENT '创建时间',
    name        varchar(50) COMMENT '资源名称',
    method      varchar(10) COMMENT '请求方法',
    url         varchar(50) COMMENT '请求路径',
    description varchar(50)
) COMMENT '资源表';
INSERT INTO ret_resource(id, create_time, name, url, method, description)
VALUES (1, NOW(), '获取所有用户', '/users', 'GET', '获取所有用户');


DROP TABLE IF EXISTS ret_role;
create table IF NOT EXISTS ret_role
(
    id   int         not null primary key,
    name varchar(20) null
) comment '角色表' engine = InnoDB;
INSERT INTO ret_role(id, name)
VALUES (1, 'ROLE_ADMIN');
INSERT INTO ret_role(id, name)
VALUES (2, 'ROLE_CUSTOM');
INSERT INTO ret_role(id, name)
VALUES (3, 'ROLE_USER');

CREATE TABLE IF NOT EXISTS ret_resource_role
(
    id          int AUTO_INCREMENT PRIMARY KEY,
    resource_id int REFERENCES ret_resource (`id`),
    role_id     int REFERENCES ret_role (`id`)
) COMMENT '资源角色关系表';
INSERT INTO ret_resource_role(resource_id, role_id)
VALUES (1, 1);

-- 用户表
-- auto-generated definition
DROP TABLE IF EXISTS ret_user;
create table IF NOT EXISTS ret_user
(
    id       int auto_increment primary key,
    name     varchar(10)  not null COMMENT '姓名',
    age      int COMMENT '年龄',
    sex      varchar(2) COMMENT '性别' DEFAULT '未知',
    birthday date         null COMMENT '生日',
    address  varchar(100) null COMMENT '地址',
    password varchar(200) not null COMMENT '密码',
    status   varchar(1)              DEFAULT 1 COMMENT '状态',
    check ( `status` in (1, 0)),
    check (`sex` in ('男', '女', '未知'))
) comment '用户表' engine = InnoDB;
# 密码经BCrypt加密
# 123456
INSERT INTO ret_user(`name`, sex, age, birthday, address, password, status)
VALUES ('user1', '男', 11, now(), 'beijing', '$2a$10$qWk7KeDqgddC8eIbRf/XeOIBarzcghgLkwOVhkvaprWJjGxkQchn.', 1);
# 789012
INSERT INTO ret_user(`name`, sex, age, birthday, address, password, status)
VALUES ('user2', '男', 16, now(), 'beijing', '$2a$10$Rg9IkxecBtvfZkchm5OqxOaJggxk1u/LJ/mYh/CC/BHF/HBM9TshK', 1);
# 345678
INSERT INTO ret_user(`name`, sex, age, birthday, address, password, status)
VALUES ('user3', '男', 14, now(), 'shanghai', '$2a$10$pM5npUqjNkFWi2CAIfD7oeugYqhPBlYtHS382kHL6b4nVJXB1NGUG', 1);
# 901234
INSERT INTO ret_user(`name`, sex, age, birthday, address, password, status)
VALUES ('user4', '女', 15, now(), 'jiangxi', '$2a$10$jkpofbyAwIkV4WNRQzJHDuPUdF97p2Zrk4xXD842J.96XVWDDFMLq', 0);
# 567890
INSERT INTO ret_user(`name`, sex, age, birthday, address, password)
VALUES ('user5', '女', 14, now(), 'shandong', '$2a$10$j9BlU4Er9EIPb8DoxRQ/D.X7QiH7C3xAsWFwD.ResEwqIA342uv.K');

-- 用户角色表
-- auto-generated definition
DROP TABLE IF EXISTS ret_user_role;
create table IF NOT EXISTS ret_user_role
(
    user_id int null,
    role_id int null,
    constraint FK_AUTHORITY_AND_USER_AUTH_ID
        foreign key (role_id) references ret_role (id),
    constraint KF_USER_AND_AUTHORITY_UID
        foreign key (user_id) references ret_user (id)
) comment '用户角色表' engine = InnoDB;

INSERT INTO ret_user_role(user_id, role_id)
values (1, 1);
INSERT INTO ret_user_role(user_id, role_id)
values (2, 2);
INSERT INTO ret_user_role(user_id, role_id)
values (3, 3);
INSERT INTO ret_user_role(user_id, role_id)
values (4, 1);
INSERT INTO ret_user_role(user_id, role_id)
values (5, 2);
