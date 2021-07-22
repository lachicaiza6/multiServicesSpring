INSERT INTO users (username, password, enabled, email) VALUES ('andres','$2a$10$ykhXmCAam5FUEF9GN.4Z8OwwWJidvMii6VFYe77cmS2X6oF6p4W86',true,'profesor@bolsadeideas.com');
INSERT INTO users (username, password, enabled, email) VALUES ('admin','$2a$10$qGyDfZLBB.SgLv7GCP3uZe3oM38fVtr58T1iZ1LNOvO61loNUAAaK',true,'jhon.doe@bolsadeideas.com');

INSERT INTO rols (name) VALUES ('ROLE_USER');
INSERT INTO rols (name) VALUES ('ROLE_ADMIN');

INSERT INTO users_rols (id_user, id_rol) VALUES (1, 1);
INSERT INTO users_rols (id_user, id_rol) VALUES (2, 2);
INSERT INTO users_rols (id_user, id_rol) VALUES (2, 1);
