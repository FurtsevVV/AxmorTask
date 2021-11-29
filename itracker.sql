-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema issue_tracker
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `issue_tracker` ;

CREATE SCHEMA IF NOT EXISTS `issue_tracker` DEFAULT CHARACTER SET utf8 ;
USE `issue_tracker` ;

DROP TABLE IF EXISTS `issue_tracker`.`comments` ;

CREATE TABLE IF NOT EXISTS `issue_tracker`.`comments` (
  `comment_id` INT(11) NOT NULL AUTO_INCREMENT,
  `comment_author` VARCHAR(100) NOT NULL,
  `date_of_comment` DATETIME NOT NULL,
  `status_of_comment` VARCHAR(30) NOT NULL,
  `comment` VARCHAR(100) NOT NULL,
  `issue_id` INT(11) NOT NULL,
  PRIMARY KEY (`comment_id`),
  CONSTRAINT `comment_ibfk_1`
    FOREIGN KEY (`issue_id`)
    REFERENCES `issue_tracker`.`trackerdb` (`issue_id`)
  )
ENGINE = InnoDB
AUTO_INCREMENT = 15
DEFAULT CHARACTER SET = utf8;




-- -----------------------------------------------------
-- Table `issue_tracker`.`trackerdb`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `issue_tracker`.`trackerdb` ;

CREATE TABLE IF NOT EXISTS `issue_tracker`.`trackerdb` (
  `issue_id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(250) NOT NULL,
  `author` VARCHAR(50) NOT NULL,
  `status` VARCHAR(30) NOT NULL,
  `date_of_create` DATETIME NOT NULL,
  `description` TEXT NULL DEFAULT NULL,
    PRIMARY KEY (`issue_id`)
  )
ENGINE = InnoDB
AUTO_INCREMENT = 17
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
