create table `PERSON_INFO`(
    `PERSON_INFO_ID` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `USER_ID` BIGINT(20) NOT NULL,
    `WEIGHT` int(10) DEFAULT 0,
    `SIT_UP` int(10) DEFAULT 0,
    `PUSH_UP` int(10) DEFAULT 0,
    `SQUAD` int(10) DEFAULT 0,
    `TIMESTAMP` datetime NOT NULL,
    PRIMARY KEY (`PERSON_INFO_ID`)
) ENGINE = INNODB DEFAULT CHARSET = utf8;

create table `USER` (
    `USER_ID` bigint(20) NOT NULL AUTO_INCREMENT,
    `USER_NAME` varchar(50) NOT NULL UNIQUE,
    `USER_PASSWORD` varchar(50) NOT NULL,
    PRIMARY KEY (`USER_ID`)
) ENGINE = INNODB DEFAULT CHARSET = utf8;
