create database bdincubator;
use bdincubator;

CREATE TABLE `topic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` varchar(800) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` int(11) DEFAULT NULL,
  `tutor` int(11) DEFAULT NULL,
  `admin` int(11) DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` varchar(800) DEFAULT NULL,
  `topicId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `topicId_idx` (`topicId`),
  CONSTRAINT `topicId` FOREIGN KEY (`topicId`) REFERENCES `topic` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `login` varchar(45) DEFAULT NULL,
  `password` int(11) DEFAULT NULL,
  `roleId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `roleId_idx` (`roleId`),
  CONSTRAINT `roleId` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(800) DEFAULT NULL,
  `testid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `testId_idx` (`testid`),
  CONSTRAINT `testId` FOREIGN KEY (`testid`) REFERENCES `test` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `statistic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `correct` tinyint(4) DEFAULT NULL,
  `questionId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userId_idx` (`userId`),
  KEY `questionId_idx` (`questionId`),
  CONSTRAINT `questionId_idx` FOREIGN KEY (`questionId`) REFERENCES `question` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `userId` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `literature` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(800) DEFAULT NULL,
  `questionId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `questionId_idx` (`questionId`),
  CONSTRAINT `questionId` FOREIGN KEY (`questionId`) REFERENCES `question` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `link` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `link` varchar(800) DEFAULT NULL,
  `literatureId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `literatureId_idx` (`literatureId`),
  CONSTRAINT `literatureId` FOREIGN KEY (`literatureId`) REFERENCES `literature` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `answer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(800) DEFAULT NULL,
  `correct` tinyint(4) DEFAULT NULL,
  `questionId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `questionId_id` (`questionId`),
  CONSTRAINT `questionId_id` FOREIGN KEY (`questionId`) REFERENCES `question` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


