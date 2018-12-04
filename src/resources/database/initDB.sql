use userdb;

create table users
(
id int not null AUTO_INCREMENT,
name varchar(20),
age int,
primary key(id)
);

insert into users
values(null, 'dima', 33),
(null, 'vasya', 21),
(null, 'petya', 80),
(null, 'leha', 20),
(null, 'roma', 19);

insert into users
values(null, 'test', 55);

select * from users;


create table cars (
id int not null AUTO_INCREMENT,
model varchar(20),
country varchar(20),
type varchar(20),
primary key(id),
user_id int not null,
foreign key (user_id) references users(id)
);

drop table cars;

select * from cars;

insert into cars
values(1, 'Tesla Model X', 'USA', 'sedan', 7);

insert into cars
values(null, 'Opel Astra H', 'Germany', 'sedan', 23);

create table cars_info (
id int not null,
vin int not null,
color varchar(20),
primary key(id),
foreign key (id) references cars(id)
);

drop table cars_info;

select * from cars_info;

insert into cars_info
values(1, 123, 'red'),
(4, 321, 'purple');

create table user_info (
id int not null,
drive_lic int not null,
drive_year int, 
primary key(id),
foreign key (id) references users(id)
);

select * from user_info;

insert into user_info
values(7, 987, 2),
(20, 324, 1);