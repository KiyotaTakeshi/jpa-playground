drop table if exists employee;

-- create table if not exists employee
create table employee
(
    id            integer     not null auto_increment,
    first_name    varchar(20) not null,
    last_name     varchar(20) not null,
    mail_address  varchar(255),
    primary key (id)
);
