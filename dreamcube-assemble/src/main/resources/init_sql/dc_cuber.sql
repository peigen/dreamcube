CREATE TABLE `dreamcube`.`dc_cuber` (
  `id` BIGINT  NOT NULL AUTO_INCREMENT,
  `logon_name` VARCHAR(20)  CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `nick_name` VARCHAR(20)  CHARACTER SET utf8 COLLATE utf8_general_ci,
  `email` VARCHAR(100) ,
  `gender` INT  NOT NULL,
  PRIMARY KEY (`id`)
)
ENGINE = InnoDB
CHARACTER SET utf8 COLLATE utf8_general_ci;