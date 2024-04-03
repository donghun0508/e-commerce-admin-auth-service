DROP TABLE if exists GROUP_MEMBER;
DROP TABLE if exists GROUP_POLICIES;
DROP TABLE if exists MEMBER_PERMISSION;
DROP TABLE if exists POLICIES_PERMISSION;
DROP TABLE if exists POLICIES_CONDITIONS;
DROP TABLE if exists CONDITIONS;
DROP TABLE if exists POLICIES;
DROP TABLE if exists MEMBER;
DROP TABLE if exists `GROUPS`;
DROP TABLE if exists PERMISSION;

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

CREATE TABLE `GROUPS`
(
    group_id    BIGINT                  NOT NULL AUTO_INCREMENT primary key,
    name        VARCHAR(255) UNIQUE     NOT NULL,
    description VARCHAR(255),
    created_at  timestamp default now() not null,
    modified_at timestamp default now() not null
);

CREATE TABLE POLICIES
(
    POLICIES_id BIGINT                  NOT NULL AUTO_INCREMENT primary key,
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

CREATE TABLE POLICIES_CONDITIONS
(
    POLICIES_condition_id BIGINT                  NOT NULL AUTO_INCREMENT primary key,
    POLICIES_id           BIGINT                  NOT NULL,
    condition_id          BIGINT                  NOT NULL,
    data                  JSON                    NOT NULL,
    created_at            timestamp default now() not null,
    modified_at           timestamp default now() not null,
    FOREIGN KEY (POLICIES_id) REFERENCES POLICIES (POLICIES_id),
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
    FOREIGN KEY (group_id) REFERENCES `GROUPS` (group_id)
);

CREATE TABLE POLICIES_PERMISSION
(
    POLICIES_permission_id BIGINT                  NOT NULL AUTO_INCREMENT primary key,
    POLICIES_id            BIGINT                  NOT NULL,
    permission_id          BIGINT                  NOT NULL,
    created_at             timestamp default now() not null,
    modified_at            timestamp default now() not null,
    FOREIGN KEY (POLICIES_id) REFERENCES POLICIES (POLICIES_id),
    FOREIGN KEY (permission_id) REFERENCES PERMISSION (permission_id)
);

CREATE TABLE GROUP_POLICIES
(
    group_POLICIES_id BIGINT                  NOT NULL AUTO_INCREMENT primary key,
    group_id          BIGINT                  NOT NULL,
    POLICIES_id       BIGINT                  NOT NULL,
    created_at        timestamp default now() not null,
    modified_at       timestamp default now() not null,
    FOREIGN KEY (group_id) REFERENCES `GROUPS` (group_id),
    FOREIGN KEY (POLICIES_id) REFERENCES POLICIES (POLICIES_id)
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
