DROP table abouts;
DROP table details;
DROP table users;
-- Users Table: Centralized unique identifiers
CREATE TABLE users
(
    id       NUMBER(20) GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    username VARCHAR2(36) NOT NULL UNIQUE,
    email    VARCHAR2(128) NOT NULL UNIQUE,
    reg_date TIMESTAMP DEFAULT SYSTIMESTAMP,
    password VARCHAR2(256) NOT NULL
);

-- Abouts Table: One-to-one relationship with users
CREATE TABLE abouts
(
    id    NUMBER(20) PRIMARY KEY,
    about VARCHAR2(1024) DEFAULT 'Hey! I am using knowledgeMD',
    CONSTRAINT fk_about_user FOREIGN KEY (id) REFERENCES users (id) ON DELETE CASCADE
);

-- Details Table: Additional user information
CREATE TABLE details
(
    id           NUMBER(20) PRIMARY KEY,
    first_name   VARCHAR2(32) NOT NULL,
    last_name    VARCHAR2(32) NOT NULL,
    gender       VARCHAR2(16) NOT NULL,
    phone_number VARCHAR2(16),
    CONSTRAINT fk_details_user FOREIGN KEY (id) REFERENCES users (id) ON DELETE CASCADE
);

INSERT INTO users (username, email, password)
VALUES ('john_doe', 'john.doe@example.com', 'securepassword');

INSERT INTO abouts (id, about)
VALUES (1, 'Software engineer passionate about coding.');

INSERT INTO details (id, first_name, last_name, gender, phone_number)
VALUES (1, 'John', 'Doe', 'male', '1234567890');

-- test join
select * from USERS u inner join ABOUTS a on a.id=u.id inner join DETAILS d on u.id = d.id;

-- test get about from email!
select about from ABOUTS where id = (select id from USERS where EMAIL='john.doe@example.com');

commit;