-- create schema gang;
use gang;

-- Drop tables 
drop table if exists gangsters;
drop table if exists authorities;
drop table if exists users;

create table groups(
	group_id long,
    group_name varchar(200),
    created_date date,
    group_owner varchar(80),
    constraint fk_groups_users foreign key(group_owner) references users(username)
);

create table users(
	username varchar(80) not null primary key,
	password varchar(50) not null,
	enabled boolean not null,
    first_name varchar(100),
    last_name varchar(100),
    display_name varchar(100),
    date_of_birth date,
    mobile varchar(10)
);

create table authorities (
	username varchar(80) not null,
	authority varchar(50) not null,
	constraint fk_authorities_users foreign key(username) references users(username)
);
create unique index ix_auth_username on authorities (username,authority);


