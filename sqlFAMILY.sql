create database `familia`;
USE `familia`;
CREATE TABLE `rodziny` (
  `Id` numeric NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `nazwa` varchar(100) COLLATE utf8_polish_ci NOT NULL,
  `liczba niemowlat` int NOT NULL,
`liczba dzieci` int NOT NULL,
`liczba doroslych` int NOT NULL
);

CREATE TABLE `czlonkowie rodzin` (
  `Id` numeric NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `nazwa` varchar(100) COLLATE utf8_polish_ci NOT NULL,
  `wiek` int NOT NULL
);