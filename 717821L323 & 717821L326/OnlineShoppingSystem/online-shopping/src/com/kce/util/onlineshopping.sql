create database onlineshop;

create table custinfo ( CustId int not null, Name varchar(20) not null, Age int not null, Email varchar(30) not null, Address varchar(30) not null, ContactNumber varchar(11) not null, primary key(CustID) );

Create table logininfo ( userID int not null, password varchar(20) not null, userType char not null, primary key(userID) );

create table products (  productID int not null, Name varchar(20) not null, Type varchar(20) not null, Quantity int not null, Price float not null, primary key(productID) );

create table bills ( bill_id int not null, cust_name varchar(20) not null, bill_addr varchar(30) not null, total_amt float not null, primary key(bill_id) );

insert into products(productID,Name,Type,Quantity,Price) values (1,'phone','electroincs','10','10000.00');
insert into products(productID,Name,Type,Quantity,Price) values (2,'ipod','electroincs','10','20000.00');
insert into products(productID,Name,Type,Quantity,Price) values (3,'tv','electroincs','10','30000.00');
insert into products(productID,Name,Type,Quantity,Price) values (4,'ipad','electroincs','10','5000.00');
insert into products(productID,Name,Type,Quantity,Price) values (5,'Poweder','cosmetic','10','100.00');
insert into products(productID,Name,Type,Quantity,Price) values (6,'soap','cosmetic','10','10.00');