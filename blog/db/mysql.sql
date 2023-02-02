
DROP TABLE IF EXISTS tb_informal_essay;

CREATE TABLE `tb_informal_essay` (
                                     `info_id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                     `text` VARCHAR(1000),
                                     `source` VARCHAR(16),
                                     `create_time` LONG,
                                     `update_time` LONG
);

INSERT INTO  tb_informal_essay(`text`,`source`,`create_time`,`update_time`) VALUES
('最近睡的晚，食三餐，睡五个小时的觉，听楼下的蛐蛐儿叫，原来志摩的诗里，夏虫永不沉默。','生活',1655496000000,1655496000000),
('你呀一定要学会耐住所有寂寞，然后惊艳所有人','生活',1655496000000,1655496000000);


