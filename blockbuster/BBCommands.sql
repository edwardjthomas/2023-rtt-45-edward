insert into user (first_name, last_name, email, password, create_date)
values ("My", "Guy", "timbs@himberland.s", "passywassy", CURRENT_TIME());

insert into user (first_name, last_name, email, password, create_date)
values ("YES", "KILL", "steveharvey@family.feud", "opossum", CURRENT_TIME());

insert into movie (name, year_released, rating, rental_price, late_fee)
values ("Boovie", 6969, "SICK", 10.00, 5.55);

insert into movie (name, year_released, rating, rental_price, late_fee)
values ("i'm here", 1234, "TAME", 20.00, 5.55);

delete from user where id = 1;

select * from user;

select * from movie;

select * from movie_rental;