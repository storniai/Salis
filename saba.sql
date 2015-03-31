-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 31.03.2015 klo 17:52
-- Palvelimen versio: 5.6.16
-- PHP Version: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `saba`
--

-- --------------------------------------------------------

--
-- Rakenne taululle `event`
--

CREATE TABLE IF NOT EXISTS `event` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` text NOT NULL,
  `match_id` int(11) NOT NULL,
  `goal_playerid` text,
  `assist_playerid` text,
  `penalty_playerid` text,
  `comment` text,
  `goal_playername` text,
  `assist_playername` text,
  `penalty_playername` text,
  `period` int(11) NOT NULL,
  `minutes` int(11) NOT NULL,
  `seconds` int(11) NOT NULL,
  `penalty_time_min` int(11) DEFAULT NULL,
  `my_event` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=35 ;

--
-- Vedos taulusta `event`
--

INSERT INTO `event` (`id`, `type`, `match_id`, `goal_playerid`, `assist_playerid`, `penalty_playerid`, `comment`, `goal_playername`, `assist_playername`, `penalty_playername`, `period`, `minutes`, `seconds`, `penalty_time_min`, `my_event`) VALUES
(1, 'goal', 1, '1', '2', NULL, 'A great goal by MAtti Matilainen', 'MAtti Matilainen', 'Timo Kiiskinen', NULL, 1, 9, 56, NULL, 0),
(2, 'goal', 1, '1', '2', NULL, 'A great goal by MAtti Matilainen', 'MAtti Matilainen', 'Timo Kiiskinen', NULL, 1, 9, 56, NULL, 0),
(3, 'goal', 1, '1', '2', NULL, 'A great goal by MAtti Matilainen', 'MAtti Matilainen', 'Timo Kiiskinen', NULL, 1, 9, 56, NULL, 0),
(4, 'goal', 1, '1', '2', NULL, 'A great goal by MAtti Matilainen', 'MAtti Matilainen', 'Timo Kiiskinen', NULL, 1, 9, 56, NULL, 0),
(5, 'goal', 1, '1', '2', NULL, 'A great goal by MAtti Matilainen', 'MAtti Matilainen', 'Timo Kiiskinen', NULL, 1, 9, 56, NULL, 0),
(6, 'goal', 1, '1', '2', NULL, 'A great goal by MAtti Matilainen', 'MAtti Matilainen', 'Timo Kiiskinen', NULL, 1, 9, 56, NULL, 0),
(7, 'goal', 4, '1', '2', NULL, 'A great goal by MAtti Matilainen', 'MAtti Matilainen', 'Timo Kiiskinen', NULL, 1, 9, 56, NULL, 0),
(8, 'goal', 1, '1', '2', NULL, 'A great goal by MAtti Matilainen', 'MAtti Matilainen', 'Timo Kiiskinen', NULL, 1, 9, 56, NULL, 0),
(9, 'goal', 1, '1', '2', NULL, 'A great goal by MAtti Matilainen', 'MAtti Matilainen', 'Timo Kiiskinen', NULL, 1, 9, 56, NULL, 0),
(10, 'goal', 2, '1', '2', NULL, 'A great goal by MAtti Matilainen', 'MAtti Matilainen', 'Timo Kiiskinen', NULL, 1, 9, 56, NULL, 0),
(11, 'goal', 2, '1', '2', NULL, 'A great goal by MAtti Matilainen', 'MAtti Matilainen', 'Timo Kiiskinen', NULL, 1, 9, 56, NULL, 0),
(12, 'goal', 1, '1', '2', NULL, 'A great goal by MAtti Matilainen', 'MAtti Matilainen', 'Timo Kiiskinen', NULL, 1, 9, 56, NULL, 0),
(13, 'goal', 1, '1', '2', NULL, 'A great goal by MAtti Matilainen', 'MAtti Matilainen', 'Timo Kiiskinen', NULL, 1, 9, 56, NULL, 0),
(14, 'goal', 1, '1', '2', NULL, 'A great goal by MAtti Matilainen', 'MAtti Matilainen', 'Timo Kiiskinen', NULL, 1, 9, 56, NULL, 0),
(15, 'goal', 1, '1', '2', NULL, 'A great goal by MAtti Matilainen', 'MAtti Matilainen', 'Timo Kiiskinen', NULL, 1, 9, 56, NULL, 0),
(16, 'goal', 1, '1', '2', NULL, 'A great goal by MAtti Matilainen', 'MAtti Matilainen', 'Timo Kiiskinen', NULL, 1, 9, 56, NULL, 0),
(17, 'goal', 1, '1', '2', NULL, 'A great goal by MAtti Matilainen', 'MAtti Matilainen', 'Timo Kiiskinen', NULL, 1, 9, 56, NULL, 0),
(18, 'goal', 1, '1', '2', NULL, 'A great goal by MAtti Matilainen', 'MAtti Matilainen', 'Timo Kiiskinen', NULL, 1, 9, 56, NULL, 0),
(19, 'goal', 1, '1', '2', NULL, 'A great goal by MAtti Matilainen', 'MAtti Matilainen', 'Timo Kiiskinen', NULL, 1, 9, 56, NULL, 0),
(20, 'goal', 1, '1', '2', NULL, 'A great goal by MAtti Matilainen', 'MAtti Matilainen', 'Timo Kiiskinen', NULL, 1, 9, 56, NULL, 0),
(21, 'goal', 1, '1', '2', NULL, 'A great goal by MAtti Matilainen', 'MAtti Matilainen', 'Timo Kiiskinen', NULL, 1, 9, 56, NULL, 0),
(22, 'goal', 1, '1', '2', NULL, 'A great goal by MAtti Matilainen', 'MAtti Matilainen', 'Timo Kiiskinen', NULL, 1, 9, 56, NULL, 0),
(23, 'goal', 1, '1', '2', NULL, 'A great goal by MAtti Matilainen', 'MAtti Matilainen', 'Timo Kiiskinen', NULL, 1, 9, 56, NULL, 0),
(24, 'goal', 1, '1', '2', NULL, 'A great goal by MAtti Matilainen', 'MAtti Matilainen', 'Timo Kiiskinen', NULL, 1, 9, 56, NULL, 0),
(25, 'goal', 1, '1', '2', NULL, 'A great goal by MAtti Matilainen', 'MAtti Matilainen', 'Timo Kiiskinen', NULL, 1, 9, 56, NULL, 0),
(26, 'goal', 1, '1', '2', NULL, 'A great goal by MAtti Matilainen', 'MAtti Matilainen', 'Timo Kiiskinen', NULL, 1, 9, 56, NULL, 0),
(27, 'goal', 1, '1', '2', NULL, 'A great goal by MAtti Matilainen', 'MAtti Matilainen', 'Timo Kiiskinen', NULL, 1, 9, 56, NULL, 0),
(28, 'goal', 1, '1', '2', NULL, 'A great goal by MAtti Matilainen', 'MAtti Matilainen', 'Timo Kiiskinen', NULL, 1, 9, 56, NULL, 0),
(29, 'goal', 1, '1', '2', NULL, 'A great goal by MAtti Matilainen', 'MAtti Matilainen', 'Timo Kiiskinen', NULL, 1, 9, 56, NULL, 0),
(30, 'goal', 1, '1', '2', NULL, 'A great goal by MAtti Matilainen', 'MAtti Matilainen', 'Timo Kiiskinen', NULL, 1, 9, 56, NULL, 0),
(31, 'goal', 1, '1', '2', NULL, 'A great goal by MAtti Matilainen', 'MAtti Matilainen', 'Timo Kiiskinen', NULL, 1, 9, 56, NULL, 0),
(32, 'goal', 1, '1', '2', NULL, 'A great goal by MAtti Matilainen', 'MAtti Matilainen', 'Timo Kiiskinen', NULL, 1, 9, 56, NULL, 0),
(33, 'goal', 2, '1', '2', NULL, 'A great goal by MAtti Matilainen', 'MAtti Matilainen', 'Timo Kiiskinen', NULL, 1, 9, 56, NULL, 0),
(34, 'goal', 2, '1', '2', NULL, 'A great goal by MAtti Matilainen', 'MAtti Matilainen', 'Timo Kiiskinen', NULL, 1, 9, 56, NULL, 0);

-- --------------------------------------------------------

--
-- Rakenne taululle `matches`
--

CREATE TABLE IF NOT EXISTS `matches` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL,
  `home_team` text NOT NULL,
  `visitor_team` text NOT NULL,
  `season_id` int(11) NOT NULL,
  `location` text NOT NULL,
  `goals_home` int(11) NOT NULL,
  `goals_visitor` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=43 ;

--
-- Vedos taulusta `matches`
--

INSERT INTO `matches` (`id`, `date`, `home_team`, `visitor_team`, `season_id`, `location`, `goals_home`, `goals_visitor`) VALUES
(1, '2014-08-27 00:00:00', 'My team', 'We got beef', 1, 'Ratiopharm areana', 21, 0),
(2, '2014-08-27 00:00:00', 'My team', 'Slasherr', 1, 'Ratioparh', 4, 0),
(3, '2014-08-29 00:00:00', 'My team', '', 1, '', 0, 0),
(4, '2014-08-29 00:00:00', 'My team', 'Sämpy team', 1, 'Areena', 0, 0),
(5, '2014-08-30 00:00:00', 'My team', 'Jokerit', 1, 'Ateena', 0, 0),
(6, '2014-08-31 00:00:00', 'My team', 'Jejee', 1, 'Jossainpäin', 0, 0),
(7, '2014-08-31 00:00:00', 'My team', 'UUHH', 1, 'BEATLES', 0, 0),
(8, '2014-08-31 00:00:00', 'My team', 'kkk', 1, 'tt', 0, 0),
(9, '2014-09-01 00:00:00', 'My team', 'Liverpool FC', 1, 'Anfield', 0, 0),
(10, '2014-09-01 00:00:00', 'My team', 'Arsenal', 1, 'Emirates', 0, 0),
(11, '2014-09-01 00:00:00', 'My team', 'Arsenal', 1, 'Emirates', 0, 0),
(12, '2014-09-01 00:00:00', 'My team', 'kkk', 1, 'kkk', 0, 0),
(13, '2014-09-01 00:00:00', 'My team', 'hhh', 1, 'ttt', 0, 0),
(14, '2014-09-01 00:00:00', 'My team', 'jj', 1, 'jjjj', 0, 0),
(15, '2014-09-01 00:00:00', 'My team', 'yyyyyy', 1, 'pppppppp', 0, 0),
(16, '2014-09-02 00:00:00', 'My team', 'jee', 1, 'jee', 0, 0),
(17, '2014-09-02 00:00:00', 'My team', 'lfklkfl', 1, 'ldktgklg', 0, 0),
(18, '2014-09-02 00:00:00', 'My team', 'Chelsea fc', 1, 'Areena', 0, 0),
(19, '2014-09-02 00:00:00', 'My team', 'Chelsea fc', 1, 'Areena', 0, 0),
(20, '2014-09-02 00:00:00', 'My team', 'Chelsea fc', 1, 'Areena', 0, 0),
(21, '2014-09-02 00:00:00', 'My team', 'Karhukissat', 1, 'Areena X', 0, 0),
(22, '2014-09-02 00:00:00', 'My team', 'HJK', 1, 'Sonera stadion ', 0, 0),
(23, '2014-09-02 00:00:00', 'My team', 'Karhukissat', 1, 'Areena X', 0, 0),
(24, '2014-09-02 00:00:00', 'My team', 'dsfsdfds', 1, 'sdfsdf', 0, 0),
(25, '2014-09-02 00:00:00', 'My team', 'HH', 1, 'Kk', 0, 0),
(26, '2014-09-03 00:00:00', 'My team', 'ijiij', 1, 'llllklk', 0, 0),
(27, '2014-09-05 00:00:00', 'My team', 'KHL Jokerit', 1, 'Hartwall', 0, 0),
(28, '2014-09-05 00:00:00', 'My team', 'kk', 1, 'kk', 0, 0),
(29, '2014-09-05 00:00:00', 'My team', 'jhjhhj', 1, 'uuy', 0, 0),
(30, '2014-09-05 00:00:00', 'My team', 'kjkj', 1, 'kkk', 0, 0),
(31, '2014-09-05 00:00:00', 'My team', '', 1, '', 0, 0),
(32, '2014-09-05 00:00:00', 'My team', '', 1, '', 0, 0),
(33, '2014-09-06 00:00:00', 'My team', 'kkk', 1, 'jjj', 0, 0),
(34, '2014-09-06 00:00:00', 'My team', 'kkk', 1, 'kkk', 0, 0),
(35, '2014-09-09 00:00:00', 'My team', 'Jokerit', 1, 'Hartwall areena', 0, 0),
(36, '2014-09-09 00:00:00', 'My team', 'Hifk', 1, 'Jäähalli', 0, 0),
(37, '2014-09-09 00:00:00', 'My team', 'SamiT team', 1, 'Kotipiha', 0, 0),
(38, '2014-09-20 00:00:00', 'My team', 'HIFK', 1, 'Areena X', 0, 0),
(39, '2014-09-20 00:00:00', 'My team', 'Dean anderson', 1, 'Espoo', 0, 0),
(40, '2014-09-21 00:00:00', 'My team', 'HJK', 1, 'Sonera stadion', 0, 0),
(41, '2014-09-23 00:00:00', 'My team', 'HJK', 1, 'Sonera', 0, 0),
(42, '2014-09-28 00:00:00', 'My team', 'Teamtalkerik', 1, 'Venus', 0, 0);

-- --------------------------------------------------------

--
-- Rakenne taululle `players`
--

CREATE TABLE IF NOT EXISTS `players` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` text NOT NULL,
  `last_name` text NOT NULL,
  `position` text NOT NULL,
  `active` tinyint(1) NOT NULL,
  `number` int(11) NOT NULL,
  `team_id` int(11) NOT NULL,
  KEY `id` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

