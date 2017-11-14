--Table users
create table users(
id serial primary key,
username varchar (100) not null,
login varchar (100) not null,
password varchar (100) not null
);

 --table: links
create table links(
id serial primary key,
url varchar (255) not null,
shortUrl varchar (100) not null ,
description varchar (255) not null
);

--table: tags
create table tags(
id serial primary key,
title varchar (100) not null
);

--table: roles
create table roles(
id serial primary key,
  -- todo enum
role varchar (100) not null
);

--table for mapping users' roles: users_roles
create table users_roles(
user_id int not null ,
role_id int not null,

foreign key (user_id) references users(id),
foreign key (role_id) references roles(id),

unique (user_id, role_id)
);

--table for mapping users' links: users_links
create table users_links(
user_id int not null ,
link_id int not null,

foreign key (user_id) references users(id),
foreign key (link_id) references links(id)
);

--table for mapping tags which belong for each link
create table links_tags(
link_id int not null ,
tag_id int not null,

foreign key (link_id) references links(id),
foreign key (tag_id) references tags(id)
);

--table for mapping amount of overcoming for each tag
create table statistics(
link_id int not null ,
amount int not null,

foreign key (link_id) references links(id)
);

-- insert data
insert into roles values
(1, 'ADMIN'),
(2, 'USER');

insert into users(username, login, password) values
('Aliaksei Shvants', 'admin', 'admin'),
('Hanna Baushevich', 'ane4ka', '24');

insert into users_roles values
(1, 1),
(2,2);
