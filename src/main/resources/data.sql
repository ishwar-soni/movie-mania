delete from Movie_Order_Movies;
delete from Movie_Ingredients;
delete from Movie;
delete from Movie_Order;
delete from Ingredient;

insert into Ingredient (id, name, type) values ('GEHR', 'Horrer', 'GENRE');
insert into Ingredient (id, name, type) values ('GECO', 'Comedy', 'GENRE');
insert into Ingredient (id, name, type) values ('GETH', 'Thriller', 'GENRE');
insert into Ingredient (id, name, type) values ('ACSH', 'Shahrukh Khan', 'ACTOR');
insert into Ingredient (id, name, type) values ('ACSL', 'Salman Khan', 'ACTOR');
insert into Ingredient (id, name, type) values ('ACAM', 'Amir Khan', 'ACTOR');
insert into Ingredient (id, name, type) values ('LNEN', 'English', 'LANGUAGE');
insert into Ingredient (id, name, type) values ('LNHI', 'Hindi', 'LANGUAGE');
insert into Ingredient (id, name, type) values ('YE20', '2020', 'YEAR');
insert into Ingredient (id, name, type) values ('YE19', '2019', 'YEAR');
insert into Ingredient (id, name, type) values ('YE18', '2018', 'YEAR');
insert into Ingredient (id, name, type) values ('IDHO', 'Hollywood', 'INDUSTRY');
insert into Ingredient (id, name, type) values ('IDBO', 'Bollywood', 'INDUSTRY');
insert into Ingredient (id, name, type) values ('IDTO', 'Tollywood', 'INDUSTRY');