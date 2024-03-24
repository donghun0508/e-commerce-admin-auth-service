DROP TABLE if exists GROUP_MEMBER;
DROP TABLE if exists GROUP_POLICY;
DROP TABLE if exists MEMBER_PERMISSION;
DROP TABLE if exists POLICY_PERMISSION;
DROP TABLE if exists CONDITIONS;
DROP TABLE if exists POLICY_CONDITIONS;
DROP TABLE if exists POLICY;
DROP TABLE if exists MEMBER;
DROP TABLE if exists GROUPS;
DROP TABLE if exists PERMISSION;

-- CREATE TABLE GROUP_CODE
-- (
--     group_code  VARCHAR(255)            NOT NULL primary key,
--     description VARCHAR(255),
--     is_deleted  BOOLEAN   DEFAULT FALSE NOT NULL,
--     created_at  timestamp default now() not null,
--     modified_at timestamp default now() not null
-- );
--
-- CREATE TABLE CODE
-- (
--     code        BIGINT                  NOT NULL primary key,
--     group_code  VARCHAR(255)            NOT NULL,
--     description VARCHAR(255),
--     is_deleted  BOOLEAN   DEFAULT FALSE NOT NULL,
--     created_at  timestamp default now() not null,
--     modified_at timestamp default now() not null,
--     FOREIGN KEY (group_code) REFERENCES GROUP_CODE (group_code)
-- );

CREATE TABLE MEMBER
(
    member_id   BIGINT                  NOT NULL AUTO_INCREMENT primary key,
    email       VARCHAR(255) UNIQUE     NOT NULL,
    password    VARCHAR(255)            NOT NULL,
    nick_name   VARCHAR(255) UNIQUE     NOT NULL,
    is_deleted  BOOLEAN   DEFAULT FALSE NOT NULL,
    deleted_at  timestamp,
    created_at  timestamp default now() not null,
    modified_at timestamp default now() not null
);

CREATE TABLE GROUPS
(
    group_id    BIGINT                  NOT NULL AUTO_INCREMENT primary key,
    name        VARCHAR(255) UNIQUE     NOT NULL,
    description VARCHAR(255),
    created_at  timestamp default now() not null,
    modified_at timestamp default now() not null
);

CREATE TABLE POLICY
(
    policy_id   BIGINT                  NOT NULL AUTO_INCREMENT primary key,
    name        VARCHAR(255) UNIQUE     NOT NULL,
    description VARCHAR(255),
    effect      VARCHAR(255)            NOT NULL,
    created_at  timestamp default now() not null,
    modified_at timestamp default now() not null
);

CREATE TABLE CONDITIONS
(
    condition_id BIGINT                  NOT NULL AUTO_INCREMENT primary key,
    code         VARCHAR(255) UNIQUE     NOT NULL,
    description  VARCHAR(255),
    created_at   timestamp default now() not null,
    modified_at  timestamp default now() not null
);

CREATE TABLE POLICY_CONDITIONS
(
    policy_condition_id BIGINT                  NOT NULL AUTO_INCREMENT primary key,
    policy_id           BIGINT                  NOT NULL,
    condition_id        BIGINT                  NOT NULL,
    values              JSON                    NOT NULL,
    created_at          timestamp default now() not null,
    modified_at         timestamp default now() not null,
    FOREIGN KEY (policy_id) REFERENCES POLICY (policy_id),
    FOREIGN KEY (condition_id) REFERENCES CONDITIONS (condition_id)
);

CREATE TABLE PERMISSION
(
    permission_id BIGINT                  NOT NULL AUTO_INCREMENT primary key,
    order_number  BIGINT                  NOT NULL,
    resource      VARCHAR(255)            NOT NULL,
    action        VARCHAR(255)            NOT NULL,
    resource_type VARCHAR(255)            NOT NULL,
    description   VARCHAR(255),
    created_at    timestamp default now() not null,
    modified_at   timestamp default now() not null
);

CREATE TABLE GROUP_MEMBER
(
    group_member_id BIGINT                  NOT NULL AUTO_INCREMENT primary key,
    member_id       BIGINT                  NOT NULL,
    group_id        BIGINT                  NOT NULL,
    created_at      timestamp default now() not null,
    modified_at     timestamp default now() not null,
    FOREIGN KEY (member_id) REFERENCES MEMBER (member_id),
    FOREIGN KEY (group_id) REFERENCES GROUPS (group_id)
);

CREATE TABLE POLICY_PERMISSION
(
    policy_permission_id BIGINT                  NOT NULL AUTO_INCREMENT primary key,
    policy_id            BIGINT                  NOT NULL,
    permission_id        BIGINT                  NOT NULL,
    created_at           timestamp default now() not null,
    modified_at          timestamp default now() not null,
    FOREIGN KEY (policy_id) REFERENCES POLICY (policy_id),
    FOREIGN KEY (permission_id) REFERENCES PERMISSION (permission_id)
);

CREATE TABLE GROUP_POLICY
(
    group_policy_id BIGINT                  NOT NULL AUTO_INCREMENT primary key,
    group_id        BIGINT                  NOT NULL,
    policy_id       BIGINT                  NOT NULL,
    created_at      timestamp default now() not null,
    modified_at     timestamp default now() not null,
    FOREIGN KEY (group_id) REFERENCES GROUPS (group_id),
    FOREIGN KEY (policy_id) REFERENCES POLICY (policy_id)
);

CREATE TABLE MEMBER_PERMISSION
(
    member_permission_id BIGINT                  NOT NULL AUTO_INCREMENT primary key,
    member_id            BIGINT                  NOT NULL,
    permission_id        BIGINT                  NOT NULL,
    created_at           timestamp default now() not null,
    modified_at          timestamp default now() not null,
    FOREIGN KEY (member_id) REFERENCES MEMBER (member_id),
    FOREIGN KEY (permission_id) REFERENCES PERMISSION (permission_id)
);
