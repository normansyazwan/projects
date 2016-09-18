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