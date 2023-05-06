

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
