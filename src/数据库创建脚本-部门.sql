DROP DATABASE mldn ;
CREATE DATABASE mldn CHARACTER SET UTF8 ;
USE mldn ;
CREATE TABLE dept(
	deptno	INT AUTO_INCREMENT ,
	dname	VARCHAR(32) ,
	CONSTRAINT pk_deptno PRIMARY KEY(deptno)
) engine="innodb";
INSERT INTO dept(dname) VALUES ('技术部') ;
INSERT INTO dept(dname) VALUES ('市场部') ;
INSERT INTO dept(dname) VALUES ('财务部') ;

drop database mldn;
create database mldn character set UTF8;
use mldn;
create table dept(
   deptno int auto_increment,
   dname varchar(32),
   constraint pk_deptno primary key (deptno)
) engine="innodb" ;
insert into dept(dname) values ('技术部');
insert into dept(dname) values('市场部') ;
insert into dept(dname) values('财务部') ;