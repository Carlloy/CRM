DROP TABLE IF EXISTS appuser_role;
DROP TABLE IF EXISTS ROLE;
DROP TABLE IF EXISTS appuser;

CREATE TABLE IF NOT EXISTS role (
  id   BIGSERIAL PRIMARY KEY,
  name VARCHAR(25) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS appuser (
  ID       BIGSERIAL PRIMARY KEY,
  NAME     VARCHAR(25) NOT NULL,
  SURNAME  VARCHAR(25) NOT NULL,
  PASSWORD VARCHAR(60) NOT NULL DEFAULT ('test'),
  EMAIL    TEXT        NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS appuser_role (
  appuser_id BIGINT NOT NULL REFERENCES appuser (ID),
  role_id    BIGINT NOT NULL REFERENCES role (ID)

);
CREATE OR REPLACE FUNCTION appuser_role() RETURNS TRIGGER AS
$$
BEGIN
  INSERT INTO appuser_role VALUES (new.id, (SELECT id FROM role WHERE role.name = 'user'));
  RETURN NEW;
END;
$$
LANGUAGE 'plpgsql';

CREATE TRIGGER add_default_role
  AFTER INSERT
  ON appuser
  FOR EACH ROW
EXECUTE PROCEDURE appuser_role();

INSERT INTO role (name) VALUES ('admin'), ('user'), ('blocked');

INSERT INTO appuser (NAME, SURNAME, EMAIL) VALUES
  ('janek', 'admin', 'admin@gmail.com'),
  ('user', 'user', 'user@gmail.com');

INSERT INTO appuser_role VALUES
  (
    (SELECT id FROM appuser WHERE EMAIL = 'admin@gmail.com'),
    (SELECT id FROM ROLE WHERE NAME = 'admin')
  );

SELECT * FROM
  appuser JOIN appuser_role ON appuser.ID = appuser_role.appuser_id JOIN ROLE r ON appuser_role.role_id = r.id;

SELECT *
FROM appuser