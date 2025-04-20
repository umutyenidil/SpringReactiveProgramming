create table students
(
    id         SERIAL NOT NULL PRIMARY KEY,
    first_name VARCHAR(250),
    last_name  VARCHAR(250),
    age        integer
)