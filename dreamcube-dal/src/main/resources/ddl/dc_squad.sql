-- 初始化
drop table dc_squad;

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
  `attention` BIGINT NOT NULL DEFAULT 0 COMMENT '团队被关注次数',
  PRIMARY KEY (`id`)
)
ENGINE = InnoDB
CHARACTER SET utf8 COLLATE utf8_general_ci;


--  数据准备

truncate table `dreamcube`.`dc_squad`;

INSERT INTO dc_squad 
(squad_name,squad_desc,axiser,status,gmt_create,gmt_modify,attention)
VALUES('dreamcube_1','描述','peigen','DEV',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,10);

INSERT INTO dc_squad 
(squad_name,squad_desc,axiser,status,gmt_create,gmt_modify,attention)
VALUES('dreamcube_2','描述','peigen','DEV',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,20);

INSERT INTO dc_squad 
(squad_name,squad_desc,axiser,status,gmt_create,gmt_modify,attention)
VALUES('dreamcube_3','描述','peigen','DEV',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,30);

INSERT INTO dc_squad 
(squad_name,squad_desc,axiser,status,gmt_create,gmt_modify,attention)
VALUES('dreamcube_4','描述','peigen','DEV',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,40);

INSERT INTO dc_squad 
(squad_name,squad_desc,axiser,status,gmt_create,gmt_modify,attention)
VALUES('dreamcube_5','描述','peigen','DEV',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,50);

INSERT INTO dc_squad 
(squad_name,squad_desc,axiser,status,gmt_create,gmt_modify,attention)
VALUES('dreamcube_6','描述','peigen','DEV',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,0);

INSERT INTO dc_squad 
(squad_name,squad_desc,axiser,status,gmt_create,gmt_modify,attention)
VALUES('dreamcube_7','描述','peigen','DEV',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,0);

INSERT INTO dc_squad 
(squad_name,squad_desc,axiser,status,gmt_create,gmt_modify,attention)
VALUES('dreamcube_8','描述','peigen','DEV',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,0);

INSERT INTO dc_squad 
(squad_name,squad_desc,axiser,status,gmt_create,gmt_modify,attention)
VALUES('dreamcube_9','描述','peigen','DEV',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,0);

INSERT INTO dc_squad 
(squad_name,squad_desc,axiser,status,gmt_create,gmt_modify,attention)
VALUES('dreamcube_10','描述','peigen','DEV',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,0);

INSERT INTO dc_squad 
(squad_name,squad_desc,axiser,status,gmt_create,gmt_modify,attention)
VALUES('dreamcube_11','描述','peigen','DEV',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,0);

INSERT INTO dc_squad 
(squad_name,squad_desc,axiser,status,gmt_create,gmt_modify,attention)
VALUES('dreamcube_12','描述','peigen','DEV',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,0);

INSERT INTO dc_squad 
(squad_name,squad_desc,axiser,status,gmt_create,gmt_modify,attention)
VALUES('dreamcube_13','描述','peigen','DEV',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,0);

INSERT INTO dc_squad 
(squad_name,squad_desc,axiser,status,gmt_create,gmt_modify,attention)
VALUES('dreamcube_14','描述','peigen','DEV',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,0);

INSERT INTO dc_squad 
(squad_name,squad_desc,axiser,status,gmt_create,gmt_modify,attention)
VALUES('dreamcube_15','描述','peigen','DEV',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,0);

