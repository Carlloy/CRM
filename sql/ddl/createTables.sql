﻿DROP TABLE IF EXISTS appuser_role;
DROP TABLE IF EXISTS role;
DROP TABLE IF EXISTS contact;
DROP TABLE IF EXISTS company;
DROP TABLE IF EXISTS appuser;

CREATE TABLE IF NOT EXISTS role (
  id   BIGSERIAL PRIMARY KEY,
  name VARCHAR(25) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS appuser (
  ID       BIGSERIAL PRIMARY KEY,
  NAME     VARCHAR(25) NOT NULL,
  SURNAME  VARCHAR(25) NOT NULL,
  PASSWORD VARCHAR(60) NOT NULL DEFAULT ('$2a$10$9pJNjyj/800iO5CC8U6SHu8zHvhe1jvwX0rn4p973394geOQ26UNS'),
  EMAIL    VARCHAR(60) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS appuser_role (
  appuser_id BIGINT NOT NULL REFERENCES appuser (ID),
  role_id    BIGINT NOT NULL REFERENCES role (ID)

);
CREATE OR REPLACE FUNCTION appuser_role()
  RETURNS TRIGGER AS
$$
BEGIN
  INSERT INTO appuser_role VALUES (new.id, (SELECT id
                                            FROM role
                                            WHERE role.name = 'user'));
  RETURN NEW;
END;
$$
LANGUAGE 'plpgsql';

CREATE TRIGGER add_default_role
  AFTER INSERT
  ON appuser
  FOR EACH ROW
EXECUTE PROCEDURE appuser_role();


CREATE TABLE IF NOT EXISTS company (
  ID           BIGSERIAL PRIMARY KEY,
  NAME         VARCHAR(60) NOT NULL UNIQUE,
  PHONE        VARCHAR(15),
  EMAIL        VARCHAR(60),
  WEBSITE      VARCHAR(60),
  DESCRIPTION  TEXT,
  CITY         VARCHAR(30),
  STREET       VARCHAR(50),
  REGION       VARCHAR(30),
  POSTALCODE   VARCHAR(10),
  COUNTRY      VARCHAR(20),
  CREATEDBY    BIGINT REFERENCES appuser (id),
  CREATIONDATE DATE DEFAULT NOW()
);

CREATE TABLE IF NOT EXISTS industry (
  ID        BIGSERIAL PRIMARY KEY,
  COMPANYID BIGINT      NOT NULL REFERENCES company (id),
  NAME      VARCHAR(30) NOT NULL
);

CREATE TABLE IF NOT EXISTS contact (
  ID        BIGSERIAL PRIMARY KEY,
  COMPANYID BIGINT REFERENCES company,
  NAME      VARCHAR(25) NOT NULL,
  SURNAME   VARCHAR(25) NOT NULL,
  NUMBER    VARCHAR(15),
  EMAIL     VARCHAR(60)
)