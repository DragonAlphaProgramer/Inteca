-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 16 Mar 2022, 16:17
-- Wersja serwera: 10.4.22-MariaDB
-- Wersja PHP: 8.0.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `zlot_rodzin`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `czlonkowie_rodzin`
--

CREATE TABLE `czlonkowie_rodzin` (
  `IdM` int(11) NOT NULL,
  `imie` varchar(100) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `nazwa` varchar(100) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `wiek` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `czlonkowie_rodzin`
--

INSERT INTO `czlonkowie_rodzin` (`IdM`, `imie`, `nazwa`, `wiek`) VALUES
(1, 'Gomez', 'Addams', 40),
(2, 'Morticia', 'Addams', 45),
(3, 'Fester', 'Addams', 50),
(4, 'Pugsley', 'Addams', 13),
(5, 'Wensdey', 'Addams', 15);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(7);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `rodziny`
--

CREATE TABLE `rodziny` (
  `IdR` int(11) NOT NULL,
  `Name` varchar(100) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `Infants` int(11) NOT NULL,
  `Children` int(11) NOT NULL,
  `Adults` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `rodziny`
--

INSERT INTO `rodziny` (`IdR`, `Name`, `Infants`, `Children`, `Adults`) VALUES
(6, 'Addams', 0, 2, 3);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `czlonkowie_rodzin`
--
ALTER TABLE `czlonkowie_rodzin`
  ADD PRIMARY KEY (`IdM`);

--
-- Indeksy dla tabeli `rodziny`
--
ALTER TABLE `rodziny`
  ADD PRIMARY KEY (`IdR`);

--
-- AUTO_INCREMENT dla zrzuconych tabel
--

--
-- AUTO_INCREMENT dla tabeli `czlonkowie_rodzin`
--
ALTER TABLE `czlonkowie_rodzin`
  MODIFY `IdM` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT dla tabeli `rodziny`
--
ALTER TABLE `rodziny`
  MODIFY `IdR` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
