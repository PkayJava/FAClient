DROP TABLE IF EXISTS `request`;

CREATE TABLE `request` (

  `request_id`            VARCHAR(100) NOT NULL,
  `title`                 VARCHAR(255) NOT NULL,
  `created_on`            DATE         NOT NULL,
  `device_id`             VARCHAR(255) NOT NULL,
  `maximum_file_quantity` INT(2)       NOT NULL,
  `maximum_file_size`     INT(11)      NOT NULL,
  `uploaded_file`         INT(2)       NOT NULL,
  `expired_on`            DATE,
  `version`               INT(11)      NOT NULL,

  PRIMARY KEY (`request_id`)
);

CREATE INDEX `title_001`
  ON `request` (`title`);
CREATE INDEX `title_002`
  ON `request` (`created_on`);
CREATE INDEX `title_003`
  ON `request` (`device_id`);
CREATE INDEX `title_004`
  ON `request` (`maximum_file_quantity`);
CREATE INDEX `title_005`
  ON `request` (`maximum_file_size`);
CREATE INDEX `title_006`
  ON `request` (`expired_on`);
CREATE INDEX `title_007`
  ON `request` (`uploaded_file`);

DELIMITER $$
CREATE TRIGGER `request_b_i`
BEFORE INSERT ON `request`
FOR EACH ROW
  BEGIN
    SET NEW.version = 1;
  END;

CREATE TRIGGER `request_b_u`
BEFORE UPDATE ON `request`
FOR EACH ROW
  BEGIN
    IF NEW.version IS NULL
    THEN
      SIGNAL SQLSTATE '99999'
      SET MESSAGE_TEXT = 'version is required', MYSQL_ERRNO = 1000;
    ELSEIF OLD.version != NEW.version
      THEN
        SIGNAL SQLSTATE '99999'
        SET MESSAGE_TEXT = 'record out of date', MYSQL_ERRNO = 1000;
    END IF;
    SET NEW.version = NEW.version + 1;
  END;

DELIMITER ;

DROP TABLE IF EXISTS `file`;

CREATE TABLE `file` (

  `file_id`         VARCHAR(100) NOT NULL,
  `request_id`      VARCHAR(255) NOT NULL,
  `created_on`      DATETIME     NOT NULL,
  `size`            INT(11)      NOT NULL,
  `path`            VARCHAR(255) NOT NULL,
  `server_filename` VARCHAR(255) NOT NULL,
  `client_filename` VARCHAR(255) NOT NULL,
  `version`         INT(11)      NOT NULL,

  PRIMARY KEY (`file_id`)
);

CREATE INDEX `file_001`
  ON `file` (`request_id`);
CREATE INDEX `file_002`
  ON `file` (`created_on`);
CREATE INDEX `file_003`
  ON `file` (`size`);
CREATE INDEX `file_004`
  ON `file` (`path`);
CREATE INDEX `file_005`
  ON `file` (`server_filename`);
CREATE INDEX `file_006`
  ON `file` (`client_filename`);
CREATE INDEX `file_007`
  ON `file` (`version`);

DELIMITER $$
CREATE TRIGGER `file_b_i`
BEFORE INSERT ON `file`
FOR EACH ROW
  BEGIN
    SET NEW.version = 1;
  END;

CREATE TRIGGER `file_b_u`
BEFORE UPDATE ON `file`
FOR EACH ROW
  BEGIN
    IF NEW.version IS NULL
    THEN
      SIGNAL SQLSTATE '99999'
      SET MESSAGE_TEXT = 'version is required', MYSQL_ERRNO = 1000;
    ELSEIF OLD.version != NEW.version
      THEN
        SIGNAL SQLSTATE '99999'
        SET MESSAGE_TEXT = 'record out of date', MYSQL_ERRNO = 1000;
    END IF;
    SET NEW.version = NEW.version + 1;
  END;

DELIMITER ;

DROP TABLE IF EXISTS `device`;

CREATE TABLE `device` (

  `device_id` VARCHAR(100) NOT NULL,
  `uuid`      VARCHAR(255) NOT NULL,
  `platform`  VARCHAR(50)  NOT NULL,
  `token`     VARCHAR(255) NOT NULL,
  `version`   INT(11)      NOT NULL,

  PRIMARY KEY (`device_id`)
);

CREATE UNIQUE INDEX `device_001`
  ON `device` (`platform`, `uuid`);
CREATE UNIQUE INDEX `device_002`
  ON `device` (`platform`, `token`);
CREATE UNIQUE INDEX `device_003`
  ON `device` (`version`);

DELIMITER $$
CREATE TRIGGER `device_b_i`
BEFORE INSERT ON `device`
FOR EACH ROW
  BEGIN
    SET NEW.version = 1;
  END;

CREATE TRIGGER `device_b_u`
BEFORE UPDATE ON `device`
FOR EACH ROW
  BEGIN
    IF NEW.version IS NULL
    THEN
      SIGNAL SQLSTATE '99999'
      SET MESSAGE_TEXT = 'version is required', MYSQL_ERRNO = 1000;
    ELSEIF OLD.version != NEW.version
      THEN
        SIGNAL SQLSTATE '99999'
        SET MESSAGE_TEXT = 'record out of date', MYSQL_ERRNO = 1000;
    END IF;
    SET NEW.version = NEW.version + 1;
  END;

DELIMITER ;