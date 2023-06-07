-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 07, 2023 at 06:02 PM
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
-- Database: `restaurant2`
--

-- --------------------------------------------------------

--
-- Table structure for table `jelo`
--

CREATE TABLE `jelo` (
  `jelo_id` int(11) NOT NULL,
  `cena` double DEFAULT NULL,
  `naziv` varchar(255) DEFAULT NULL,
  `opis` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `jelo`
--

INSERT INTO `jelo` (`jelo_id`, `cena`, `naziv`, `opis`) VALUES
(1, 12.99, 'Margherita Pizza', 'Classic pizza topped with tomato sauce, mozzarella cheese, and fresh basil.'),
(2, 18.99, 'Grilled Salmon', 'Freshly grilled salmon fillet served with roasted vegetables and lemon butter sauce.'),
(3, 14.99, 'Chicken Alfredo Pasta', 'Creamy fettuccine pasta tossed with grilled chicken, Parmesan cheese, and Alfredo sauce.'),
(4, 10.99, 'Cheeseburger', 'Juicy beef patty topped with melted cheese, lettuce, tomato, onion, and pickles, served with fries.'),
(5, 8.99, 'Caesar Salad', 'Crisp romaine lettuce, Parmesan cheese, croutons, and Caesar dressing.'),
(6, 6.99, 'Chocolate Brownie Sundae', 'Warm chocolate brownie topped with vanilla ice cream, whipped cream, and chocolate sauce.');

-- --------------------------------------------------------

--
-- Table structure for table `korisnik`
--

CREATE TABLE `korisnik` (
  `korisnik_id` int(11) NOT NULL,
  `ime` varchar(255) DEFAULT NULL,
  `korisnicko_ime` varchar(255) DEFAULT NULL,
  `lozinka` varchar(255) DEFAULT NULL,
  `plata` double DEFAULT NULL,
  `prezime` varchar(255) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `korisnik`
--

INSERT INTO `korisnik` (`korisnik_id`, `ime`, `korisnicko_ime`, `lozinka`, `plata`, `prezime`, `role_id`) VALUES
(1, 'Djole', 'Djolean', 'Djole', 100000, 'Ristic', 1),
(2, 'Marija', 'Marija', 'Marija', 90000, 'Markovic', 2),
(5, 'test', 'test', '$2y$10$1QsPQ.f1A91fmxY8xFdu.OGFWPHXJztqnSKc.TJCgXR/j2ZnNrpqa', 100000, 'test', 1);

-- --------------------------------------------------------

--
-- Table structure for table `narudzbina`
--

CREATE TABLE `narudzbina` (
  `narudzbina_id` int(11) NOT NULL,
  `datum` date DEFAULT NULL,
  `ukupna_cena` double DEFAULT NULL,
  `korisnik_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `narudzbina`
--

INSERT INTO `narudzbina` (`narudzbina_id`, `datum`, `ukupna_cena`, `korisnik_id`) VALUES
(1, '2023-06-07', 21.98, 5),
(2, '2023-06-07', 27.98, 5),
(3, '2023-06-07', NULL, 5),
(4, '2023-06-07', NULL, 5);

-- --------------------------------------------------------

--
-- Table structure for table `narudzbina_jelos`
--

CREATE TABLE `narudzbina_jelos` (
  `narudzbina_narudzbina_id` int(11) NOT NULL,
  `jelos_jelo_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `narudzbina_jelos`
--

INSERT INTO `narudzbina_jelos` (`narudzbina_narudzbina_id`, `jelos_jelo_id`) VALUES
(1, 4),
(1, 4),
(2, 1),
(2, 3);

-- --------------------------------------------------------

--
-- Table structure for table `placanje`
--

CREATE TABLE `placanje` (
  `placanje_id` int(11) NOT NULL,
  `barkod` binary(255) DEFAULT NULL,
  `datum_placanja` datetime(6) DEFAULT NULL,
  `narudzbina_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `placanje`
--

INSERT INTO `placanje` (`placanje_id`, `barkod`, `datum_placanja`, `narudzbina_id`) VALUES
(1, 0x295cdda9ad104d3c8e6254aced8f37f80000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000, '2023-06-07 16:23:44.000000', 1),
(2, 0x14478182494a453096e2b5fd6836e0340000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000, '2023-06-07 16:26:10.000000', 2);

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `role_id` int(11) NOT NULL,
  `naziv` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`role_id`, `naziv`) VALUES
(1, 'Admin'),
(2, 'User');

-- --------------------------------------------------------

--
-- Table structure for table `sto`
--

CREATE TABLE `sto` (
  `sto_id` int(11) NOT NULL,
  `zauzeto` bit(1) DEFAULT NULL,
  `narudzbina_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sto`
--

INSERT INTO `sto` (`sto_id`, `zauzeto`, `narudzbina_id`) VALUES
(1, b'0', NULL),
(2, b'1', 4),
(3, b'1', 3),
(4, b'0', NULL),
(5, b'0', NULL),
(6, b'0', NULL);

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
  ADD KEY `FK4rt7vilssgmb37geum3ubisqh` (`role_id`);

--
-- Indexes for table `narudzbina`
--
ALTER TABLE `narudzbina`
  ADD PRIMARY KEY (`narudzbina_id`),
  ADD KEY `FKtg9q36hdtsjm69jscig82lir7` (`korisnik_id`);

--
-- Indexes for table `narudzbina_jelos`
--
ALTER TABLE `narudzbina_jelos`
  ADD KEY `FK2qqj6g8u9phs9c4gfkenpvyse` (`jelos_jelo_id`),
  ADD KEY `FK5a7dxgv04nkjtfyh4bvxmmqf3` (`narudzbina_narudzbina_id`);

--
-- Indexes for table `placanje`
--
ALTER TABLE `placanje`
  ADD PRIMARY KEY (`placanje_id`),
  ADD KEY `FK5du64wlchc6jibu3vwmvveecj` (`narudzbina_id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`role_id`);

--
-- Indexes for table `sto`
--
ALTER TABLE `sto`
  ADD PRIMARY KEY (`sto_id`),
  ADD KEY `FKqof5u82pknhw3ovx2ggnre9g` (`narudzbina_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `jelo`
--
ALTER TABLE `jelo`
  MODIFY `jelo_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `korisnik`
--
ALTER TABLE `korisnik`
  MODIFY `korisnik_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `narudzbina`
--
ALTER TABLE `narudzbina`
  MODIFY `narudzbina_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `placanje`
--
ALTER TABLE `placanje`
  MODIFY `placanje_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `sto`
--
ALTER TABLE `sto`
  MODIFY `sto_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `korisnik`
--
ALTER TABLE `korisnik`
  ADD CONSTRAINT `FK4rt7vilssgmb37geum3ubisqh` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`);

--
-- Constraints for table `narudzbina`
--
ALTER TABLE `narudzbina`
  ADD CONSTRAINT `FKtg9q36hdtsjm69jscig82lir7` FOREIGN KEY (`korisnik_id`) REFERENCES `korisnik` (`korisnik_id`);

--
-- Constraints for table `narudzbina_jelos`
--
ALTER TABLE `narudzbina_jelos`
  ADD CONSTRAINT `FK2qqj6g8u9phs9c4gfkenpvyse` FOREIGN KEY (`jelos_jelo_id`) REFERENCES `jelo` (`jelo_id`),
  ADD CONSTRAINT `FK5a7dxgv04nkjtfyh4bvxmmqf3` FOREIGN KEY (`narudzbina_narudzbina_id`) REFERENCES `narudzbina` (`narudzbina_id`);

--
-- Constraints for table `placanje`
--
ALTER TABLE `placanje`
  ADD CONSTRAINT `FK5du64wlchc6jibu3vwmvveecj` FOREIGN KEY (`narudzbina_id`) REFERENCES `narudzbina` (`narudzbina_id`);

--
-- Constraints for table `sto`
--
ALTER TABLE `sto`
  ADD CONSTRAINT `FKqof5u82pknhw3ovx2ggnre9g` FOREIGN KEY (`narudzbina_id`) REFERENCES `narudzbina` (`narudzbina_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
