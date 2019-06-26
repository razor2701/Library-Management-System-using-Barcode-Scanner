-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 15, 2016 at 04:46 PM
-- Server version: 5.5.24-log
-- PHP Version: 5.3.13

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `library`
--

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE IF NOT EXISTS `books` (
  `bookid` varchar(20) NOT NULL,
  `bookname` varchar(50) NOT NULL,
  `isbn` varchar(20) NOT NULL,
  `edition` varchar(10) NOT NULL,
  `authorname` varchar(50) NOT NULL,
  `catid` varchar(50) NOT NULL,
  `nop` int(11) NOT NULL,
  `shelfno` varchar(10) NOT NULL,
  `avialable` varchar(3) NOT NULL,
  PRIMARY KEY (`bookid`),
  KEY `bookid` (`bookid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`bookid`, `bookname`, `isbn`, `edition`, `authorname`, `catid`, `nop`, `shelfno`, `avialable`) VALUES
('0194512329349', 'Environmental Studies from Crises to Cure ', 'Asx12456', '3', 'R. Rajgopalan', 'History & Current Affairs', 340, '1', 'No'),
('2478116638402', 'Upgrading & Repairing PCs ', 'qw124bd', '3', 'Scott Muller', 'Programming', 987, '2A', 'Yes'),
('3505412900970', 'Managing & Troubleshooting PCs ', '89wef5df', '2', 'Mike Meyers Scott Jernigan ', 'Information Technology', 50, '1', 'Yes'),
('4589519103317', 'The 8088 and 8086 Microprocessors ', 'wr4fsdsc', '2', 'Walter A. Triebel, Avtar Singh', 'Programming', 896, '1A', 'No'),
('5919939241361', 'Data Communications and Networking', 'dsggw3332', '5', 'Behrouz A. Forouzan ', 'Information Technology', 444, '1', 'Yes'),
('6400095820073', 'Object oriented Programming in C++ ', 'q2345dfvfd5', '5', 'Rajesh K. Shukla ', 'Programming', 982, '1A', 'Yes'),
('6508001427615', 'Environmental Studies ', '123Abx234', '1', 'Anindita Basak', 'comic', 800, '1', 'No'),
('8130329491752', 'Production Engineering ', 'awdf32544', '2', 'P.C. Sharma ', 'comic', 534, '1', 'Yes');

-- --------------------------------------------------------

--
-- Table structure for table `books_borrowed`
--

CREATE TABLE IF NOT EXISTS `books_borrowed` (
  `bid` int(11) NOT NULL AUTO_INCREMENT,
  `memid` varchar(5) NOT NULL,
  `bookid` varchar(20) NOT NULL,
  `issusedate` date NOT NULL,
  `returndate` date NOT NULL,
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `books_borrowed`
--

INSERT INTO `books_borrowed` (`bid`, `memid`, `bookid`, `issusedate`, `returndate`) VALUES
(6, '1', '0194512329349', '2016-12-14', '2016-12-24'),
(7, '2', '4589519103317', '2016-12-14', '2016-12-24'),
(8, '1', '6508001427615', '2016-12-14', '2016-12-24');

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE IF NOT EXISTS `category` (
  `catid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`catid`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=22 ;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`catid`, `name`) VALUES
(1, 'comic'),
(2, 'novel'),
(3, 'Programming'),
(4, 'Biography'),
(5, 'Business & Management'),
(6, 'Children'),
(7, 'Fiction'),
(8, 'Film'),
(9, 'Gujarati'),
(10, 'Health'),
(11, 'Hindi'),
(12, 'History & Current Affairs'),
(13, 'Non Fiction'),
(14, 'Sports'),
(15, 'Electrical Technology'),
(16, 'Environment'),
(17, 'Software Design'),
(18, 'Information Technology'),
(19, 'Mechanical Enigneer'),
(20, 'Commerce'),
(21, 'Arts');

-- --------------------------------------------------------

--
-- Table structure for table `members`
--

CREATE TABLE IF NOT EXISTS `members` (
  `memid` int(11) NOT NULL AUTO_INCREMENT,
  `memname` varchar(50) NOT NULL,
  `memadd` mediumtext NOT NULL,
  `mememail` varchar(50) NOT NULL,
  `password` varchar(12) CHARACTER SET latin1 COLLATE latin1_general_cs NOT NULL,
  PRIMARY KEY (`memid`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `members`
--

INSERT INTO `members` (`memid`, `memname`, `memadd`, `mememail`, `password`) VALUES
(1, 'Franky Naidu', 'EverShine City Vasai ', 'franky16081996@gmail.com', 'franky123'),
(2, 'Thompson Naidu', 'EverShine City Vasai (East)', 'thompsoncm1343@gmail.com', 'thompson123'),
(3, 'Sanil Rodrigues', 'Gass,NallaSopara	', 'sanilrod@gmail.com', 'sanil123');

-- --------------------------------------------------------

--
-- Table structure for table `shelf`
--

CREATE TABLE IF NOT EXISTS `shelf` (
  `shelfno` varchar(10) NOT NULL,
  `location` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `shelf`
--

INSERT INTO `shelf` (`shelfno`, `location`) VALUES
('1', '1stFloor'),
('2A', '2ndFloorCorne'),
('1A', '1stFloor Terrace');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `username` varchar(25) NOT NULL,
  `name` varchar(25) NOT NULL,
  `password` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`username`, `name`, `password`) VALUES
('admin', 'admin', 'admin123'),
('super', 'user12', 'user23'),
('necil', 'necil Dabre', 'necil123');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
