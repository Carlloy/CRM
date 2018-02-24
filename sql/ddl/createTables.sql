DROP TABLE IF EXISTS APPUSER;


CREATE TABLE IF NOT EXISTS APPUSER (
  ID             BIGSERIAL PRIMARY KEY,
  NAME           VARCHAR(25) NOT NULL,
  SURNAME        VARCHAR(25) NOT NULL,
  PASSWORD       VARCHAR(60) NOT NULL DEFAULT ('test'),
  EMAIL          TEXT        NOT NULL UNIQUE,
  APPUSERTYPE_ID INT                  DEFAULT 5
);

ALTER TABLE APPUSER
  ADD CHECK (APPUSERTYPE_ID = 1 OR APPUSERTYPE_ID = 5);

INSERT INTO appuser (name, surname, email, APPUSERTYPE_ID) VALUES
  ('zbyszko', 'zBogdanca', 'admin@gmail.com', 1),
  ('tadzio', 'spod sklepu', 'tadek@gmail.com', 5);


SELECT *
FROM APPUSER