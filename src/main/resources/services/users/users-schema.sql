-- CREATE EXTENSION IF NOT EXISTS pgcrypto;

DROP TABLE IF EXISTS users;
CREATE TABLE users (
  id bigint identity primary key, -- serial,
  name varchar(1000),
  password varchar(1000),
  email varchar(1000),
  phone varchar(1000),
  autopass TIMESTAMP,
  gross_markup numeric,
  password_updated timestamp,
  phone_validated timestamp,
  cookie varchar(1000),
  created TIMESTAMP null, -- not null default CURRENT_TIMESTAMP,
  deleted TIMESTAMP null
);


-- CREATE INDEX idx_users_id ON users (id);
-- CREATE INDEX idx_users_email ON users (email);
-- CREATE INDEX users_idx on users (id);

DROP TABLE IF EXISTS user_roles;
CREATE TABLE user_roles (
  id bigint identity primary key, --serial,
  user_id bigint,
  username varchar(1000),
  role varchar(1000),
  created TIMESTAMP null, -- default CURRENT_TIMESTAMP,
  deleted TIMESTAMP null
);


-- UPDATE user_roles SET user_id = users.id
-- FROM users
-- WHERE user_roles.username = users.email
--       AND user_roles.user_id IS NULL;
--
-- CREATE INDEX idx_user_roles ON user_roles (username);
-- CREATE INDEX idx_user_roles_user_id ON user_roles (user_id);
-- CREATE INDEX user_roles_irx on user_roles(username);


