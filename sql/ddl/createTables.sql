DROP TABLE IF EXISTS APPUSER;

CREATE TABLE IF NOT EXISTS APPUSER (
  ID       SERIAL PRIMARY KEY,
  NAME     TEXT NOT NULL,
  SURNAME  TEXT NOT NULL,
  PASSWORD TEXT NOT NULL DEFAULT ('test'),
  EMAIL    TEXT NOT NULL UNIQUE,
  UserType INT  NOT NULL DEFAULT (0)
);

ALTER TABLE APPUSER
  ADD CHECK (UserType = 1 OR UserType = 0);


INSERT INTO appuser (name, surname, email, usertype) VALUES
  ('janko', 'muzykant', 'muzykant@gmail.com', 0),
  ('zbyszko', 'zBogdanca', 'admin@gmail.com', 1),
  ('tadzio', 'spod sklepu', 'tadek@gmail.com', 0);
