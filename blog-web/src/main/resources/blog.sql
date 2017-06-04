CREATE TABLE user(
`id` varchar(32) CHARACTER SET utf8mb4 COMMENT '用户ID',
`username` VARCHAR(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名',
`blog_name` VARCHAR(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '博客名称',
`name` VARCHAR(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '姓名',
`password` VARCHAR(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '密码',
`avatar` VARCHAR(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '头像地址',
`email` VARCHAR(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '邮箱地址',
`weibo` VARCHAR(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '微博',
`github` VARCHAR(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'github地址',
`address` VARCHAR(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '住址',
`phone` VARCHAR(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '手机号',
`discription` VARCHAR(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '描述',
`sex` TINYINT(3) NOT NULL DEFAULT '0' COMMENT '性别	0：男，1：女',
`create_time` BIGINT(20) NOT NULL DEFAULT '0' COMMENT '注册时间',
`last_login_time` BIGINT(20) NOT NULL DEFAULT '0' COMMENT '上次登录时间',
`status` TINYINT(3) NOT NULL DEFAULT '1' COMMENT '状态',
`expansion` VARCHAR(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '扩展字段',
PRIMARY KEY (`id`),
KEY `idx_user_username`(`username`),
KEY `idx_user_email`(`email`),
KEY `idx_user_phone`(`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='user_用户表';


CREATE TABLE article(
`id` varchar(32) CHARACTER SET utf8mb4 COMMENT '博文ID',
`title` VARCHAR(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '标题',
`user_id` VARCHAR(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '作者id',
`username` VARCHAR(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '作者',
`tag` VARCHAR(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '标签',
`url` VARCHAR(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '博文存储url',
`pre_article` VARCHAR(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '博文预览',
`create_time` BIGINT(20) NOT NULL DEFAULT '0' COMMENT '创建时间',
`read_counts` INT NOT NULL DEFAULT '0' COMMENT '阅读数量',
`likes` INT(3) NOT NULL DEFAULT '0' COMMENT '收藏数量',
`comments` INT(3) NOT NULL DEFAULT '0' COMMENT '评论数量',
`status` TINYINT(3) NOT NULL DEFAULT '1' COMMENT '状态',
`expansion` VARCHAR(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '扩展字段',
PRIMARY KEY (`id`),
KEY `idx_article_username`(`username`),
KEY `idx_article_user_id`(`user_id`),
KEY `idx_article_article_name`(`title`),
KEY `idx_article_tag`(`tag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='article_博文表';


CREATE TABLE like(
`id` varchar(32) CHARACTER SET utf8mb4 COMMENT '收藏ID',
`article_id` VARCHAR(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '博文id',
`title` VARCHAR(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '标题',
`username` VARCHAR(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户',
`user_id` VARCHAR(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '用户id',
`author_name` VARCHAR(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '作者',
`author_id` VARCHAR(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '作者id',
`tag` VARCHAR(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '标签',
`url` VARCHAR(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '博文存储url',
`pre_article` VARCHAR(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '博文预览',
`create_time` BIGINT(20) NOT NULL DEFAULT '0' COMMENT '收藏时间',
`article_create_time` BIGINT(20) NOT NULL DEFAULT '0' COMMENT '博文创建时间',
`read_counts` INT NOT NULL DEFAULT '0' COMMENT '阅读数量',
`likes` INT(3) NOT NULL DEFAULT '0' COMMENT '收藏数量',
`comments` INT(3) NOT NULL DEFAULT '0' COMMENT '评论数量',
`status` TINYINT(3) NOT NULL DEFAULT '1' COMMENT '状态',
`expansion` VARCHAR(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '扩展字段',
PRIMARY KEY (`id`),
KEY `idx_likes_username`(`username`),
KEY `idx_likes_user_id`(`user_id`),
KEY `idx_likes_article_author_name`(`author_name`),
KEY `idx_likes_article_title`(`title`),
KEY `idx_likes_article_id`(`article_id`),
KEY `idx_article_tag`(`tag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='likes_收藏表';


CREATE TABLE attention(
`id` varchar(32) CHARACTER SET utf8mb4 COMMENT 'ID',
`username` VARCHAR(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户',
`user_id` VARCHAR(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '用户id',
`author_name` VARCHAR(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '作者',
`author_id` VARCHAR(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '作者id',
`create_time` BIGINT(20) NOT NULL DEFAULT '0' COMMENT '关注时间',
`expansion` VARCHAR(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '扩展字段',
PRIMARY KEY (`id`),
KEY `idx_attentions_username`(`username`),
KEY `idx_attentions_user_id`(`user_id`),
KEY `idx_attentions_author_name`(`author_name`),
KEY `idx_attentions_author_id`(`author_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='attentions_关注表';
