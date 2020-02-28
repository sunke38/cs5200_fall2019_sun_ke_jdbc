use cs5200_ke_sun_hw3_store_procedures;

DROP PROCEDURE IF EXISTS getUnansweredQuestions;
DELIMITER //
CREATE PROCEDURE getUnansweredQuestions()
BEGIN
SELECT q.id, q.text ,MAX(Correct.count)  FROM question q, answer a, (SELECT  COUNT(a.id) AS count FROM question q, answer a WHERE a.qustion=q.id AND a.correctAnswer = FALSE) AS Correct
    GROUP BY q.module;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS endorsedUsersForWeek;
DELIMITER //
CREATE PROCEDURE endorsedUsersForWeek(IN weekBegin DATE, IN weekEnd DATE)
BEGIN
	SELECT u.fristName as FirstName, u.lastName as LastName, COUNT(a.correctAnswer) AS `#Correct`
    FROM answer a, user u  WHERE a.postedOn > weekBegin AND a.postedOn < weekEnd  AND u.id = a.postedBy AND a.correctAnswer = TRUE
	GROUP BY(u.fristName)
    LIMIT 5;
END //
DELIMITER ;