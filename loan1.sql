create database loan;
use loan;
create table Customer ( 
customerid int primary key ,
name varchar(100),
emailaddress varchar(100) unique,
phonenumber varchar(20),
address text,
creditscore int );

create table loans (
 loanid int primary key,
 customerid int,
 principalamount decimal(15,2),
 interestrate decimal(5,2),
 loanterm int,
 loantype varchar(50),
 loanstatus varchar(50),
 foreign key (customerid) references customer(customerid));
 
 select * from loan;
 select * from customer;
 