\set origin_ECHO :ECHO
\set ECHO all

-- Вся таблица, отсортированная по именам роботов в алфавитном порядке.
SELECT *
  FROM Jaegers
 ORDER BY model_name;

-- Только не уничтоженные роботы.
SELECT *
  FROM Jaegers
 WHERE status = 'Active'
 ORDER BY model_name;

-- Только роботы серии Mark-1 и Mark-4.
SELECT *
  FROM Jaegers 
 WHERE mark IN ('Mark-1','Mark-4')
 ORDER BY model_name;

-- Все роботы, кроме Mark-1 и Mark-4, отсортированные по убыванию по столбцу mark
SELECT *
  FROM Jaegers
 WHERE mark NOT IN ('Mark-1', 'Mark-4')
 ORDER BY mark DESC;

-- Информация о самых старых роботах.
SELECT *
  FROM Jaegers
 WHERE launch < (SELECT AVG(launch)
  FROM Jaegers)
 ORDER BY launch;

-- Информация из столбцов model_name, mark, launch, kaiju_kill тех роботов, которые уничтожили больше всех kaiju.
SELECT model_name, mark, launch, kaiju_kill
  FROM Jaegers 
 WHERE kaiju_kill >=
       (SELECT AVG(kaiju_kill)
          FROM Jaegers)
 ORDER BY kaiju_kill;

-- Cредний вес роботов, округленный до трех знаков после запятой.
SELECT ROUND((AVG(weight)) :: numeric, 3)
  FROM Jaegers;

-- Количество уничтоженных kaiju у неразрушенных роботов увеличено на единицу.
UPDATE Jaegers
   SET kaiju_kill = (kaiju_kill + 1)
 WHERE status = 'Active';

SELECT *
  FROM Jaegers
 ORDER BY model_name;

-- Роботы со статусом destroyed удалены.
DELETE
  FROM Jaegers
 WHERE status = 'Destroyed';

SELECT *
  FROM Jaegers
 ORDER BY model_name;

\set ECHO :origin_ECHO