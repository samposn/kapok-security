# noinspection SqlWithoutWhereForFile

/* Records of user */
DELETE FROM user;
INSERT INTO user
    (id, username, password, email, mobile)
VALUES
    (1, 'admin', '{bcrypt}$2a$10$pTsXkzL8u3tk.yqt4mtHSek/8F78szltCeQr1Nv0OH2ibOCfRW/N2', 'admin@abc.com', '13812345678'),
    (2, 'zhangsan', '{bcrypt}$2a$10$MfCZSdE21ODXgcxEj6QI4O7jM2t4iHIGdcDzfXupisVWm6HjkKbhG', 'zhangsan@abc.com', '13912345678'),
    (3, 'lisi', '{bcrypt}$2a$10$ZktAAYWA1iFOBSOnTp7bp.llhkmgcd9paFM562LFd2ve0yLcrmLkS', 'lisi@abc.com', '14012345678');


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
    (3, '/guest/**'),
    (4, '/hello/**');


/* Records of user_role */
DELETE FROM role_permission;
INSERT INTO role_permission
    (id, role_id, permission_id)
VALUES
    (1, 1, 1),
    (2, 1, 2),
    (3, 1, 3),
    (4, 1, 4),
    (5, 2, 2),
    (6, 3, 3);


/* Records of user_role */
DELETE FROM user_role;
INSERT INTO user_role
    (id, user_id, role_id)
VALUES
    (1, 1, 1),
    (2, 1, 2),
    (3, 2, 2),
    (4, 3, 3);