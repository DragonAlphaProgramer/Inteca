/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  PatrykK
 * Created: 28 lut 2022
 */
create database `zlot_rodzin`;
USE `zlot_rodzin`;


CREATE TABLE `rodziny` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `nazwa` varchar(100) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `niemowleta` int(11) NOT NULL,
  `dzieci` int(11) NOT NULL,
  `dorosli` int(11) NOT NULL,
  PRIMARY KEY (`Id`)
) ;

CREATE TABLE `czlonkowie rodzin` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `imie` varchar(100) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `nazwa` varchar(100) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `wiek` int(11) NOT NULL,
  PRIMARY KEY (`Id`)
);
