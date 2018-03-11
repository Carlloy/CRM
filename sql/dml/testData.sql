INSERT INTO role (name) VALUES ('admin'), ('user'), ('blocked');

INSERT INTO appuser (NAME, SURNAME, EMAIL) VALUES
  ('janek', 'admin', 'admin@gmail.com'),
  ('user', 'user', 'user@gmail.com');

INSERT INTO appuser_role VALUES
  (
    (SELECT id
     FROM appuser
     WHERE EMAIL = 'admin@gmail.com'),
    (SELECT id
     FROM ROLE
     WHERE NAME = 'admin')
  );

SELECT *
FROM
  appuser
  JOIN appuser_role ON appuser.ID = appuser_role.appuser_id
  JOIN ROLE r ON appuser_role.role_id = r.id;

SELECT *
FROM appuser