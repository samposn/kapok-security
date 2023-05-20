/* User */
DROP TABLE IF EXISTS user;
CREATE TABLE IF NOT EXISTS user
(
    id       BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY COMMENT '主键',
    username VARCHAR(255) COMMENT '账号',
    password VARCHAR(255) COMMENT '密码',
    email    VARCHAR(255) COMMENT '电子邮箱',
    mobile   VARCHAR(255) COMMENT '手机号码'
);

/* Role */
CREATE TABLE IF NOT EXISTS role
(
    id          BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY COMMENT '主键',
    rolename    VARCHAR(255) COMMENT '角色名称',
    description VARCHAR(255) COMMENT '描述'
);

/* Permission */
CREATE TABLE IF NOT EXISTS permission
(
    id      BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY COMMENT '主键',
    pattern VARCHAR(255) COMMENT '权限字符表达式'
);

/* User_Role */
CREATE TABLE IF NOT EXISTS user_role
(
    id      BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY COMMENT '主键',
    user_id BIGINT COMMENT '用户ID',
    role_id BIGINT COMMENT '角色ID'
);

/* Role_Permission */
CREATE TABLE IF NOT EXISTS role_permission
(
    id            BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY COMMENT '主键',
    role_id       BIGINT COMMENT '角色ID',
    permission_id BIGINT COMMENT '权限ID'
);


