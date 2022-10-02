show databases ;
create database MGNREGA ; 
use MGNREGA ;

create table BackendDev (
	username varchar(20),
    password varchar(20)
);

create table Projects (

ProjectNo int primary key auto_increment ,
PName varchar(20) ,
Location varchar(20)
);

create table GramPanchayatMember (

ID int primary key auto_increment ,
GName varchar(20) not null ,
Location varchar(20) not null ,
username varchar(20) not null unique ,
password varchar(20) not null 
);

create table p_g (

pid int not null ,
gid int not null, 
foreign key (pid) references Projects(ProjectNO) ,
foreign key (gid) references GramPanchayatMember(ID)

);

create table employee (
EmpId int primary key auto_increment ,
EmpName varchar(20) not null,
EmpGender varchar(1) not null,
EmpWage int not null,
EmpDutyDay int not null,
ProjAssigned int references Projects(ProjectNo),
GPOAssigned int  references GramPanchayatMember(ID) 
);








