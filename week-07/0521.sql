
create table if not exists movie (
mID INT,
title VARCHAR(50) not null,
year INT not null,
director varchar(30) not null,
primary key (mID)
);

create table if not exists reviewer (
rID int not null auto_increment,
primary key (rID),
name varchar(30) not null
);

create table if not exists rating (
mID int not null,
stars smallint not null,
ratingDate int not null,
FOREIGN KEY (rID) REFERENCES reviewer(rID)
);
 
insert into rating 
values (202, 104, 4, 1999),
(203, 105, 2, 2002),
(204, 101, 3, 2006);
SELECT * from rating;