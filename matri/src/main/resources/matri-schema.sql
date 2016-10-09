use matri;

CREATE TABLE USERS (
USERNAME VARCHAR(10) NOT NULL,
PASSWORD VARCHAR(32) NOT NULL,
ENABLED SMALLINT,
PRIMARY KEY (USERNAME)
);

CREATE TABLE authorities (
USERNAME VARCHAR(10) NOT NULL,
AUTHORITY VARCHAR(10) NOT NULL,
FOREIGN KEY (USERNAME) REFERENCES USERS(USERNAME) 
);

insert into users(username, password,enabled) values('bharat','pass',1);
insert into authorities(username,authority) values('bharat','ROLE_ADMIN');
insert into authorities(username,authority) values('bharat','ROLE_USER');

delete from authorities where username != 'a';

DROP TABLE PROFILE;

create table PROFILES(
	PROFILE_ID INT PRIMARY KEY AUTO_INCREMENT,
    FIRST_NAME VARCHAR(100),
    MIDDLE_NAME VARCHAR(100),
    LAST_NAME VARCHAR(100),
    DATE_OF_BIRTH DATETIME,
    GENDER VARCHAR(6), 
    MARITAL_STATUS VARCHAR(20),
	HAVE_CHILDREN VARCHAR(50),
    MOTHER_TONGUE VARCHAR(100),
    RELIGION VARCHAR(100),
    CASTE VARCHAR(100)
);