DROP TABLE IF EXISTS CHALLENGE;

CREATE TABLE CHALLENGE (
    id varchar(255) PRIMARY KEY,
    answer varchar(255),
    image binary
);

INSERT INTO CHALLENGE (id, answer, image) VALUES ('lwaratvamle', 'OntoProblem2WithYou!', 0);

INSERT INTO CHALLENGE (id, answer, image) VALUES ('7f550a9f4c44173a37664d938f1355f0f92a47a7', 'You win!!!!', 0);

