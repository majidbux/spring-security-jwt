create table users
(
	id bigserial constraint customers_pk primary key,
	user_name varchar(255) not null,
	password varchar(255) not null
);

insert into users (id, user_name, password) values
                      (1, 'testUser', 'root');
