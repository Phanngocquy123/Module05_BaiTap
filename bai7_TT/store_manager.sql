create database store_manager;
use store_manager;
drop table if exists products;
create table products(
	Product_Id char(5) primary key,
	Product_Name varchar(150) not null unique,
    Manufacturer varchar(200) not null,
    Created datetime default current_timestamp,
    Batch smallint not null,
    Quantity int not null default 0,
    Product_Status bit default 1
);
insert into products (Product_Id, Product_Name, Manufacturer, Batch, Product_Status) values
    ('P001', 'Product 1', 'Manufacturer A', 100, 1),
    ('P002', 'Product 2', 'Manufacturer B', 150, 1),
    ('P003', 'Product 3', 'Manufacturer C', 200, 1)
;
select * from products;

drop table if exists employees;
create table employees(
	Emp_Id char(5) primary key,
    Emp_Name varchar(100) not null,
    Birth_Of_Date date,
    Email varchar(100) not null unique,
    Phone varchar(100) not null,
    Address text not null,
    Emp_Status smallint not null
);
insert into employees (Emp_Id, Emp_Name, Birth_Of_Date, Email, Phone, Address, Emp_Status) values
('EMP01', 'John Doe', '1990-05-15', 'john@example.com', '123456789', '123 Main St, City', 1),
('EMP02', 'Jane Smith', '1992-08-25', 'jane@example.com', '987654321', '456 Elm St, Town', 1),
('EMP03', 'Alice Johnson', '1988-03-10', 'alice@example.com', '555555555', '789 Oak St, Village', 1)
;

drop table if exists accounts;
create table accounts(
	Acc_Id int primary key auto_increment,
    User_Name varchar(30) not null unique,
    Password varchar(30) not null,
    Permission bit default 1,
    Emp_Id char(5) not null unique,
    Acc_Status bit default 1
);


drop table if exists bills;
create table bills(
    Bill_Id bigint primary key  auto_increment,
    Bill_Code varchar(10) not null ,
    Bill_Type bit not null ,
    Emp_Id_Created char(5) not null ,
    Created datetime default current_timestamp,
    Emp_Id_Auth char(5) not null ,
    Auth_Date datetime default current_timestamp,
    Bill_Status smallint not null default 0,
    CONSTRAINT FK_Employees1 FOREIGN KEY (Emp_Id_Created)
    REFERENCES employees(Emp_Id),
    CONSTRAINT FK_Employees2 FOREIGN KEY (Emp_Id_Auth)
    REFERENCES employees(Emp_Id)
);
select * from bills;


drop table if exists bill_details;
create table bill_details(
    Bill_Detail_Id bigint primary key auto_increment,
    Bill_Id bigint not null ,
    Product_Id char(5) not null ,
    Quantity int not null check ( Quantity > 0 ),
    Price float not null check ( Price > 0 ),
    CONSTRAINT FK_Products FOREIGN KEY (Product_Id)
        REFERENCES products(Product_Id),
    CONSTRAINT FK_Bills FOREIGN KEY (Bill_Id)
        REFERENCES bills(Bill_Id)
);
select * from bill_details;
--
create table users(	
id varchar(36) primary key,    
username varchar(250) not null unique,    
password varchar(250) not null,    
status bit(1)
);
select * from users;
-- 2f47a700-ec75-42dd-8312-d4ad69370afb      approve
-- 1adeb401-12fa-4ef5-b277-be043a2aaf4c    create

create table roles(	
id varchar(36) primary key,    
name varchar(250) not null unique
);
select * from roles;
insert into roles values
(uuid(), 'ROLE_CREATE'),
(uuid(), 'ROLE_APPROVE');
-- 3341abed-fbee-11ee-a9c5-847beb137679   role_approve
-- 3340d0ea-fbee-11ee-a9c5-847beb137679   role_create

create table user_role(	
userId varchar(36) not null,    
roleId varchar(36) not null,    
primary key(userId, roleId),    
foreign key(userId) references users(id),    
foreign key(roleId) references roles(id)
);
select * from user_role;
insert into user_role values 
('2f47a700-ec75-42dd-8312-d4ad69370afb', '3341abed-fbee-11ee-a9c5-847beb137679'),
('1adeb401-12fa-4ef5-b277-be043a2aaf4c','3340d0ea-fbee-11ee-a9c5-847beb137679')
;

select u.id as user_id,
    u.username as username,
    r.id as role_id,
    r.name as role_name
from users u
inner join user_role ur on u.id = ur.userId
inner join roles r on ur.roleId = r.id
;
