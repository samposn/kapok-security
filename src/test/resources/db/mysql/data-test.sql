# noinspection SqlWithoutWhereForFile

/* Records of user */
DELETE FROM user;
INSERT INTO user
    (id, username, password)
VALUES
    (1, 'admin', '{noop}123456'),
    (2, 'zhangsan', '{noop}123456'),
    (3, 'lisi', '{noop}123456');


/* Records of role */
DELETE FROM role;
INSERT INTO role
    (id, rolename, description)
VALUES
    (1, 'ROLE_ADMIN', '系统管理员'),
    (2, 'ROLE_USER', '普通用户'),
    (3, 'ROLE_GUEST', '游客');


/* Records of permission */
DELETE FROM permission;
INSERT INTO permission
    (id, pattern)
VALUES
    (1, '/admin/**'),
    (2, '/user/**'),
    (3, '/guest/**');


/* Records of user_role */
DELETE FROM role_permission;
INSERT INTO role_permission
    (id, role_id, permission_id)
VALUES
    (1, 1, 1),
    (2, 1, 2),
    (3, 1, 3),
    (4, 2, 2),
    (5, 3, 3);


/* Records of user_role */
DELETE FROM user_role;
INSERT INTO user_role
    (id, user_id, role_id)
VALUES
    (1, 1, 1),
    (2, 1, 2),
    (3, 2, 2),
    (4, 3, 3);