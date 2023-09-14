-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Εξυπηρετητής: 127.0.0.1
-- Χρόνος δημιουργίας: 28 Μάη 2022 στις 21:38:52
-- Έκδοση διακομιστή: 10.4.21-MariaDB
-- Έκδοση PHP: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Βάση δεδομένων: `university`
--

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `course`
--

CREATE TABLE `course` (
  `cname` varchar(100) NOT NULL,
  `meets_at` date NOT NULL,
  `room` varchar(100) NOT NULL,
  `fid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `course`
--

INSERT INTO `course` (`cname`, `meets_at`, `room`, `fid`) VALUES
('gewmetria', '2022-05-28', 'a3', 2),
('gumnastiki', '2022-05-28', 'a5', 3),
('istoria', '2022-05-28', 'amfitheatro', 3);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `department`
--

CREATE TABLE `department` (
  `deptid` int(11) NOT NULL,
  `dname` varchar(45) NOT NULL,
  `location` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `department`
--

INSERT INTO `department` (`deptid`, `dname`, `location`) VALUES
(1, 'Computer Sciences', 'Lamia'),
(2, 'Mathematics', 'Lamia');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `enrolled`
--

CREATE TABLE `enrolled` (
  `snum` int(11) NOT NULL,
  `cname` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `enrolled`
--

INSERT INTO `enrolled` (`snum`, `cname`) VALUES
(5, 'istoria'),
(10, 'gewmetria'),
(15, 'gumnastiki');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `faculty`
--

CREATE TABLE `faculty` (
  `fid` int(11) NOT NULL,
  `fname` varchar(100) NOT NULL,
  `deptid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `student`
--

CREATE TABLE `student` (
  `snum` int(11) NOT NULL,
  `sname` varchar(45) NOT NULL,
  `deptid` int(11) NOT NULL,
  `slevel` varchar(45) NOT NULL,
  `age` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `student`
--

INSERT INTO `student` (`snum`, `sname`, `deptid`, `slevel`, `age`) VALUES
(1, 'test', 2, '3o etos', 50),
(10, 'giannis', 1, '5o etos', 20),
(15, 'Baggos', 2, '5o etos', 35);

--
-- Ευρετήρια για άχρηστους πίνακες
--

--
-- Ευρετήρια για πίνακα `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`cname`);

--
-- Ευρετήρια για πίνακα `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`deptid`);

--
-- Ευρετήρια για πίνακα `enrolled`
--
ALTER TABLE `enrolled`
  ADD PRIMARY KEY (`snum`);

--
-- Ευρετήρια για πίνακα `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`snum`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
