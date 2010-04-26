CREATE TABLE `dreamcube`.`dc_user` (
  `id` BIGINT  NOT NULL AUTO_INCREMENT,
  `logon_name` VARCHAR(20)  CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `logon_passwd` VARCHAR(20)  CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `nick_name` VARCHAR(20)  CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '昵称',
  `birthday` DATE  NOT NULL,
  `cert_no` VARCHAR(20) COMMENT '身份证',
  `gender` int(1)  NOT NULL,
  `work_site` VARCHAR(2000)  CHARACTER SET utf8 COLLATE utf8_general_ci,
  `projects` VARCHAR(200)  COMMENT '用来保存参与项目id',
  `info_site` VARCHAR(2000)  CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT 'SNS信息:twitter/fackbook',
  `gmt_create` DATE  NOT NULL,
  `gmt_modify` DATE  NOT NULL,
  `status` VARCHAR(20)  NOT NULL,
  PRIMARY KEY (`id`)
)
ENGINE = InnoDB
CHARACTER SET utf8 COLLATE utf8_general_ci
COMMENT = '用户表';
