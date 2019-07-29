create table driver (
id bigint auto_increment not null,
name varchar(80) not null,
drive_license varchar(10),
rating int,
member_since date,

primary key(id)
);