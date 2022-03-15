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
  `IdR` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `Infants` int(11) NOT NULL,
  `Children` int(11) NOT NULL,
  `Adults` int(11) NOT NULL,
  PRIMARY KEY (`IdR`)
) ;

CREATE TABLE `czlonkowie_rodzin` (
  `IdM` int(11) NOT NULL AUTO_INCREMENT,
  `imie` varchar(100) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `nazwa` varchar(100) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `wiek` int(11) NOT NULL,
  PRIMARY KEY (`IdM`)
);