--
-- Vedos taulusta `players`
--

INSERT INTO `players` (`id`, `first_name`, `last_name`, `position`, `active`, `number`, `team_id`) VALUES
(1, 'Matti', 'Matilainen', 'attacker', 0, 10, 1),
(2, 'Timo', 'Kiiskinen', 'attacker', 0, 44, 1),
(3, 'Henri', 'Elemo', 'defender', 1, 45, 1),
(4, 'Eerno', 'Niemenma', 'goalie', 1, 22, 1),
(5, 'Sami', 'Torniainen', 'defender', 1, 2, 1),
(6, 'Heini', 'Peltonen', 'goalie', 1, 78, 1),
(7, 'Heini', 'Peltonen', 'goalie', 1, 13, 1),
(8, 'Miika', 'Nordström', 'attacker', 1, 99, 1),
(9, 'Eerno', 'Niemenmaa', 'attacker', 1, 22, 1),
(10, 'ggg', 'mm', 'goalie', 0, 6, 1),
(11, 'Timo', 'Kiiskinen', 'attacker', 1, 1, 1),
(12, 'Sami', 'Torniainen', 'defender', 1, 2, 1),
(13, 'Sami', 'Torniainen', 'defender', 1, 2, 1);

-- --------------------------------------------------------

--
-- Rakenne taululle `seasons`
--

CREATE TABLE IF NOT EXISTS `seasons` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Rakenne taululle `teams`
--

CREATE TABLE IF NOT EXISTS `teams` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Rakenne taululle `teamsheet`
--

CREATE TABLE IF NOT EXISTS `teamsheet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `team_id` text NOT NULL,
  `season_id` text NOT NULL,
  `player_id` text NOT NULL,
  `player_name` text NOT NULL,
  `match_id` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
