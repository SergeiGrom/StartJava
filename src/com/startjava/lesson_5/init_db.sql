  DROP TABLE IF EXISTS Jaegers;

CREATE TABLE Jaegers (
    id         SERIAL PRIMARY KEY, 
    model_name TEXT, 
    mark       TEXT, 
    height     NUMERIC, 
    weight     NUMERIC,
    status     TEXT,
    origin     TEXT, 
    launch     INTEGER, 
    kaiju_kill INTEGER
);

\include_relative populate.sql;
\include_relative queries.sql;


