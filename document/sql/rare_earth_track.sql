DROP DATABASE IF EXISTS rare_earth_track;
CREATE DATABASE IF NOT EXISTS rare_earth_track;
USE rare_earth_track;

-- 资源表
DROP TABLE IF EXISTS ret_resource;
CREATE TABLE IF NOT EXISTS ret_resource
(
    `id`          bigint(20) NOT NULL,
    `create_time` datetime COMMENT '创建时间',
    `name`        varchar(50) COMMENT '资源名称',
    `method`      varchar(10) COMMENT '请求方法',
    `url`         varchar(50) COMMENT '请求路径',
    `description` varchar(50) COMMENT '描述',
    CONSTRAINT PK_RESOURCE PRIMARY KEY (`id`)
) ENGINE = Innodb
  AUTO_INCREMENT = 17
  DEFAULT CHARSET = utf8 COMMENT '资源表';
INSERT INTO ret_resource(id, create_time, name, url, method, description)
VALUES (1, NOW(), '获取所有用户', '/users', 'GET', '获取所有用户');

-- 角色表
DROP TABLE IF EXISTS `ret_role`;
CREATE TABLE `ret_role`
(
    `status`      int(1)       DEFAULT '1' COMMENT '启用状态：0->禁用；1->启用',
    `id`          bigint(20) NOT NULL AUTO_INCREMENT,
    `name`        varchar(100) DEFAULT NULL COMMENT '名称',
    `description` varchar(500) DEFAULT NULL COMMENT '描述',
    `create_time` datetime     DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 8
  DEFAULT CHARSET = utf8 COMMENT ='角色表';
INSERT INTO ret_role(id, name)
VALUES (1, 'ROLE_ADMIN');
INSERT INTO ret_role(id, name)
VALUES (2, 'ROLE_FACTORY');
INSERT INTO ret_role(id, name)
VALUES (3, 'ROLE_USER');
INSERT INTO ret_role(id, name)
VALUES (4, 'ROLE_CUSTOM');


-- 资源角色关系表
CREATE TABLE IF NOT EXISTS ret_resource_role_relation
(
    id          int AUTO_INCREMENT PRIMARY KEY,
    resource_id int REFERENCES ret_resource (`id`),
    role_id     int REFERENCES ret_role (`id`)
) COMMENT '资源角色关系表';
INSERT INTO ret_resource_role_relation(resource_id, role_id)
VALUES ('1', '1');

-- 用户表
-- auto-generated definition
DROP TABLE IF EXISTS ret_user;
create table IF NOT EXISTS ret_user
(
    `id`                     bigint(20)   NOT NULL AUTO_INCREMENT,
    `name`                   varchar(64)  NOT NULL COMMENT '姓名',
    `nickname`               varchar(64) COMMENT '昵称',
    `age`                    int COMMENT '年龄',
    `sex`                    int(1) COMMENT '性别' DEFAULT '0' COMMENT '性别: 0->未知, 1->男, 2->女',
    `phone`                  varchar(64)         DEFAULT NULL COMMENT '手机号码',
    `birthday`               date          COMMENT '生日',
    `address`                varchar(100) DEFAULT NULL COMMENT '地址',
    `password`               varchar(200) NOT NULL COMMENT '密码',
    `status`                 int(1)              DEFAULT '1' COMMENT '账号启用状态: 0->禁言， 1->启用',
    `create_time`            datetime            DEFAULT NOW() COMMENT '创建时间',
    `latest_time`            datetime            DEFAULT NOW() COMMENT '最后登录时间',
    `icon`                   varchar(500)        DEFAULT null COMMENT '头像',
    `job`                    varchar(100)        DEFAULT NULL COMMENT '职业',
    `personalized_signature` varchar(200)        DEFAULT NULL COMMENT '个性签名',
    `email`                  varchar(100)        DEFAULT NULL COMMENT '邮箱',
    PRIMARY KEY (`id`),
    CHECK (`status` in ('0', '1')),
    CHECK (`sex` in ('0', '1', '2'))
) ENGINE = InnoDB
  AUTO_INCREMENT = 10 COMMENT '用户表';
# 密码经BCrypt加密
# 123456
INSERT INTO ret_user(`id`, `name`, sex, age, birthday, address, password, status)
VALUES ('1', 'user1', '1', '11', now(), 'beijing', '$2a$10$qWk7KeDqgddC8eIbRf/XeOIBarzcghgLkwOVhkvaprWJjGxkQchn.', 1);
# 789012
INSERT INTO ret_user(`id`, `name`, sex, age, birthday, address, password, status)
VALUES ('2', 'user2', '1', '16', now(), 'beijing', '$2a$10$Rg9IkxecBtvfZkchm5OqxOaJggxk1u/LJ/mYh/CC/BHF/HBM9TshK', 1);
# 345678
INSERT INTO ret_user(`id`, `name`, sex, age, birthday, address, password, status)
VALUES ('3', 'user3', '1', '14', now(), 'shanghai', '$2a$10$pM5npUqjNkFWi2CAIfD7oeugYqhPBlYtHS382kHL6b4nVJXB1NGUG', 1);
# 901234
INSERT INTO ret_user(`id`, `name`, sex, age, birthday, address, password, status)
VALUES ('4', 'user4', '2', '15', now(), 'jiangxi', '$2a$10$jkpofbyAwIkV4WNRQzJHDuPUdF97p2Zrk4xXD842J.96XVWDDFMLq', 0);
# 567890
INSERT INTO ret_user(`id`, `name`, sex, age, birthday, address, password)
VALUES ('5', 'user5', '2', '14', now(), 'shandong', '$2a$10$j9BlU4Er9EIPb8DoxRQ/D.X7QiH7C3xAsWFwD.ResEwqIA342uv.K');
# 123456
INSERT INTO ret_user(`id`, `name`, sex, age, birthday, address, password, status)
VALUES ('6', 'user6', '1', '11', now(), 'beijing', '$2a$10$qWk7KeDqgddC8eIbRf/XeOIBarzcghgLkwOVhkvaprWJjGxkQchn.', 1);
# 789012
INSERT INTO ret_user(`id`, `name`, sex, age, birthday, address, password, status)
VALUES ('7', 'user7', '1', '16', now(), 'beijing', '$2a$10$Rg9IkxecBtvfZkchm5OqxOaJggxk1u/LJ/mYh/CC/BHF/HBM9TshK', 1);
# 345678
INSERT INTO ret_user(`id`, `name`, sex, age, birthday, address, password, status)
VALUES ('8', 'user8', '1', '14', now(), 'shanghai', '$2a$10$pM5npUqjNkFWi2CAIfD7oeugYqhPBlYtHS382kHL6b4nVJXB1NGUG', 1);
# 901234
INSERT INTO ret_user(`id`, `name`, sex, age, birthday, address, password, status)
VALUES ('9', 'user9', '2', '15', now(), 'jiangxi', '$2a$10$jkpofbyAwIkV4WNRQzJHDuPUdF97p2Zrk4xXD842J.96XVWDDFMLq', 0);
# 567890
INSERT INTO ret_user(`id`, `name`, sex, age, birthday, address, password)
VALUES ('10', 'user10', '2', '14', now(), 'shandong', '$2a$10$j9BlU4Er9EIPb8DoxRQ/D.X7QiH7C3xAsWFwD.ResEwqIA342uv.K');
INSERT INTO ret_user(`id`, `name`, sex, age, birthday, address, password, status)
VALUES ('11', 'user11', '1', '16', now(), 'beijing', '$2a$10$Rg9IkxecBtvfZkchm5OqxOaJggxk1u/LJ/mYh/CC/BHF/HBM9TshK', 1);
# 345678
INSERT INTO ret_user(`id`, `name`, sex, age, birthday, address, password, status)
VALUES ('12', 'user12', '1', '14', now(), 'shanghai', '$2a$10$pM5npUqjNkFWi2CAIfD7oeugYqhPBlYtHS382kHL6b4nVJXB1NGUG',
        1);
# 901234
INSERT INTO ret_user(`id`, `name`, sex, age, birthday, address, password, status)
VALUES ('13', 'user13', '2', '15', now(), 'jiangxi', '$2a$10$jkpofbyAwIkV4WNRQzJHDuPUdF97p2Zrk4xXD842J.96XVWDDFMLq', 0);
# 567890
INSERT INTO ret_user(`id`, `name`, sex, age, birthday, address, password)
VALUES ('14', 'user14', '2', '14', now(), 'shandong', '$2a$10$j9BlU4Er9EIPb8DoxRQ/D.X7QiH7C3xAsWFwD.ResEwqIA342uv.K');

-- 用户角色关系表
-- auto-generated definition
DROP TABLE IF EXISTS ret_user_role_relation;
create table IF NOT EXISTS ret_user_role_relation
(
    `id` bigint(20) AUTO_INCREMENT,
    user_id bigint(20) null,
    role_id bigint(20) null,
    PRIMARY KEY (`id`),
    constraint FK_AUTHORITY_AND_USER_AUTH_ID
        foreign key (role_id) references ret_role (id),
    constraint KF_USER_AND_AUTHORITY_UID
        foreign key (user_id) references ret_user (id)
) comment '用户角色表' engine = InnoDB;

-- 工厂
INSERT INTO ret_user_role_relation(user_id, role_id)
values ('1', '2');
INSERT INTO ret_user_role_relation(user_id, role_id)
values ('2', '2');
INSERT INTO ret_user_role_relation(user_id, role_id)
values ('3', '2');
INSERT INTO ret_user_role_relation(user_id, role_id)
values ('4', '2');
-- 管理员
INSERT INTO ret_user_role_relation(user_id, role_id)
values ('5', '1');
INSERT INTO ret_user_role_relation(user_id, role_id)
values ('6', '1');
-- 用户
INSERT INTO ret_user_role_relation(user_id, role_id)
values ('7', '3');
INSERT INTO ret_user_role_relation(user_id, role_id)
values ('8', '3');
INSERT INTO ret_user_role_relation(user_id, role_id)
values ('9', '3');
INSERT INTO ret_user_role_relation(user_id, role_id)
values ('10', '3');
INSERT INTO ret_user_role_relation(user_id, role_id)
values ('11', '3');
INSERT INTO ret_user_role_relation(user_id, role_id)
values ('12', '3');
INSERT INTO ret_user_role_relation(user_id, role_id)
values ('13', '3');
INSERT INTO ret_user_role_relation(user_id, role_id)
values ('14', '3');


-- 工厂表
DROP TABLE IF EXISTS ret_factory;
CREATE TABLE ret_factory
(
    `id`          bigint(20)   NOT NULL AUTO_INCREMENT,
    `name`        varchar(64)  NOT NULL COMMENT '工厂名',
    `phone`       varchar(64)  NOT NULL COMMENT '联系电话',
    `email`       varchar(100) NOT NULL COMMENT '邮箱',
    `address`     varchar(100) NOT NULL COMMENT '地址',
    `description` varchar(50) COMMENT '描述',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 37
  DEFAULT CHARSET = utf8 COMMENT ='工厂表';;
INSERT INTO `ret_factory`(id, name, phone, email, address, description)
VALUES ('1', '五矿稀土', '未知1', '未知@未知1', '北京', '没什么描述1');
INSERT INTO `ret_factory`(id, name, phone, email, address, description)
VALUES ('2', '盛和资源', '未知2', '未知@未知2', '上海', '没什么描述2');
INSERT INTO `ret_factory`(id, name, phone, email, address, description)
VALUES ('3', '北方稀土', '未知3', '未知@未知3', '天津', '没什么描述3');
INSERT INTO `ret_factory`(id, name, phone, email, address, description)
VALUES ('4', '金力永磁', '未知4', '未知@未知4', '广州', '没什么描述4');


-- 工厂和用户关系表
DROP TABLE IF EXISTS ret_factory_member_relation;
CREATE TABLE ret_factory_user_relation
(
    `id` bigint(20) AUTO_INCREMENT,
    `factory_id` bigint(20),
    `user_id`    bigint(20),
    PRIMARY KEY (`id`),
    CONSTRAINT FK_FACTORY_AND_USER_USER_ID FOREIGN KEY (`user_id`) REFERENCES `ret_user` (`id`),
    CONSTRAINT FK_FACTORY_AND_USER_FACTORY_ID FOREIGN KEY (`factory_id`) REFERENCES `ret_factory` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='工厂和用户关系表';;
INSERT INTO ret_factory_user_relation(factory_id, user_id)
VALUES ('1', '1');
INSERT INTO ret_factory_user_relation(factory_id, user_id)
VALUES ('2', '2');
INSERT INTO ret_factory_user_relation(factory_id, user_id)
VALUES ('3', '3');
INSERT INTO ret_factory_user_relation(factory_id, user_id)
VALUES ('4', '4');

-- 反馈分类表
DROP TABLE IF EXISTS `ret_member_job`;
CREATE TABLE `ret_member_job`
(
    `id`          bigint(20)  NOT NULL AUTO_INCREMENT,
    `name`        varchar(20) NOT NULL COMMENT '名称',
    `description` varchar(100) DEFAULT NULL COMMENT '描述',
    CONSTRAINT PK_MEMBER_CATEGORY PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='成员职位表';
INSERT INTO `ret_member_job`(id, name, description)
VALUES (1, '运输人员', '送货到家');
INSERT INTO `ret_member_job`(id, name, description)
VALUES (2, '运营人员', '专题板块管理');
INSERT INTO `ret_member_job`(id, name, description)
VALUES (3, '销售人员', '卖货的');

-- 工厂成员表
DROP TABLE IF EXISTS ret_member;
CREATE TABLE ret_member
(
    `id`       bigint(20)  NOT NULL AUTO_INCREMENT,
    `phone`    varchar(64) NOT NULL COMMENT '联系方式',
    `nickname` varchar(64) NOT NULL COMMENT '昵称',
    CONSTRAINT PK_MEMBER PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 37
  DEFAULT CHARSET = utf8 COMMENT ='工厂成员表';
INSERT INTO ret_member(id, phone, nickname)
VALUES (1, '未知1', '张师傅');
INSERT INTO ret_member(id, phone, nickname)
VALUES (2, '未知1', '李师傅');
INSERT INTO ret_member(id, phone, nickname)
VALUES (3, '未知1', '黄师傅');
INSERT INTO ret_member(id, phone, nickname)
VALUES (4, '未知1', '张师傅');
INSERT INTO ret_member(id, phone, nickname)
VALUES (5, '未知1', '懂师傅');
INSERT INTO ret_member(id, phone, nickname)
VALUES (6, '未知1', '肖师傅');
INSERT INTO ret_member(id, phone, nickname)
VALUES (7, '未知1', '陈师傅');
INSERT INTO ret_member(id, phone, nickname)
VALUES (8, '未知1', '钟师傅');

-- 用户成员关系表
DROP TABLE IF EXISTS `ret_user_member_relation`;
CREATE TABLE `ret_user_member_relation`
(
    `id` bigint(20) AUTO_INCREMENT,
    `user_id`   bigint(20),
    `member_id` bigint(20),
    PRIMARY KEY (`id`),
    FOREIGN KEY (`user_id`) REFERENCES `ret_user` (`id`),
    FOREIGN KEY (`member_id`) REFERENCES `ret_member` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='成员和职位关系表';

INSERT `ret_user_member_relation`(user_id, member_id)
VALUES (7, 1);
INSERT `ret_user_member_relation`(user_id, member_id)
VALUES (8, 2);
INSERT `ret_user_member_relation`(user_id, member_id)
VALUES (9, 3);
INSERT `ret_user_member_relation`(user_id, member_id)
VALUES (10, 4);
INSERT `ret_user_member_relation`(user_id, member_id)
VALUES (11, 5);
INSERT `ret_user_member_relation`(user_id, member_id)
VALUES (12, 6);
INSERT `ret_user_member_relation`(user_id, member_id)
VALUES (13, 7);
INSERT `ret_user_member_relation`(user_id, member_id)
VALUES (14, 8);

-- 成员和职位关系表
DROP TABLE IF EXISTS `ret_member_job_relation`;
CREATE TABLE `ret_member_job_relation_relation`
(
    `id` bigint(20) AUTO_INCREMENT,
    `member_id`     bigint(20),
    `member_job_id` bigint(20),
    PRIMARY KEY (`id`),
    CONSTRAINT FK_MEMBER_AND_JOB_MEMBER_ID FOREIGN KEY (`member_id`) REFERENCES `ret_member` (`id`),
    CONSTRAINT FK_MEMBER_AND_JOB_JOB_ID FOREIGN KEY (`member_job_id`) REFERENCES `ret_member_job` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='成员和职位关系表';
INSERT `ret_member_job_relation_relation`(member_id, member_job_id)
VALUES (1, 1);
INSERT `ret_member_job_relation_relation`(member_id, member_job_id)
VALUES (2, 2);
INSERT `ret_member_job_relation_relation`(member_id, member_job_id)
VALUES (3, 3);
INSERT `ret_member_job_relation_relation`(member_id, member_job_id)
VALUES (4, 1);
INSERT `ret_member_job_relation_relation`(member_id, member_job_id)
VALUES (5, 2);
INSERT `ret_member_job_relation_relation`(member_id, member_job_id)
VALUES (6, 3);
INSERT `ret_member_job_relation_relation`(member_id, member_job_id)
VALUES (7, 1);
INSERT `ret_member_job_relation_relation`(member_id, member_job_id)
VALUES (8, 2);


-- 工厂和成员关系表
DROP TABLE IF EXISTS ret_factory_member_relation;
CREATE TABLE ret_factory_member_relation
(
    `id` bigint(20) AUTO_INCREMENT,
    `factory_id` bigint(20) NOT NULL,
    `member_id`  bigint(20) NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT FK_FACTORY_AND_MEMBER_FACTORY_ID FOREIGN KEY (`factory_id`) REFERENCES `ret_factory` (`id`),
    CONSTRAINT FK_FACTORY_AND_MEMBER_MEMBER_ID FOREIGN KEY (`member_id`) REFERENCES `ret_member` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='工厂和成员关系表';;
INSERT INTO ret_factory_member_relation(factory_id, member_id)
VALUES (1, 1);
INSERT INTO ret_factory_member_relation(factory_id, member_id)
VALUES (1, 2);
INSERT INTO ret_factory_member_relation(factory_id, member_id)
VALUES (1, 3);
INSERT INTO ret_factory_member_relation(factory_id, member_id)
VALUES (1, 4);
INSERT INTO ret_factory_member_relation(factory_id, member_id)
VALUES (2, 5);
INSERT INTO ret_factory_member_relation(factory_id, member_id)
VALUES (2, 6);
INSERT INTO ret_factory_member_relation(factory_id, member_id)
VALUES (4, 7);
INSERT INTO ret_factory_member_relation(factory_id, member_id)
VALUES (3, 8);

-- 产品表
DROP TABLE IF EXISTS `ret_product`;
CREATE TABLE `ret_product`
(
    `id`                   bigint(20)   NOT NULL AUTO_INCREMENT,
    `name`                 varchar(100) NOT NULL COMMENT '名称',
    `batch_id`             varchar(100) NOT NULL,
    `description`          text         DEFAULT NULL COMMENT '描述',
    `dispatch_time`        datetime     DEFAULT NULL COMMENT '出货日期',
    `moisture_proof_logo`  varchar(256) DEFAULT NULL COMMENT '防潮标识',
    `specification`        varchar(100) DEFAULT NULL COMMENT '规格',
    `packing_type`         varchar(50)  DEFAULT NULL COMMENT '包装类型',
    `net_weight`           varchar(50)  DEFAULT NULL COMMENt '净重',
    `transport_log`        varchar(256) DEFAULT NULL COMMENT '运输标志',
    `pic`                  varchar(256) DEFAULT NULL COMMENT '图片',
    `purity`               varchar(20)  DEFAULT NULL COMMENT '纯度',
    `production_equipment` varchar(100) DEFAULT NULL COMMENT '生产设备',
    `material_ratio`       varchar(50)  DEFAULT NULL COMMENT '物料配比',
    `extraction_unit`      varchar(50)  DEFAULT NULL COMMENT '提取单位',
    `album_pics`           varchar(255) DEFAULT NULL COMMENT '画册图片，连产品图片限制为5张，以逗号分割',
    CONSTRAINT PK_PRODUCT PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 37
  DEFAULT CHARSET = utf8 COMMENT ='产品信息';
INSERT `ret_product`(id, name, batch_id)
VALUES (1, '烧结钕铁硼', 'A-10');
INSERT `ret_product`(id, name, batch_id)
VALUES (2, '粘结钕铁硼', 'A-10');
INSERT `ret_product`(id, name, batch_id)
VALUES (3, '注塑钕铁硼', 'A-10');
INSERT `ret_product`(id, name, batch_id)
VALUES (4, '钐钴5型', 'A-10');
INSERT `ret_product`(id, name, batch_id)
VALUES (5, '钐钴17型', 'A-10');
INSERT `ret_product`(id, name, batch_id)
VALUES (6, '烧结铝镍钴', 'A-10');
INSERT `ret_product`(id, name, batch_id)
VALUES (7, '铸造铝镍钴', 'A-10');
INSERT `ret_product`(id, name, batch_id)
VALUES (8, '永磁铁氧体', 'A-10');
INSERT `ret_product`(id, name, batch_id)
VALUES (9, '软磁铁氧体', 'A-10');
INSERT `ret_product`(id, name, batch_id)
VALUES (10, '旋磁铁氧体', 'A-10');
INSERT `ret_product`(id, name, batch_id)
VALUES (11, '同性橡胶磁', 'A-10');
INSERT `ret_product`(id, name, batch_id)
VALUES (12, '异性橡胶磁', 'A-10');
INSERT `ret_product`(id, name, batch_id)
VALUES (13, '单面磁', 'A-10');
INSERT `ret_product`(id, name, batch_id)
VALUES (14, '双面磁', 'A-10');
INSERT `ret_product`(id, name, batch_id)
VALUES (15, '背胶', 'A-10');
INSERT `ret_product`(id, name, batch_id)
VALUES (16, '不背胶', 'A-10');

-- 产品文档表
DROP TABLE IF EXISTS `ret_product_document`;
CREATE TABLE `ret_product_document`
(
    `id`      bigint(20) NOT NULL,
    `title`   varchar(50) DEFAULT NULL COMMENT '标题',
    `content` text        DEFAULT NULL COMMENT '内容',
    CONSTRAINT PK_PRODUCT_DOCUMENT PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 7
  DEFAULT CHARSET = utf8 COMMENT ='产品文档表';


-- 产品和产品文档关系表
DROP TABLE IF EXISTS `ret_product_document_relation`;
CREATE TABLE `ret_product_document_relation`
(
    `id` bigint(20) AUTO_INCREMENT,
    `product_id`          bigint(20),
    `product_document_id` bigint(20),
    PRIMARY KEY (`id`),
    CONSTRAINT FK_PRODUCT_AND_DOCUMENT_PRODUCT_ID FOREIGN KEY (`product_id`) REFERENCES `ret_product` (`id`),
    CONSTRAINT FK_PRODUCT_AND_DOCUMENT_DOCUMENT_ID FOREIGN KEY (`product_document_id`) REFERENCES `ret_product_document` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='产品和产品文档关系表';

-- 产品厂家关系表
DROP TABLE IF EXISTS `ret_product_factory_relation`;
CREATE TABLE `ret_product_factory_relation`
(
    `id` bigint(20) AUTO_INCREMENT,
    `product_id` bigint(20),
    `factory_id` bigint(20),
    PRIMARY KEY (`id`),
    CONSTRAINT PK_PRODUCT_AND_FACTORY_PRODUCT_ID FOREIGN KEY (`product_id`) REFERENCES `ret_product` (`id`),
    CONSTRAINT PK_PRODUCT_AND_FACTORY_FACTORY_ID FOREIGN KEY (`factory_id`) REFERENCES `ret_factory` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='产品厂家关系表';
INSERT ret_product_factory_relation(product_id, factory_id)
VALUES (1, 1);
INSERT ret_product_factory_relation(product_id, factory_id)
VALUES (2, 1);
INSERT ret_product_factory_relation(product_id, factory_id)
VALUES (3, 1);
INSERT ret_product_factory_relation(product_id, factory_id)
VALUES (4, 1);
INSERT ret_product_factory_relation(product_id, factory_id)
VALUES (5, 1);
INSERT ret_product_factory_relation(product_id, factory_id)
VALUES (1, 1);


-- 材料表
DROP TABLE IF EXISTS `ret_material`;
CREATE TABLE `ret_material`
(
    `id`                  bigint(20)   NOT NULL AUTO_INCREMENT,
    `name`                varchar(100) NOT NULL COMMENT '名称',
    `origin`              varchar(100) DEFAULT NULL COMMENT '产地',
    `create_company_name` varchar(100) DEFAULT NULL COMMENT '出产公司名',
    `description`         text         DEFAULT NULL COMMENT '描述',
    CONSTRAINT PK_MATERIAL PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 37
  DEFAULT CHARSET = utf8 COMMENT ='材料表';
INSERT INTO `ret_material`(id, name, origin, create_company_name, description)
VALUES (1, '铝镍钴', '产地1', '出产公司1', '        铝镍钴（AlNiCo）是最早开发出来的一种永磁材料，是由铝、镍、钴、铁和其它微量金属元素构成的一种合金。铝镍钴永磁材料是20世纪30年代研制成功的。当时，它的磁性能最好，温度系数又小，因而在永磁电机中应用得最多、最广。60年代以后，随着铁氧体永磁和稀土永磁的相继问世，铝镍钴永磁在电机中的应用逐步被取代，所占比例呈下降趋势。
根据生产工艺不同分为烧结铝镍钴（Sintered AlNiCo）和铸造铝镍钴（Cast AlNiCo）。产品形状多为圆形和方形。铸造工艺可以加工生产成不同的尺寸和形状；与铸造工艺相比，烧结产品局限于小的尺寸，其生产出来的毛坯尺寸公差比铸造产品毛坯要好，磁性能要略低于铸造产品，但可加工性要好。在永磁材料中，铸造铝镍钴永磁有着最低可逆温度系数，工作温度可高达600摄氏度以上。铝镍钴永磁产品广泛应用于各种仪器仪表和其他应用领域。

        铝镍钴系磁铁的优点是剩磁高（最高可达1.35T）、温度系数低。在温度系数为-0.02%/℃时，最高使用温度可达520℃左右。缺点是矫顽力非常低（通常小于160kA/m），退磁曲线非线性。 因此铝镍钴磁铁虽然容易被磁化， 同样也容易退磁。');
INSERT `ret_material`(id, name)
VALUES (2, '钐钴');
INSERT `ret_material`(id, name)
VALUES (3, '钕铁硼');
INSERT `ret_material`(id, name)
VALUES (4, '钐铁氮');
INSERT `ret_material`(id, name)
VALUES (5, '镨钕合金');
INSERT `ret_material`(id, name)
VALUES (6, '金属铽');
INSERT `ret_material`(id, name)
VALUES (7, '金属镨');
INSERT `ret_material`(id, name)
VALUES (8, '金属钕');
INSERT `ret_material`(id, name)
VALUES (9, '氧化铕');
INSERT `ret_material`(id, name)
VALUES (10, '氧化铽');
INSERT `ret_material`(id, name)
VALUES (11, '氧化镝');
INSERT `ret_material`(id, name)
VALUES (12, '氧化钇');
INSERT `ret_material`(id, name)
VALUES (13, '氧化镨钕');


-- 材料分类表
DROP TABLE IF EXISTS `ret_material_category`;
CREATE TABLE `ret_material_category`
(
    `id`          bigint(20)   NOT NULL AUTO_INCREMENT,
    `name`        varchar(100) NULL NULL COMMENT '名称',
    `description` text DEFAULT NULL COMMENt '描述',
    CONSTRAINT PK_MATERIAL_CATEGORY PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 7
  DEFAULT CHARSET = utf8 COMMENT ='材料分类表';
INSERT `ret_material_category`(id, name, description)
VALUES (1, '永磁', '        稀土家族是来自镧系的15个元素，加上与镧系相关密切的钪和钇共17种元素。');
INSERT `ret_material_category`(id, name, description)
VALUES (2, '软磁', '具有低矫顽力的磁性材料，亦称高导磁材料');
INSERT `ret_material_category`(id, name, description)
VALUES (3, '稀土原材料', '原材料');
INSERT `ret_material_category`(id, name, description)
VALUES (4, '功能磁材材料', '功能磁材材料');


-- 材料分类文档表
DROP TABLE IF EXISTS `ret_material_category_document`;
CREATE TABLE `ret_material_category_document`
(
    `id`      bigint(20)   NOT NULL AUTO_INCREMENT,
    `title`   varchar(100) NULL NULL COMMENT '标题',
    `content` text DEFAULT NULL COMMENt '内容',
    CONSTRAINT PK_MATERIAL_CATEGORY_DOCUMENT PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 7
  DEFAULT CHARSET = utf8 COMMENT ='材料分类文档表';
INSERT `ret_material_category_document`(id, title, content)
VALUES (1, '描述', '        稀土家族是来自镧系的15个元素，加上与镧系相关密切的钪和钇共17种元素。它们是：镧、铈、镨、钕、钷、钐、铕、钆、铽、镝、钬、铒、铥、镱、镥、钪、钇。
        其中重要的一个功用就是永磁， 钕(Nd) ,金属钕的最大用户是钕铁硼永磁材料。钕铁硼永磁体的问世，为稀土高科技领域注入了新的生机与活力。钕铁硼磁体磁能积高，被称作当代“永磁之王”，以其优异的性能广泛用于电子、机械等行业。');
INSERT `ret_material_category_document`(id, title, content)
VALUES (2, '用途', '    不仅仅如此，稀土还有许多神奇功用：
    由于特殊的原子结构，稀土家族的成员非常的活泼，且个个身手不凡，魔力无边。它们与其他元素结合，便可组成品类繁多、功能千变万化、用途各异的新型材料，且性能翻番提高，被称作当代的“工业味精”。 如：在超音速飞机中应用含稀土的АЦР1和ЖП207合金，可在400℃以下长期工作，它是现今高温性能最好的合金之一，它的持久强度比一般铝合金可提高1～2倍； 钢中加入稀土后，制成的薄料横向冲击韧性提高50%以上，耐腐蚀性能提高60%，而每吨钢只要加稀土300克左右，作用十分显著，真可谓四两拨千斤； 稀土添加在酸性纺织染料中，可以提高上染率、调整染料和纤维的亲和力、提高染色牢度、改善纤维的色泽、外观质量及手感柔软度、并可节约染料及减少环境污染和减轻劳动强度等； 稀土元素可以提高植物的叶绿素含量、增强光合作用、促进根系的发育和对养分的吸收。还能促进种子萌发、促进幼苗生长，还具有使作物增强抗病、抗寒、抗旱的能力； 用稀土钷作热源，可为真空探测和人造卫星提供辅助能量。钷电池可作为导弹制导仪器及钟表的电源，此种电池体积小，能连续使用数年之久。 在今天的世界上，无论是航天、航空、军事等高科技领域，还是人们的日常生活用品，无论工业、农牧业、还是化学、生物学、医药，稀土的应用及其作用几乎是无所不在，无所不能。');
INSERT `ret_material_category_document`(id, title, content)
VALUES (3, '描述', '具有低矫顽力的磁性材料，亦称高导磁材料。在电力工业中用于制造电机、变压器等电器设备的铁芯。在电子工业中用于制造各种磁性元件，广泛应用于电视、广播和通信等方面。这类材料具有饱和磁通密度高，磁导率高，磁滞回线呈狭长形、面积小，磁滞损耗小，剩磁及矫顽力小等特性。用于交流场合时要求涡流损耗及磁滞损耗小。常用的有纯铁、低碳钢、硅钢片、坡莫合金、铁氧体等。
(1)纯铁、低碳钢：磁导率高、加工性能好。但涡流损耗大，只宜用于直流铁芯。
(2)硅钢片、硅钢带：电阻率高，涡流损耗小。但质脆、加工性能差。片状叠合或卷成环状使用，片间浸绝缘漆或形成氧化层以减小涡流损耗。
(3)坡莫合金：铁镍合金的统称，具有很高的磁导率。用于精密仪表、记录磁头等或要求体积小的场合。
(4)铁氧体：以Fe2O3为主要成分，掺合Mn-Zn或Ni-Zn等，用粉末冶金法压制成锰锌铁氧体或镍锌铁氧体，其电阻率高，高频损耗小，前者用于1MHz以下，后者用于微波频率。工作频率越高则其磁导率越低。铁氧体属于亚铁磁性材料，磁导率低于铁磁材料。
当磁化发生在Hc不大于1000A/m，这样的材料称为软磁体。典型的软磁材料，可以用最小的外磁场实现最大的磁化强度。
软磁材料主要特点：软磁材料（soft magnetic material）具有低矫顽力和高磁导率的磁性材料。软磁材料易于磁化，也易于退磁，广泛用于电工设备和电子设备中。应用最多的软磁材料是铁硅合金(硅钢片)以及各种软磁铁氧体等 。
');
INSERT `ret_material_category_document`(id, title, content)
VALUES (4, '应用', '...');
INSERT `ret_material_category_document`(id, title, content)
VALUES (5, '历史', '稀土的历史:
        从1794年发现元素钇，到195年在的裂变物质中获得钷，前后经过151年的时间人们才将元素周期表中第三副族的钪、钇、铜、铈、错、钕、钷、钐、铕、钆、铖、镝、铒、铥、镱、镥17个性质相近的元素全部找到，把它们列为一个家族，取名稀土元素。我国稀土品种全，17种元素除钷尚未发现天然矿物，其余16种稀土元素均已发现矿物、矿石。');
INSERT `ret_material_category_document`(id, title, content)
VALUES (6, '资源', '资源储量分布:
        我国稀土矿产主要集中在内蒙古白云鄂博铁_铌、稀土矿区，其稀土储量占全国稀土总储量的90%以上，是我国轻稀土主要生产基地。即轻稀土主要分布在北方地区，重稀土则主要分布在南方地区，尤其是在南岭地区分布可观的离子吸附型中稀土、重稀土矿，易采、易提取，已成为我国重要的中、重稀土生产基地。此外，在南方地区还有风化壳型和海滨沉积型砂矿，有的富含磷铭矿(重稀土矿物原料);在赣南一些脉钨矿床(如西华山、荡坪等)伴生磷钇矿、硅铍钇矿、钇萤石、氟碳钙钇矿、褐钇铌矿等重稀土矿物，在钨矿选诒过程中可综合回收，综合利用。');
INSERT `ret_material_category_document`(id, title, content)
VALUES (7, '用途', '稀土的用途:
        稀土(R)常被冠以“工业味精”的美誉。稀土元素因其具有独特的电子结构而表现出特殊的光、电、磁学等物理化学性质。无论是稀土金属还是其化合物都有良好的应用价值.');
INSERT `ret_material_category_document`(id, title, content)
VALUES (8, '应用', '
(1)稀土在农轻工中的应用
        稀土元素作为微量元素用于农业有2个优点:一是作为植物的生长、生理调节剂;二是稀土属低毒、非致癌物质，合理使用对人畜无害、环境无污染。如添加稀土元素的硝醱盐化合物作为微量元素化肥施用于农作物可起到生物化学酶或辅助酶的生物功效，具有增产效果。纺织业中:铈组元素(Bu1以前的镧系元素)的氯化物或醋酸盐可提高纺织品的耐水性，
并使织物具有防腐、防蛀、防酸等性能某些稀土化合物还可以作为皮革的着色剂或媒染剂，a、Ce、阳的一些化合物可用作油漆的燥剂，增强油漆的耐腐蚀性。
(2)稀土在冶炼工业中的应用
        稀土元素对0、s和某些非金属具有强亲和力，利用这一特点，将稀土用于炼钢中能净化钢液，能起到脱S和脱0的作用，其原理是加入钢中的稀土能结合钢中可能生成的hSA1:0:和硅铝酸夹杂物中的0和s形成化合物。
钢的脱硫:在钢中添加混合稀土金属的目的之一是控制硫来杂物的含量和形状。炼钢通常要添加锰，锰与硫结合形成硫化物夹杂物，这种夫杂物在轧钢时会变形。而添加混合稀士金属则能产生稀土的硫化物硫氧化物，它们在轧钢时形状保持不变，使钢的性能得到改善。稀土球墨铸铁:混合稀土金属以稀土硅铁合金或硅镁钛合金的形式加入铁不中促进石墨的球化，从而提高铸铁的可锻强度。产品称球婴铸铁。
         打火石:混合稀土金属制造打火石，这是756的混合稀土金属和25的铁制成的一种合金有色金属合金中:稀土金属有色金属合金中也获得广泛应用。

       例如有一种稀土镁合金(含有M、Zn、Zx、La、Ce)可用于制造喷气式发动机的传动装置，直升飞机的变速箱，飞机的着陆轮和座舱罩。在镁合金中添加稀士金属优点是可提高其高温抗蠕变性，改善铸造性和室温可焊性。有一种铝锆钇合金用作电线，其特点是输出功率高、耐热、耐振动和耐腐蚀。

3)稀土在炼油业中的应用

        目前，世界上90%的炼油裂化装置都使用含稀土的催化剂，其中稀土分子筛型石油裂化。
');
INSERT `ret_material_category_document`(id, title, content)
VALUES (9, '基本概念', '        “磁”来源于电。一个环形电流在其运动中心产生的磁矩为P=is，i为电流强度，s为环形回路所包围的面积
原子内的电子做循轨运动和自旋运动，这必然产生磁矩，产生的磁矩分别称为轨道磁矩P1和自旋磁矩Ps。
磁矩，原子核虽然也产生磁矩，但它的值比电子个数量级，一般情況下可忽略不计。因此:原子磁矩的产生是电子的循轨运动、电子自旋这二者组合的结果');

-- 材料二次分类表
DROP TABLE IF EXISTS `ret_material_double_category`;
CREATE TABLE `ret_material_double_category`
(
    `id`          bigint(20)   NOT NULL AUTO_INCREMENT,
    `name`        varchar(100) NULL NULL COMMENT '名称',
    `description` text DEFAULT NULL COMMENt '描述',
    CONSTRAINT PK_MATERIAL_DOUBLE_CATEGORY PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 7
  DEFAULT CHARSET = utf8 COMMENT ='材料二次分类文档表';
INSERT `ret_material_double_category`(id, name, description)
VALUES ('1', '金属永磁材料', '稀土永磁材料是将钐、钕混合稀土金属与过渡金属（如钴、铁等）组成的合金，用粉末冶金方法压型烧结，经磁场充磁后制得的一种磁性材料');
INSERT `ret_material_double_category`(id, name, description)
VALUES ('2', '铁氧体永磁材料', '....');
INSERT `ret_material_double_category`(id, name, description)
VALUES ('3', '稀土永磁材料', '稀土永磁材料是将钐、钕混合稀土金属与过渡金属（如钴、铁等）组成的合金，用粉末冶金方法压型烧结，经磁场充磁后制得的一种磁性材料');
INSERT `ret_material_double_category`(id, name, description)
VALUES ('4', '稀土合金', ' 稀土合金是指含有稀土金属的合金，稀土是一类金属的统称');
INSERT `ret_material_double_category`(id, name, description)
VALUES ('5', '稀土金属', '稀土金属（rare earth metals)又称稀土元素，是元素周期表ⅢB族中钪、钇、镧系17种元素的总称，常用R或RE表示');
INSERT `ret_material_double_category`(id, name, description)
VALUES ('6', '稀土氧化物', ' 稀土元素氧化物是指元素周期表中原子序数为57 到71 的15种镧系元素氧化物，以及与镧系元素化学性质相似的钪（Sc） 和钇（Y）共17 种元素的氧化物');

-- 材料分类和二次分类文档关系表
DROP TABLE IF EXISTS `ret_material_category_double_category_relation`;
CREATE TABLE `ret_material_category_double_category_relation`
(
    `id` bigint(20) AUTO_INCREMENT,
    `category_id`        bigint(20),
    `double_category_id` bigint(20),
    PRIMARY KEY (`id`),
    CONSTRAINT PK_MATERIAL_CATEGORY_AND_DOUBLE_CATEGORY_FOR_CATEGORY FOREIGN KEY (`category_id`) REFERENCES `ret_material_category` (`id`),
    CONSTRAINT PK_MATERIAL_CATEGORY_AND_DOUBLE_CATEGORY_FOR_DOUBLE_CATEGORY FOREIGN KEY (`double_category_id`) REFERENCES `ret_material_double_category` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='材料分类和二次分类文档关系表';
INSERT `ret_material_category_double_category_relation`(category_id, double_category_id)
VALUES (1, 1);
INSERT `ret_material_category_double_category_relation`(category_id, double_category_id)
VALUES (1, 2);
INSERT `ret_material_category_double_category_relation`(category_id, double_category_id)
VALUES (3, 3);
INSERT `ret_material_category_double_category_relation`(category_id, double_category_id)
VALUES (3, 4);
INSERT `ret_material_category_double_category_relation`(category_id, double_category_id)
VALUES (3, 5);
INSERT `ret_material_category_double_category_relation`(category_id, double_category_id)
VALUES (3, 6);

-- 材料二次分类文档表
DROP TABLE IF EXISTS `ret_material_double_category_document`;
CREATE TABLE `ret_material_double_category_document`
(
    `id`      bigint(20)   NOT NULL AUTO_INCREMENT,
    `title`   varchar(100) NULL NULL COMMENT '标题',
    `content` text DEFAULT NULL COMMENt '内容',
    CONSTRAINT PK_MATERIAL_CATEGORY_DOCUMENT PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 7
  DEFAULT CHARSET = utf8 COMMENT ='材料二次分类文档表';
INSERT `ret_material_double_category_document`(id, title, content)
VALUES (1, '描述', '稀土永磁材料是将钐、钕混合稀土金属与过渡金属（如钴、铁等）组成的合金，用粉末冶金方法压型烧结，经磁场充磁后制得的一种磁性材料。
　　稀土永磁分为：钐钴（SmCo）永磁体和钕铁硼（NdFeB）永磁体。其中SmCo磁体的磁能积在15--30MGOe之间，NdFeB系磁体的磁能积在27--50MGOe之间，被称为“永磁王”，是目前磁性最高的永磁材料。钐钴永磁体，尽管其磁性能优异，但含有储量稀少的稀土金属钐和钴稀缺、昂贵的战略金属钴，因此，它的发展受到了很大的限制。我国稀土永磁行业的发展始于60年代末，当时的主导产品是钐-钴永磁，钐-钴永磁体世界销售量为630吨，我国为90.5吨（包括SmCo磁粉），主要用于军工技术。');
INSERT `ret_material_double_category_document`(id, title, content)
VALUES (2, '类目', '        现分为第一代（SmCo5）、第二代（SM2Co17）和第三代稀土永磁材料（NdFeB）。新的稀土过渡金属系和稀土铁氮系永磁合金材料正在开发研制中，有可能成为新一代稀土永磁合金。');
INSERT `ret_material_double_category_document`(id, title, content)
VALUES (3, '特性', '       随着计算机、通讯等产业的发展，稀土永磁特别是Nd-FeB永磁产业得到了飞速发展。
　　稀土永磁材料是现在已知的综合性能最高的一种永磁材料，它比九十世纪使用的磁钢的磁性能高100多倍，比铁氧体、铝镍钴性能优越得多，比昂贵的铂钴合金的磁性能还高一倍。由于稀土永磁材料的使用，不仅促进了永磁器件向小型化发展，提高了产品的性能，而且促使某些特殊器件的产生，所以稀土永磁材料一出现，立即引起全国的极大重视，发展极为迅速。我国研制生产的各种稀土永磁材材料的性能已接近或达到国际先进水平。');
INSERT `ret_material_double_category_document`(id, title, content)
VALUES (4, '描述', '生产工艺生产永磁铁氧体的原料主要是粉末状铁 的氧化物(FeZO3，FeO，FesO‘等);MO(M:Ba，Sr 等)或对其加热能很容易形成氧化物的M盐类物质。将 粉末状原料混合，在氧化气氛中预烧，使其发生固相反 应，生成MO·6 FeZO3磁性相。将预烧料粉碎后，经加 压成型。成型时若不加磁场则得到各向同性永磁铁氧 体;若加磁场使粒子的晶轴定向排列，则形成各向异性 永磁铁氧体。为了使粒子取向容易进行，在粉末中加水 制成铁氧泥浆状，此为湿法;不加水为干法。压力成型后要 作二次烧结，最后在磨床上进行精加工。为了改善永磁 铁氧体的脆性和提高工件的尺寸精度，可利用橡胶、塑 料做粘结剂，同铁氧体磁粉混合在一起制成橡胶磁体或 塑料磁体。它们分为各向同性、轧制取向各向异性、磁 场取向各向异性3类。 由于永磁铁氧体是单畴细粒子磁体，必须对预烧料 晶体尺寸、粉碎粒子的粒度及粒度分布和烧结后的晶体 尺寸进行控制。这主要靠加入添加剂实现。添加剂效应 为促进烧结反应，使密度增大和机械强度提高;抑制晶 粒长大，使单畴尺寸得以保持，并使饱和磁化强度增大 等。

        例如高岭土(A12O:·5102·2 HZO)在烧结过程中能 阻止晶粒长大，提高材料的矫顽力，5102和A1203也有 类似作用;碳酸钙在较低温度下分解形成熔融状态，有、 利于固相反应;降低烧结温度，增加致密程度。添加剂 种类很多，常根据原料、工艺及设备选用，并确定加入 量。 特点和应用铁氧体永磁材料的矫顽力很高，回复 磁导率较小，密度小，电阻率大;其最大磁能积不大， 但最大回复磁能积较大，宜制作在动态条件下工作的永 磁体。永磁铁氧体缺点是剩磁较小;磁感应温度系数较 大，约为0.18一0.2%/℃;低温时会出现矫顽力下降 的现象，故在精密仪表中尚难推广使用。 由于永磁铁氧体价格低廉，料源广泛，生产较为简 便，在性能上又兼有高矫顽力和高电阻率的特点，因此 应用极为广泛。各向向性铁氧体主要用于儿童玩具、微 型电机等。各向异性铁氧体在应用上有高剩磁和高矫顽 力之分，主要用于制作汽车电机、磁选机、扬声器、磁 性吸盘、磁控管、拾音器、起重磁体、磁水器等。橡塑 永磁铁氧体主要用于门锁磁体、磁性卡片、儿童玩具， 磁性密封等方面。 利用永磁铁氧体制作自动控制设备中大量使用的电 磁开关和电磁阀，钢铁厂提升和运送钢块的起重设备， 可节省大量的电力。利用永磁铁氧体制成的永磁电机， 可使汽车小型化和节省燃料。永磁铁氧体也大量用于家 用电器。 永磁铁氧体permanent ferrites具有高矫顽力和 剩磁值的铁氧体。又称硬磁铁氧体、恒磁铁氧体。通常 以最大磁能积衡量其性能。 1933年日本人加藤、武井发明了尖晶石结构的钻 铁氧体。它由大约含CoFeZO4和Fe3O‘各半的粉末原 料烧结而成，然后经磁场热处理(当温度下降到300℃ 左右时在直流磁场内冷却)。

');
INSERT `ret_material_double_category_document`(id, title, content)
VALUES (5, '描述',
        '稀土永磁材料是将钐、钕混合稀土金属与过渡金属（如钴、铁等）组成的合金，用粉末冶金方法压型烧结，经磁场充磁后制得的一种磁性材料。永磁材料，是指经过磁化以后撤去外磁场，而能长期保持磁性的物质。稀土永磁材料，即稀土永磁合金。永磁材料中含有作为合金元素的稀土金属。');
INSERT `ret_material_double_category_document`(id, title, content)
VALUES (6, '制备技术', '稀土永磁材料的制备:熔炼、浇铸机械合金化等。
熔炼技术：

                真空感应熔炼法(最常用)
                真空电弧熔炼法(多用于实验室研究
                真热还原扩散法(近年来到发展)
合金化或控制合金的结晶组织或制粉:
                浇铸/机械合金化熔体快淬法/气体雾化法高频震荡雾化法。');


-- 材料二次分类和二次分类文档关系表
DROP TABLE IF EXISTS `ret_material_double_category_document_relation`;
CREATE TABLE `ret_material_double_category_document_relation`
(
    `id` bigint(20) AUTO_INCREMENT,
    `double_category_id` bigint(20),
    `document_id`        bigint(20),
    PRIMARY KEY (`id`),
    CONSTRAINT PK_MATERIAL_DOUBLE_CATEGORY_AND_DOCUMENT_FOR_DOUBLE_CATEGORY FOREIGN KEY (`double_category_id`) REFERENCES `ret_material_double_category` (`id`),
    CONSTRAINT PK_MATERIAL_DOUBLE_CATEGORY_AND_DOCUMENT_FOR_DOCUMENT FOREIGN KEY (`document_id`) REFERENCES `ret_material_double_category_document` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='材料二次分类和二次分类文档关系表';
INSERT `ret_material_double_category_document_relation`(double_category_id, document_id)
VALUES (1, 1);
INSERT `ret_material_double_category_document_relation`(double_category_id, document_id)
VALUES (1, 2);
INSERT `ret_material_double_category_document_relation`(double_category_id, document_id)
VALUES (1, 3);
INSERT `ret_material_double_category_document_relation`(double_category_id, document_id)
VALUES (2, 4);
INSERT `ret_material_double_category_document_relation`(double_category_id, document_id)
VALUES (3, 5);
INSERT `ret_material_double_category_document_relation`(double_category_id, document_id)
VALUES (3, 6);


-- 材料分类和材料二次分类关系表
DROP TABLE IF EXISTS `ret_material_category_double_category_document_relation`;
CREATE TABLE `ret_material_category_double_category_document_relation`
(
    `id` bigint(20) AUTO_INCREMENT,
    `category_id`        bigint(20),
    `double_category_id` bigint(20),
    PRIMARY KEY (`id`),
    CONSTRAINT FOREIGN KEY (`category_id`) REFERENCES `ret_material_category` (`id`),
    CONSTRAINT FOREIGN KEY (`double_category_id`) REFERENCES `ret_material_double_category` (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 7
  DEFAULT CHARSET = utf8 COMMENT ='材料分类和材料二次分类关系表';
INSERT `ret_material_category_double_category_document_relation`(category_id, double_category_id)
VALUES (1, 1);
INSERT `ret_material_category_double_category_document_relation`(category_id, double_category_id)
VALUES (1, 2);
INSERT `ret_material_category_double_category_document_relation`(category_id, double_category_id)
VALUES (2, 3);
INSERT `ret_material_category_double_category_document_relation`(category_id, double_category_id)
VALUES (2, 4);
INSERT `ret_material_category_double_category_document_relation`(category_id, double_category_id)
VALUES (3, 5);
INSERT `ret_material_category_double_category_document_relation`(category_id, double_category_id)
VALUES (3, 6);


-- 材料和材料二次分类关系表
DROP TABLE IF EXISTS `ret_material_category_relation`;
CREATE TABLE `ret_material_category_relation`
(
    `id` bigint(20) AUTO_INCREMENT,
    `material_id`        bigint(20),
    `double_category_id` bigint(20),
    PRIMARY KEY (`id`),
    CONSTRAINT FK_MATERIAL_AND_CATEGORY_MATERIAL_ID FOREIGN KEY (`material_id`) REFERENCES `ret_material` (`id`),
    CONSTRAINT FK_MATERIAL_AND_DOUBLE_CATEGORY_CATEGORY_ID FOREIGN KEY (`double_category_id`) REFERENCES `ret_material_double_category` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='材料和材料二次分类关系表';
INSERT `ret_material_category_relation`(material_id, double_category_id)
VALUES (1, 1);
INSERT `ret_material_category_relation`(material_id, double_category_id)
VALUES (2, 3);
INSERT `ret_material_category_relation`(material_id, double_category_id)
VALUES (3, 3);
INSERT `ret_material_category_relation`(material_id, double_category_id)
VALUES (4, 3);
INSERT `ret_material_category_relation`(material_id, double_category_id)
VALUES (5, 5);
INSERT `ret_material_category_relation`(material_id, double_category_id)
VALUES (6, 6);
INSERT `ret_material_category_relation`(material_id, double_category_id)
VALUES (7, 5);
INSERT `ret_material_category_relation`(material_id, double_category_id)
VALUES (8, 5);
INSERT `ret_material_category_relation`(material_id, double_category_id)
VALUES (9, 6);
INSERT `ret_material_category_relation`(material_id, double_category_id)
VALUES (10, 6);
INSERT `ret_material_category_relation`(material_id, double_category_id)
VALUES (11, 6);
INSERT `ret_material_category_relation`(material_id, double_category_id)
VALUES (12, 6);
INSERT `ret_material_category_relation`(material_id, double_category_id)
VALUES (13, 6);


-- 材料文档表
DROP TABLE IF EXISTS `ret_material_document`;
CREATE TABLE `ret_material_document`
(
    `id`      bigint(20)   NOT NULL AUTO_INCREMENT,
    `title`   varchar(100) NULL NULL COMMENT '标题',
    `content` text DEFAULT NULL COMMENt '内容',
    CONSTRAINT PK_MATERIAL_DOCUMENT PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 7
  DEFAULT CHARSET = utf8 COMMENT ='材料文档表';
INSERT `ret_material_document`(id, title, content)
VALUES ('1', '描述', '        钐钴（SmCo）作为第二代稀土永磁体，不但有着较高的磁能积（14-32MGOe）和可靠的矫顽力，而且在稀土永磁系列中表现出良好的温度特性。与钕铁硼相比，钐钴更适合工作在高温环境中。

SmCo5 Sm2Co17（钐钴永磁体）');
INSERT `ret_material_document`(id, title, content)
VALUES ('2', '物理特性', '密度d8.4g/cm3

电阻率ρ9E-7 Ωm

抗弯强度 127.4MPa

抗压强度509.6MPa

热膨胀系数9*10-6 /℃

其中钐钴磁铁的制造厂家主要分布在四川及浙江两省，全国的所有供应商目前不超过十家！可见其市场是非常小的！');
INSERT `ret_material_document`(id, title, content)
VALUES ('3', '磁特性', '剩磁Br>1.05T（>10.5kGs）

磁感应矫顽力HcB>676kA/m（>8.5kOe）


内禀矫顽力Hcj>1194kA/m（>15kOe）

最大磁能积（BH）max>209.96kJ/m3(26~30MGs.Oe)

Br温度系数-0.03%/℃

可逆磁导率μ1.03H/m

居里温度Tc670~850℃');
INSERT `ret_material_document`(id, title, content)
VALUES ('4', '描述', '        镨钕氧化物，分子式( PrNd)XOy，性状外观为灰色或棕褐色粉末，易吸水吸气，须存放在干燥处，不能露天放置。供深加工和玻璃、陶瓷磁性材料等用。氧化镨钕灰色粉末，是金属镨钕(即镨钕合金)的原料，氧化镨钕高温融化加工后形成金属镨钕。
        镨钕，金属Pr-Nd，系银灰色金属锭。稀土总量为99%以上。该金属中钕含量75%左右、镨含量25%左右，故名。金属镨钕在空气中易氧化。属低毒物质，其毒性相当于铁。稀士类在动物体内几乎全部水解，形成氢氧化物的胶体和沉淀，因而不易被吸收。在干燥环境中妥善保管能长期存放。
        镨钕合金是生产高性能钕铁硼永磁材料的主要原料。其在钕铁硼永磁材料成本中占比约为27%。镨钕氧化物供深加工和玻璃、陶瓷.、磁性材料等用。镝铁合金主要用于钕铁硼永磁材料，制造超磁致伸缩合金，光磁记录材料，核燃料稀释剂等。

');
INSERT `ret_material_document`(id, title, content)
VALUES ('5', '描述',
        '        镨是一种金属元素，属稀土金属。元素名来源于希腊文，原意是“绿色”。晶体结构为晶胞为六方晶胞。镨在空气中抗腐蚀能力比镧、铈、钕和铕都要强，但暴露在空气中会产生一层易碎的绿色氧化物，纯镨必须在矿物油或密封塑料中保存。镨的用途之一是用于石油催化裂化。以镨钕富集物的形式加入Y型沸石分子筛中制备石油裂化催化剂，可提高催化剂的活性、选择性和稳定性。镨像其他稀土元素一样，具有慢性低毒，不是生物必须元素。');
INSERT `ret_material_document`(id, title, content)
VALUES ('6', '发展历史', '        1841年C·G·莫桑德尔从铈土中得到镨、钕混合物，命名为didymia。
        1885年奥地利化学家威斯巴赫从氧化中分离出氧化钐后分离出新元素的氧化物，将这种新元素命名为preseodidymium，由Praseo（绿色）和didymium（钕镨混合物）组成，即“绿”，因为它的盐是绿色。这个元素的名称简化成praseodymium。译成镨，元素符号是Pr。 镨的英文名来源于希腊文prasios，原意是“绿色的孪生兄弟”。这是因为镨和钕共生在一起，而且镨的氧化物Pr2O3为浅绿色。');
INSERT `ret_material_document`(id, title, content)
VALUES ('7', '物理特性',
        ' 银白色金属，质较软，有延展性。室温下镨为六方晶体结构。自然界中镨只有一种稳定同位素，141-Pr。 但有38种放射性同位素，其中比较稳定的有143-Pr，半衰期为13.57 天；142-Pr，半衰期为19.12小时。 其他的放射性同位素的半衰期都超不过5.985 小时，大部分的半衰期少于33秒。镨还有6个亚稳态，比较稳定的是138m-Pr （t&frac12；2.12 小时），142m-Pr （t&frac12：14.6 分） 和134m-Pr （t&frac12：11 分）。镨的同位素原子量从120.955 u （121-Pr）到 158.955 u （159-Pr）。稳定同位素 141-Pr如果放出β射线，会俘获电子。主要放射产物为铈的同位素铈58和钕的同位素钕60。');
INSERT `ret_material_document`(id, title, content)
VALUES ('8', '化学性质',
        '        元素符号Pr，属周期系ⅢB族，稀土元素，镧系元素。在空气中抗腐蚀能力比镧、铈、钕和铕都要强，但暴露在空气中会产生一层易碎的绿色氧化物，镨在空气中缓慢形成绿色易碎氧化物层；镨通常以三价氧化态存在，也以4价形式存在。    ');
INSERT `ret_material_document`(id, title, content)
VALUES ('9', '描述',
        '      化学式Y2O3，白色略带黄色粉末，不溶于水和碱，溶于酸。主要用作制造微波用磁性材料和军工用重要材料（单晶；钇铁柘榴石、钇铝柘榴石等复合氧化物），也用作光学玻璃、陶瓷材料添加剂、大屏幕电视用高亮度荧光粉和其他显像管涂料等。');
INSERT `ret_material_document`(id, title, content)
VALUES ('10', '理化性质', '      【中文名称】氧化钇
      【英文名称】yttrium oxide；yttria
       【CAS No.】1314-36-9
       【 化学式】Y O
       【分子量】225.81
      【 密度】5.01 g/cm3
      【 熔点】2410 ℃
      【沸点】4300 °C
      【性状】白色略带黄色粉末
      【溶解】不溶于水和碱，溶于酸。
      【制备】分解 褐钇铌矿所得的混合 稀土溶液经萃取、酸溶、再萃取、直接浓缩、灼烧而得。
      【其他】露置空气中易吸收 二氧化碳和水。');
INSERT `ret_material_document`(id, title, content)
VALUES ('11', '用途',
        '       主要用作制造 微波用磁性材料和军工用重要材料（ 单晶；钇铁柘榴石、钇铝柘榴石等复合 氧化物），也用作光学玻璃、陶瓷材料添加剂、大屏幕电视用高亮度 荧光粉和其他显像管涂料。还用于制造薄膜电容器和特种耐火材料，以及高压水银灯、激光、储存元件等的 磁泡材料。烧结时添加氧化钇可有效降低钨合金的晶粒度。');

-- 材料和文档关系表
DROP TABLE IF EXISTS `ret_material_document_relation`;
CREATE TABLE `ret_material_document_relation`
(
    `id` bigint(20) AUTO_INCREMENT,
    `material_id` bigint(20),
    `document_id` bigint(20),
    PRIMARY KEY (`id`),
    CONSTRAINT FK_MATERIAL_AND_DOCUMENT_MATERIAL_ID FOREIGN KEY (`material_id`) REFERENCES `ret_material` (`id`),
    CONSTRAINT FK_MATERIAL_AND_DOCUMENT_DOCUMENT_ID FOREIGN KEY (`document_id`) REFERENCES `ret_material_document` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='材料和文档关系表';
INSERT `ret_material_document_relation`(material_id, document_id)
VALUES (2, 1);
INSERT `ret_material_document_relation`(material_id, document_id)
VALUES (2, 2);
INSERT `ret_material_document_relation`(material_id, document_id)
VALUES (2, 3);
INSERT `ret_material_document_relation`(material_id, document_id)
VALUES (5, 4);
INSERT `ret_material_document_relation`(material_id, document_id)
VALUES (7, 5);
INSERT `ret_material_document_relation`(material_id, document_id)
VALUES (7, 6);
INSERT `ret_material_document_relation`(material_id, document_id)
VALUES (7, 7);
INSERT `ret_material_document_relation`(material_id, document_id)
VALUES (7, 8);
INSERT `ret_material_document_relation`(material_id, document_id)
VALUES (12, 9);
INSERT `ret_material_document_relation`(material_id, document_id)
VALUES (12, 10);
INSERT `ret_material_document_relation`(material_id, document_id)
VALUES (12, 11);


-- 材料产品关系表
DROP TABLE IF EXISTS `ret_material_product_relation`;
CREATE TABLE `ret_material_product_relation`
(
    `id` bigint(20) AUTO_INCREMENT,
    `material_id` bigint(20),
    `product_id`  bigint(20),
    PRIMARY KEY (`id`),
    CONSTRAINT FK_MATERIAL_AND_PRODUCT_MATERIAL_ID FOREIGN KEY (`material_id`) REFERENCES `ret_material` (`id`),
    CONSTRAINT FK_MATERIAL_AND_PRODUCT_PRODUCT_ID FOREIGN KEY (`product_id`) REFERENCES `ret_product` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='材料产品关系表';
INSERT `ret_material_product_relation`(material_id, product_id)
VALUES (1, 3);
INSERT `ret_material_product_relation`(material_id, product_id)
VALUES (2, 3);
INSERT `ret_material_product_relation`(material_id, product_id)
VALUES (3, 3);
INSERT `ret_material_product_relation`(material_id, product_id)
VALUES (4, 2);
INSERT `ret_material_product_relation`(material_id, product_id)
VALUES (5, 2);
INSERT `ret_material_product_relation`(material_id, product_id)
VALUES (6, 1);
INSERT `ret_material_product_relation`(material_id, product_id)
VALUES (7, 1);

-- 专题表
DROP TABLE IF EXISTS `ret_subject`;
CREATE TABLE `ret_subject`
(
    `id`          bigint(20)   NOT NULL AUTO_INCREMENT,
    `name`        varchar(100) NOT NULL COMMENT '名称',
    `content`     text         NOT NULL COMMENT '描述',
    `title`       varchar(100) NOT NULL COMMENT '标题',
    `create_time` datetime DEFAULT NOW() COMMENT '创建时间',
    `reading`     bigint(20)   NOT NULL COMMENT '阅读量',
    `sort`        int      DEFAULT '0' COMMENT '排序',
    CONSTRAINT PK_THEME PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='专题表';

-- 专题分类表
DROP TABLE IF EXISTS `ret_subject_category`;
CREATE TABLE `ret_subject_category`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT,
    `name`        varchar(100) DEFAULT NULL COMMENt '名称',
    `description` varchar(100) DEFAULT NULL COMMENT '描述',
    `logo`        varchar(256) DEFAULT NULL COMMENT '图标',
    `status`      int(1)       DEFAULT '1' COMMENT '状态: 0->禁用, 1->启用',
    CONSTRAINT PK_SUBJECT_CATEGORY PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 37
  DEFAULT CHARSET = utf8 COMMENT ='专题分类表';

-- 专题分类和专题关系表
DROP TABLE IF EXISTS `ret_subject_category_subject_relation`;
CREATE TABLE `ret_subject_category_subject_relation`
(
    `id` bigint(20) AUTO_INCREMENT,
    `subject_id`          bigint(20),
    `subject_category_id` bigint(20),
    PRIMARY KEY (`id`),
    CONSTRAINT FK_SUBJECT_AND_CATEGORY_SUBJECT_ID FOREIGN KEY (`subject_id`) REFERENCES `ret_subject` (`id`),
    CONSTRAINT FK_SUBJECT_AND_CATEGORY_CATEGORY_ID FOREIGN KEY (`subject_category_id`) REFERENCES `ret_subject_category` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='专题专题分类关系表';

-- 帮助表
DROP TABLE IF EXISTS `ret_help`;
CREATE TABLE `ret_help`
(
    `id`          bigint(20)   NOT NULL AUTO_INCREMENT,
    `name`        varchar(100) NOT NULL COMMENT '名称',
    `content`     text         NOT NULL COMMENT '描述',
    `title`       varchar(100) NOT NULL COMMENT '标题',
    `create_time` datetime DEFAULT NOW() COMMENT '创建时间',
    `reading`     bigint(20)   NOT NULL COMMENT '阅读量',
    `sort`        int      DEFAULT '0' COMMENT '排序',
    CONSTRAINT PK_HELP PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 37
  DEFAULT CHARSET = utf8 COMMENT ='帮助表';

-- 帮助分类表
DROP TABLE IF EXISTS `ret_help_category`;
CREATE TABLE `ret_help_category`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT,
    `name`        varchar(100) DEFAULT NULL COMMENt '名称',
    `description` varchar(100) DEFAULT NULL COMMENT '描述',
    `logo`        varchar(256) DEFAULT NULL COMMENT '图标',
    `status`      int(1)       DEFAULT '1' COMMENT '状态: 0->禁用, 1->启用',
    CONSTRAINT PK_HELP_CATEGORY PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='帮助分类表';

-- 专题分类和专题关系表
DROP TABLE IF EXISTS `ret_help_category_help_relation`;
CREATE TABLE `ret_help_category_help_relation`
(
    `id` bigint(20) AUTO_INCREMENT,
    `help_id`          bigint(20),
    `help_category_id` bigint(20),
    PRIMARY KEY (`id`),
    CONSTRAINT FK_HELP_AND_HELP_HELP_ID FOREIGN KEY (`help_id`) REFERENCES `ret_help` (`id`),
    CONSTRAINT FK_HELP_AND_HELP_CATEGORY_ID FOREIGN KEY (`help_category_id`) REFERENCES `ret_help_category` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='帮助和帮助分类关系表';

-- 反馈表
DROP TABLE IF EXISTS `ret_feet_back`;
CREATE TABLE `ret_feet_back`
(
    `id`          bigint(20)   NOT NULL AUTO_INCREMENT,
    `title`       varchar(100) NOT NULL COMMENT '标题',
    `type`        varchar(20)  NOT NULL COMMENT '类型',
    `content`     text         NOT NULL COMMENT '内容',
    `status`      int(1)      DEFAULT '0' COMMENT '状态: 0->未处理, 1->处理中, 2->已处理',
    `create_time` datetime    DEFAULT NOW() COMMENT '创建时间',
    `object`      varchar(20) DEFAULT NULL COMMENT '反馈对象',
    CONSTRAINT PK_FEET_BACK PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='反馈表';

-- 反馈分类表
DROP TABLE IF EXISTS `ret_feet_back_category`;
CREATE TABLE `ret_feet_back_category`
(
    `id`          bigint(20)  NOT NULL AUTO_INCREMENT,
    `name`        varchar(20) NOT NULL COMMENT '名称',
    `description` varchar(100) DEFAULT NULL COMMENT '描述',
    CONSTRAINT PK_FEET_BACK_CATEGORY PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 37
  DEFAULT CHARSET = utf8 COMMENT ='反馈分类表';

-- 反馈和反馈分类关系表
DROP TABLE IF EXISTS `ret_feet_back_category_relation`;
CREATE TABLE `ret_feet_back_category_relation`
(
    `id` bigint(20) AUTO_INCREMENT,
    `feet_back_id`          bigint(20),
    `feet_back_category_id` bigint(20),
    PRIMARY KEY (`id`),
    CONSTRAINT FK_FEET_BACK_AND_CATEGORY_FEET_BACK_ID FOREIGN KEY (`feet_back_id`) REFERENCES `ret_feet_back` (`id`),
    CONSTRAINT FK_FEET_BACK_AND_CATEGORY_CATEGORY_ID FOREIGN KEY (`feet_back_category_id`) REFERENCES `ret_feet_back_category` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='反馈和分类关系表';