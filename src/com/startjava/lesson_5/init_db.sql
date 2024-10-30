DROP DATABASE robots;

DROP TABLE IF EXISTS Jaegers;

CREATE DATABASE robots;

CREATE TABLE Jaegers(
    id SERIAL PRIMARY KEY, 
    model_name TEXT, 
    mark TEXT, 
    height REAL, 
    weight REAL,
    status TEXT,
    origin TEXT, 
    launch INTEGER, 
    kaiju_kill INTEGER);

\include_relative populate.sql;

\include_relative queries.sql;


