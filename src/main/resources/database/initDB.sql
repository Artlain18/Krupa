CREATE TABLE IF NOT EXISTS users
(
    USER_ID INTEGER PRIMARY KEY,
    NAME TEXT NOT NULL,
    PASSWORD TEXT NOT NULL,
    IS_ADMIN BOOLEAN NOT NULL
);
CREATE SEQUENCE IF NOT EXISTS users_id_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS status
(
    STATUS_ID INTEGER PRIMARY KEY,
    STATUS_MESSAGE TEXT
);
CREATE SEQUENCE IF NOT EXISTS status_id_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS game
(
    GAME_ID INTEGER PRIMARY KEY,
    NAME TEXT,
    DESCRIBE TEXT,
    BACK TEXT,
    LOGO TEXT,
    GAMETRAILER TEXT,
    TEASER TEXT,
    PUBLISHER TEXT
);
CREATE SEQUENCE IF NOT EXISTS game_id_seq START WITH 2 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS game_like
(
    USER_ID INTEGER PRIMARY KEY REFERENCES users (USER_ID),
    GAME_ID INTEGER REFERENCES game (GAME_ID),
    IS_GAME_LIKE BOOLEAN
);

CREATE TABLE IF NOT EXISTS review
(
    REVIEW_ID INTEGER PRIMARY KEY ,
    MESSAGE TEXT NOT NULL ,
    NAME TEXT NOT NULL ,
    USER_ID INTEGER REFERENCES users (USER_ID),
    GAME_ID INTEGER REFERENCES game (GAME_ID),
    SCORE REAL NOT NULL,
    STATUS_ID INTEGER REFERENCES status (STATUS_ID)
);

CREATE SEQUENCE IF NOT EXISTS review_id_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS review_like
(
    USER_ID INTEGER PRIMARY KEY REFERENCES users (USER_ID),
    REVIEW_ID INTEGER REFERENCES review (REVIEW_ID),
    IS_REVIEW_LIKE BOOLEAN
);