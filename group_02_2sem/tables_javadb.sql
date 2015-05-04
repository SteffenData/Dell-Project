drop table projects;
drop table partners;
drop table users;



drop sequence seq_id_partner RESTRICT;
drop sequence seq_id_project RESTRICT;


CREATE sequence seg_id_project;
{
  AS BIGINT  
  START WITH signedInteger 
  INCREMENT BY signedInteger 
  MAXVALUE signedInteger NO MAXVALUE 
  MINVALUE signedInteger NO MINVALUE 
  CYCLE | NO CYCLE 
}

create sequence seg_id_partner;
{
  AS BIGINT
  START WITH signedInteger 
  INCREMENT BY signedInteger 
  MAXVALUE signedInteger NO MAXVALUE 
  MINVALUE signedInteger NO MINVALUE 
  CYCLE | NO CYCLE 
}

create table users
(
userName varchar(30) primary key,
password varchar(200) not null,
partnerOrDell int(2)
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
projectId int (20) not null,
startDate date not null,
projectName varchar(30) not null,
cost int (10,2) not null,
status varchar(30) not null,
description varchar(250) not null,
goal varchar(250) not null,
partnerId int (20) not null,
primary key(projectId),
foreign Key(partnerId) references partners(partnerId)
);
