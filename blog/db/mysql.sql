

CREATE TABLE `tb_informal_essay` (
                                     `info_id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                     `text` VARCHAR(1000),
                                     `source` VARCHAR(16),
                                     `create_time` LONG,
                                     `update_time` LONG
);



CREATE TABLE `tb_user` (
                           `uid` VARCHAR(32) NOT NULL PRIMARY KEY,
                           `username` VARCHAR(32),
                           `email` VARCHAR(128),
                           `blog_url` VARCHAR(128),
                           `avatar` VARCHAR(128)
);



CREATE TABLE `tb_photos` (
                             `photo_id` VARCHAR(32) NOT NULL PRIMARY KEY,
                             `src` VARCHAR(128),
                             `blank_src` VARCHAR(128),
                             `create_time` LONG,
                             `update_time` LONG,
                             `shot_time` LONG,
                             `desc` VARCHAR(20)
);

CREATE TABLE `tb_essay_source` (
                                   `essay_source_id` VARCHAR(32) NOT NULL PRIMARY KEY,
                                   `source` VARCHAR(16),
                                   `create_time` LONG,
                                   `update_time` LONG
);

CREATE TABLE `tb_label` (
                            `label_id` VARCHAR(32) NOT NULL PRIMARY KEY,
                            `label` VARCHAR(16),
                            `create_time` LONG,
                            `update_time` LONG
);

DROP TABLE   IF EXISTS `tb_article`;


CREATE TABLE `tb_article` (
                              `article_id` VARCHAR(32) NOT NULL PRIMARY KEY,
                              `article_cover` VARCHAR(64), -- 封面
                              `title` VARCHAR(64), -- 标题
                              `profile` VARCHAR(255), -- 简介
                              `comments_count` int, -- 评论数量
                              `views_count` int, -- 浏览量
                              `content`  VARCHAR(10800), -- 内容
                              `label_id`  VARCHAR(32),
                              `label_ids`  VARCHAR(100),
                              `create_time` LONG, -- 创建时间
                              `update_time` LONG -- 修改时间
);
CREATE TABLE `tb_pages` (
                              `page_id` VARCHAR(32) NOT NULL PRIMARY KEY,
                              `path` VARCHAR(128), -- 页面路径
                              `name` VARCHAR(64), -- 页面名称
                              `comments_count` int, -- 评论数量
                              `views_count` int, -- 浏览量
                              `create_time` LONG, -- 创建时间
                              `update_time` LONG -- 修改时间
);
