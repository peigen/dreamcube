CREATE TABLE `dreamcube`.`dc_user` (
  `id` BIGINT  NOT NULL AUTO_INCREMENT,
  `logon_name` VARCHAR(100)  CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'Email',
  `logon_passwd` VARCHAR(20)  CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `nick_name` VARCHAR(20)  CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '昵称',
  `birthday` TIMESTAMP  DEFAULT '0000-00-00 00:00:00',
  `cert_no` VARCHAR(20) COMMENT '身份证',
  `gender` int(1),
  `work_site` VARCHAR(2000)  CHARACTER SET utf8 COLLATE utf8_general_ci,
  `projects` VARCHAR(200)  COMMENT '用来保存参与项目id',
  `info_site` VARCHAR(2000)  CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT 'SNS信息:twitter/fackbook',
  `gmt_create` TIMESTAMP  DEFAULT '0000-00-00 00:00:00',
  `gmt_modify` TIMESTAMP  DEFAULT CURRENT_TIMESTAMP,
  `status` VARCHAR(20)  NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `logon_name_UNIQUE` (`logon_name` ASC),
  UNIQUE INDEX `nick_name_UNIQUE` (`nick_name` ASC)
)
ENGINE = InnoDB
CHARACTER SET utf8 COLLATE utf8_general_ci
COMMENT = '用户表';