
-- phpMyAdmin SQL Dump
-- version 2.6.1
-- http://www.phpmyadmin.net
-- 
-- ����: localhost
-- ����� ��������: ��� 17 2020 �., 01:03
-- ������ �������: 5.0.45
-- ������ PHP: 5.2.6
-- 
-- ��: `JavaAdvance06`
-- 

-- --------------------------------------------------------


-- 
-- ��������� ������� `HomeWork06`
-- 

CREATE TABLE `HomeWork06` (
  `id` int(11) NOT NULL auto_increment,
  `Value` varchar(1000) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

-- 
-- ���� ������ ������� `HomeWork06`
-- 

INSERT INTO `HomeWork06` VALUES (1, 'Test1');
INSERT INTO `HomeWork06` VALUES (2, 'Test2');


-- 
-- ��������� ������� `Users`
-- 

CREATE TABLE `Users` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(100) character set utf8 default NULL,
  `password` varchar(100) character set utf8 default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=cp1251 AUTO_INCREMENT=2 ;

-- 
-- ���� ������ ������� `Users`
-- 

INSERT INTO `Users` VALUES (1, 'Test', 'test');