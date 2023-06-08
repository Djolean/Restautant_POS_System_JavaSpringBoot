-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 16, 2023 at 10:53 PM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `restaurant`
--

-- --------------------------------------------------------

--
-- Table structure for table `jelo`
--

CREATE TABLE `jelo` (
  `jelo_id` int(11) NOT NULL,
  `naziv` varchar(100) DEFAULT NULL,
  `cena` decimal(10,2) DEFAULT NULL,
  `opis` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `korisnik`
--

CREATE TABLE `korisnik` (
  `korisnik_id` int(11) NOT NULL,
  `ime` varchar(50) DEFAULT NULL,
  `prezime` varchar(50) DEFAULT NULL,
  `korisnicko_ime` varchar(50) DEFAULT NULL,
  `lozinka` varchar(50) DEFAULT NULL,
  `plata` decimal(10,2) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `narudzbina`
--

CREATE TABLE `narudzbina` (
  `narudzbina_id` int(11) NOT NULL,
  `korisnik_id` int(11) DEFAULT NULL,
  `jelo_id` int(11) DEFAULT NULL,
  `datum` date DEFAULT NULL,
  `ukupna_cena` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `narudzbinajelo`
--

CREATE TABLE `narudzbinajelo` (
  `narudzbina_id` int(11) NOT NULL,
  `jelo_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `placanje`
--

CREATE TABLE `placanje` (
  `placanje_id` int(11) NOT NULL,
  `narudzbina_id` int(11) DEFAULT NULL,
  `datum_placanja` date DEFAULT NULL,
  `iznos` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `role_id` int(11) NOT NULL,
  `naziv` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`role_id`, `naziv`) VALUES
(1, 'Korisnik'),
(2, 'Admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `jelo`
--
ALTER TABLE `jelo`
  ADD PRIMARY KEY (`jelo_id`);

--
-- Indexes for table `korisnik`
--
ALTER TABLE `korisnik`
  ADD PRIMARY KEY (`korisnik_id`),
  ADD KEY `role_id` (`role_id`);

--
-- Indexes for table `narudzbina`
--
ALTER TABLE `narudzbina`
  ADD PRIMARY KEY (`narudzbina_id`),
  ADD KEY `korisnik_id` (`korisnik_id`),
  ADD KEY `jelo_id` (`jelo_id`);

--
-- Indexes for table `narudzbinajelo`
--
ALTER TABLE `narudzbinajelo`
  ADD PRIMARY KEY (`narudzbina_id`,`jelo_id`);

--
-- Indexes for table `placanje`
--
ALTER TABLE `placanje`
  ADD PRIMARY KEY (`placanje_id`),
  ADD KEY `narudzbina_id` (`narudzbina_id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`role_id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `korisnik`
--
ALTER TABLE `korisnik`
  ADD CONSTRAINT `korisnik_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`);

--
-- Constraints for table `narudzbina`
--
ALTER TABLE `narudzbina`
  ADD CONSTRAINT `narudzbina_ibfk_1` FOREIGN KEY (`korisnik_id`) REFERENCES `korisnik` (`korisnik_id`),
  ADD CONSTRAINT `narudzbina_ibfk_2` FOREIGN KEY (`jelo_id`) REFERENCES `jelo` (`jelo_id`);

--
-- Constraints for table `placanje`
--
ALTER TABLE `placanje`
  ADD CONSTRAINT `placanje_ibfk_1` FOREIGN KEY (`narudzbina_id`) REFERENCES `narudzbina` (`narudzbina_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
