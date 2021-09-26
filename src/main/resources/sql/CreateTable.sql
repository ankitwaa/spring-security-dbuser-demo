-- Postgres Query for Creating users table.

CREATE TABLE IF NOT EXISTS users (
id bigserial primary key,
username VARCHAR(45) NOT NULL,
password VARCHAR(45) NOT NULL,
is_account_not_expired INT,
is_account_not_locked INT,
is_credentials_not_locked INT,
enabled INT NOT NULL
)

CREATE TABLE IF NOT EXISTS authorities (
id bigserial primary key,
username VARCHAR(45) NOT NULL,
authority VARCHAR(45) NOT NULL
)