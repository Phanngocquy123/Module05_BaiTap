create database spring_secutiry;
use spring_secutiry;
create table users(	
id varchar(36) primary key,    
username varchar(250) not null unique,    
password varchar(250) not null,    
status bit(1));
select * from users;
-- e25a6d7e-e623-4118-9787-7bd8a33f3a50 admin
-- c1072354-6bdd-4151-a38e-a7127187ff22 member

create table roles(	
id varchar(36) primary key,    
name varchar(250) not null unique);
select * from roles;
insert into roles values
(uuid(), 'ROLE_ADMIN'),
(uuid(), 'ROLE_MEMBER');

-- 335edc7f-f9f9-11ee-94b2-847beb137679  ROLE_ADMIN
-- 336281f5-f9f9-11ee-94b2-847beb137679  ROLE_MEMBER

create table user_role(	
userId varchar(36) not null,    
roleId varchar(36) not null,    
primary key(userId, roleId),    
foreign key(userId) references users(id),    
foreign key(roleId) references roles(id));
select * from user_role;
insert into user_role values 
('e25a6d7e-e623-4118-9787-7bd8a33f3a50', '335edc7f-f9f9-11ee-94b2-847beb137679'),
('c1072354-6bdd-4151-a38e-a7127187ff22', '336281f5-f9f9-11ee-94b2-847beb137679')
;
