INSERT INTO todo.authority (id, authority, create_time, update_time) VALUES (1, 'ROLE_ADMIN', '2022-03-10 15:15:19', '2022-03-10 15:16:01');
INSERT INTO todo.authority (id, authority, create_time, update_time) VALUES (2, 'ROLE_BOSS', '2022-03-10 15:16:01', '2022-03-10 15:16:01');
INSERT INTO todo.user (id, username, password, account_non_expired, account_non_locked, credentials_non_expired, enabled, create_time, update_time) VALUES (1, 'root', '123', true, true, true, true, '2022-03-10 15:11:47', '2022-03-10 15:11:47');
INSERT INTO todo.user_authority (user_id, authority_id) VALUES (1, 1);
INSERT INTO todo.user_authority (user_id, authority_id) VALUES (1, 2);
