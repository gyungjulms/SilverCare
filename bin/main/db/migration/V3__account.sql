CREATE TABLE account
(
    id       BIGINT AUTO_INCREMENT NOT NULL,
    email    VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    type     VARCHAR(255) NULL,
    CONSTRAINT pk_account PRIMARY KEY (id)
);

ALTER TABLE account
    ADD CONSTRAINT uc_account_email UNIQUE (email);

CREATE INDEX idx_account_email ON account (email);