CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `question_statistic` AS
    SELECT 
        `question`.`id` AS `questionId`,
        `question`.`description` AS `description`,
        COUNT(`statistic`.`questionId`) AS `count`,
        (SUM(`statistic`.`correct`) / COUNT(`statistic`.`questionId`)) AS `correct`,
        (1 - (SUM(`statistic`.`correct`) / COUNT(`statistic`.`questionId`))) AS `incorrect`
    FROM
        (`question`
        JOIN `statistic`)
    WHERE
        (`question`.`id` IN (SELECT 
                `statistic`.`questionId`
            FROM
                `statistic`
            GROUP BY `statistic`.`questionId`)
            AND (`statistic`.`questionId` = `question`.`id`))
    GROUP BY `statistic`.`questionId`
	
CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `test_results` AS
    SELECT 
        `statistic`.`date` AS `date`,
        `statistic`.`userId` AS `userId`,
        `user`.`firstName` AS `firstName`,
        `user`.`lastName` AS `lastName`,
        `question`.`testid` AS `testId`,
        `test`.`name` AS `name`,
        `test`.`description` AS `description`,
        (SUM(`statistic`.`correct`) / COUNT(0)) AS `correct`
    FROM
        (((`statistic`
        JOIN `question` ON ((`statistic`.`questionId` = `question`.`id`)))
        JOIN `test` ON ((`question`.`testid` = `test`.`id`)))
        JOIN `user` ON ((`statistic`.`userId` = `user`.`id`)))
    GROUP BY `question`.`testid` , `statistic`.`userId` , `statistic`.`date`
	
CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `test_statistic` AS
    SELECT 
        `test_results`.`testId` AS `testId`,
        `test_results`.`name` AS `name`,
        COUNT(0) AS `count`,
        AVG(`test_results`.`correct`) AS `correct`,
        (1 - AVG(`test_results`.`correct`)) AS `incorrect`
    FROM
        `test_results`
    GROUP BY `test_results`.`testId`
	
CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `user_statistic` AS
    SELECT 
        `test_results`.`userId` AS `userId`,
        `test_results`.`firstName` AS `firstName`,
        `test_results`.`lastName` AS `lastName`,
        COUNT(0) AS `count`,
        AVG(`test_results`.`correct`) AS `correct`,
        (1 - AVG(`test_results`.`correct`)) AS `incorrect`
    FROM
        `test_results`
    GROUP BY `test_results`.`userId`