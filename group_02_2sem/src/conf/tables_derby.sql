drop table projects;
drop table partners;
drop table users;

drop sequence seq_id_partner RESTRICT;
drop sequence seq_id_project RESTRICT;

CREATE sequence seq_id_project as bigint;
create sequence seq_id_partner as bigint;

create table users
(
userName varchar(30) primary key,
password varchar(200) not null,
partnerOrDell int
);

create table partners
(
partnerId int primary key,
partnerName varchar(30) not null,
country varchar(30) not null,
userName varchar(30) not null references users(userName)
);

create table projects
(
projectId int not null,
startDate date not null,
projectName varchar(30) not null,
cost int not null,
status varchar(30) not null,
description varchar(250) not null,
goal varchar(250) not null,
partnerId int not null,
primary key(projectId),
foreign Key(partnerId) references partners(partnerId)
);

