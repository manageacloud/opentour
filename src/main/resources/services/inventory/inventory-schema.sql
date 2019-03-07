-- CREATE EXTENSION IF NOT EXISTS pgcrypto;

DROP TABLE IF EXISTS item_types  CASCADE ;
CREATE TABLE item_types (
  id serial primary key,
  name varchar[]
);


DROP TABLE IF EXISTS items;
CREATE TABLE items (
  id serial primary key,
  item_type_id integer references  item_types(id),
  created_user_id integer,
  region_id numeric,
  name varchar[],
  lat float,
  lng float,
  created TIMESTAMP not null default CURRENT_TIMESTAMP,
  deleted TIMESTAMP null
);

-- temporal
DROP TABLE IF EXISTS regions;
CREATE TABLE regions (
  id serial primary key,
  name varchar[]
);





