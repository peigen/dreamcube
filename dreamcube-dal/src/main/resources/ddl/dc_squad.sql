CREATE TABLE `dreamcube`.`dc_squad` (
  `id` BIGINT  NOT NULL AUTO_INCREMENT,
  `squad_name` VARCHAR(40)  CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `squad_desc` VARCHAR(4000)  CHARACTER SET utf8 COLLATE utf8_general_ci,
  `axiser` VARCHAR(10)  NOT NULL COMMENT 'User ID',
  `cubers` VARCHAR(1000)  COMMENT 'user id json格式',
  `followers` VARCHAR(4000) ,
  `investors` VARCHAR(400) ,
  `status` VARCHAR(20)  NOT NULL,
  `gmt_create` TIMESTAMP  DEFAULT '0000-00-00 00:00:00',
  `gmt_modify` TIMESTAMP  DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
)
ENGINE = InnoDB
CHARACTER SET utf8 COLLATE utf8_general_ci;


--初始化
drop table dc_squad;

--数据
INSERT INTO dc_squad 
(squad_name,squad_desc,axiser,status,gmt_create,gmt_modify)
VALUES('dreamcube_1','描述','peigen','DEV',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);

INSERT INTO dc_squad 
(squad_name,squad_desc,axiser,status,gmt_create,gmt_modify)
VALUES('dreamcube_2','描述','peigen','DEV',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);

INSERT INTO dc_squad 
(squad_name,squad_desc,axiser,status,gmt_create,gmt_modify)
VALUES('dreamcube_3','描述','peigen','DEV',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);

INSERT INTO dc_squad 
(squad_name,squad_desc,axiser,status,gmt_create,gmt_modify)
VALUES('dreamcube_4','描述','peigen','DEV',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);

INSERT INTO dc_squad 
(squad_name,squad_desc,axiser,status,gmt_create,gmt_modify)
VALUES('dreamcube_5','描述','peigen','DEV',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);

INSERT INTO dc_squad 
(squad_name,squad_desc,axiser,status,gmt_create,gmt_modify)
VALUES('dreamcube_6','描述','peigen','DEV',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);

INSERT INTO dc_squad 
(squad_name,squad_desc,axiser,status,gmt_create,gmt_modify)
VALUES('dreamcube_7','描述','peigen','DEV',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);

INSERT INTO dc_squad 
(squad_name,squad_desc,axiser,status,gmt_create,gmt_modify)
VALUES('dreamcube_8','描述','peigen','DEV',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);

INSERT INTO dc_squad 
(squad_name,squad_desc,axiser,status,gmt_create,gmt_modify)
VALUES('dreamcube_9','描述','peigen','DEV',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);

INSERT INTO dc_squad 
(squad_name,squad_desc,axiser,status,gmt_create,gmt_modify)
VALUES('dreamcube_10','描述','peigen','DEV',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);

INSERT INTO dc_squad 
(squad_name,squad_desc,axiser,status,gmt_create,gmt_modify)
VALUES('dreamcube_11','描述','peigen','DEV',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);

INSERT INTO dc_squad 
(squad_name,squad_desc,axiser,status,gmt_create,gmt_modify)
VALUES('dreamcube_12','描述','peigen','DEV',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);

INSERT INTO dc_squad 
(squad_name,squad_desc,axiser,status,gmt_create,gmt_modify)
VALUES('dreamcube_13','描述','peigen','DEV',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);

INSERT INTO dc_squad 
(squad_name,squad_desc,axiser,status,gmt_create,gmt_modify)
VALUES('dreamcube_14','描述','peigen','DEV',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);

INSERT INTO dc_squad 
(squad_name,squad_desc,axiser,status,gmt_create,gmt_modify)
VALUES('dreamcube_15','描述','peigen','DEV',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);

