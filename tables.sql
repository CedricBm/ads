create table users
(
  id serial not null,
  email varchar(255) not null,
  password varchar(255) not null,
  lname varchar(255) not null,
  fname varchar(255) not null,
  primary key (id)
);

create table clubs
(
  id serial not null,
  name varchar(255) not null,
  creation_date date,
  website varchar(255),
  nb_trophies int,
  address varchar(255),
  country varchar(255),
  manager_id int,
  primary key (id),
  foreign key (manager_id) references users(id)
);

create table footballers
(
  id serial not null,
  lname varchar(255) not null,
  fname varchar(255) not null,
  position varchar(255),
  nationality varchar(255),
  size float,
  weigh float,
  nb_goals int,
  nb_games int,
  birthdate date,
  nb_games_international int,
  strong_foot varchar(255),
  club_id int,
  primary key (id),
  foreign key (club_id) references clubs(id)
);

create table ads
(
  id serial not null,
  title varchar(255) not null,
  price float not null,
  description varchar(255) not null,
  buyable boolean not null,
  available_at date not null,
  available boolean not null,
  buyer_id int,
  seller_id int not null,
  footballer_id int not null,
  primary key(id),
  foreign key (buyer_id) references users(id),
  foreign key (seller_id) references users(id),
  foreign key (footballer_id) references footballers(id)
);