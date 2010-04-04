CREATE TABLE `dreamcube`.`dc_squad` (
  `id` BIGINT  NOT NULL AUTO_INCREMENT,
  `squad_name` VARCHAR(40)  CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `squad_desc` VARCHAR(4000)  CHARACTER SET utf8 COLLATE utf8_general_ci,
  `axiser` VARCHAR(10)  NOT NULL COMMENT 'User ID',
  `cubers` VARCHAR(1000)  COMMENT 'user id json格式',
  `followers` VARCHAR(4000) ,
  `investors` VARCHAR(400) ,
  `status` VARCHAR(20)  NOT NULL,
  `gmt_create` DATE  NOT NULL,
  `gmt_modify` DATE  NOT NULL,
  PRIMARY KEY (`id`)
)
ENGINE = InnoDB
CHARACTER SET utf8 COLLATE utf8_general_ci;
