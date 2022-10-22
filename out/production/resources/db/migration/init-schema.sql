CREATE TABLE account
(
    id       BIGINT AUTO_INCREMENT NOT NULL,
    email    VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    type     VARCHAR(255) NULL,
    CONSTRAINT pk_account PRIMARY KEY (id)
);

CREATE TABLE doctor_profile
(
    id        BIGINT AUTO_INCREMENT NOT NULL,
    type_name VARCHAR(255) NULL,
    fake      VARCHAR(255) NOT NULL,
    date      VARCHAR(255) NULL,
    time      VARCHAR(255) NOT NULL,
    CONSTRAINT pk_doctor_profile PRIMARY KEY (id)
);

CREATE TABLE silver_data
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    user_email VARCHAR(255) NOT NULL,
    time_stamp VARCHAR(255) NULL,
    a_type     VARCHAR(255) NULL,
    a_value    INT          NOT NULL,
    b_type     VARCHAR(255) NULL,
    b_value    INT          NOT NULL,
    c_type     VARCHAR(255) NULL,
    c_value    INT          NOT NULL,
    CONSTRAINT pk_silver_data PRIMARY KEY (id)
);

CREATE TABLE patient_profile
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    account_id BIGINT NULL,
    CONSTRAINT pk_patient_profile PRIMARY KEY (id)
);

CREATE TABLE project
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    end_date   datetime NULL,
    name       VARCHAR(255) NOT NULL,
    start_date datetime NULL,
    manager_id BIGINT NULL,
    CONSTRAINT pk_project PRIMARY KEY (id)
);

CREATE TABLE task
(
    id          BIGINT AUTO_INCREMENT NOT NULL,
    project_id  BIGINT NULL,
    name        VARCHAR(255) NULL,
    start_date  datetime NULL,
    end_date    datetime NULL,
    assignee_id BIGINT NULL,
    CONSTRAINT pk_task PRIMARY KEY (id)
);

CREATE TABLE test_table
(
    id BIGINT AUTO_INCREMENT NOT NULL,
    CONSTRAINT pk_test_table PRIMARY KEY (id)
);

CREATE TABLE user
(
    id       BIGINT AUTO_INCREMENT NOT NULL,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email    VARCHAR(255) NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
);

ALTER TABLE account
    ADD CONSTRAINT uc_account_email UNIQUE (email);

ALTER TABLE silver_data
    ADD CONSTRAINT uc_silver_data_user_email UNIQUE (user_email);

ALTER TABLE user
    ADD CONSTRAINT uc_user_email UNIQUE (email);

CREATE INDEX idx_account_email ON account (email);

CREATE INDEX idx_project_name ON project (name);

ALTER TABLE patient_profile
    ADD CONSTRAINT FK_PATIENT_PROFILE_ON_ACCOUNT FOREIGN KEY (account_id) REFERENCES account (id);

ALTER TABLE project
    ADD CONSTRAINT FK_PROJECT_ON_MANAGER FOREIGN KEY (manager_id) REFERENCES user (id);

ALTER TABLE task
    ADD CONSTRAINT FK_TASK_ON_ASSIGNEE FOREIGN KEY (assignee_id) REFERENCES user (id);

ALTER TABLE task
    ADD CONSTRAINT FK_TASK_ON_PROJECT FOREIGN KEY (project_id) REFERENCES project (id);