-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Mer 17 Février 2016 à 18:19
-- Version du serveur: 5.6.12-log
-- Version de PHP: 5.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `webservice`
--
CREATE DATABASE IF NOT EXISTS `webservice` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `webservice`;

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE IF NOT EXISTS `categorie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hashtag` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `categorie`
--

INSERT INTO `categorie` (`id`, `hashtag`) VALUES
(1, '#dealwithit');

-- --------------------------------------------------------

--
-- Structure de la table `dashboard`
--

CREATE TABLE IF NOT EXISTS `dashboard` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `label` varchar(30) NOT NULL,
  `utilisateur` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `dashboard`
--

INSERT INTO `dashboard` (`id`, `label`, `utilisateur`) VALUES
(1, 'mon premier dashboard', 1);

-- --------------------------------------------------------

--
-- Structure de la table `gif`
--

CREATE TABLE IF NOT EXISTS `gif` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(5) NOT NULL,
  `label` varchar(50) NOT NULL,
  `lien` varchar(250) NOT NULL,
  `site` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `site` (`site`),
  KEY `id_user` (`id_user`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=17 ;

--
-- Contenu de la table `gif`
--

INSERT INTO `gif` (`id`, `id_user`, `label`, `lien`, `site`) VALUES
(1, 1, 'saiyan', 'https://media.giphy.com/media/UIzgK9XXfH89W/giphy.gif', 1),
(2, 1, 'saiyan', 'https://media.giphy.com/media/nZwFxFXiQ44o/giphy.gif', 1),
(3, 1, 'saiyan', 'https://media.giphy.com/media/5vz3VR1fUMrny/giphy.gif', 1),
(4, 1, 'saiyan', 'https://media.giphy.com/media/KE4wnvmpN4C2s/giphy.gif', 1),
(5, 1, 'love', 'https://media.giphy.com/media/ZVfhlEEGbwuFG/giphy.gif', 1),
(6, 1, 'love', 'https://media.giphy.com/media/l41lIyhscOstSOOt2/giphy.gif', 1),
(7, 1, 'love', 'https://media.giphy.com/media/AOa3xz03AH4kg/giphy.gif', 1),
(8, 1, 'love', 'https://media.giphy.com/media/6zI0KUEik37Jm/giphy.gif', 1),
(9, 1, 'squirt', 'https://media.giphy.com/media/l41m04f4Eh5GGnYzK/giphy.gif', 1),
(10, 1, 'squirt', 'https://media.giphy.com/media/rz4XhX0hwke4g/giphy.gif', 1),
(11, 1, 'cat', 'https://s-media-cache-ak0.pinimg.com/originals/d9/d3/3a/d9d33a1277946a614ca663ea2ca55c9f.gif', 1),
(12, 1, 'squirt', 'https://media.giphy.com/media/lB8iMZ8bR4y0E/giphy.gif', 1);

-- --------------------------------------------------------

--
-- Structure de la table `groupe`
--

CREATE TABLE IF NOT EXISTS `groupe` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gif` int(11) NOT NULL,
  `categorie` int(11) DEFAULT NULL,
  `dashboard` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `gif` (`gif`),
  KEY `categorie` (`categorie`),
  KEY `dashboard` (`dashboard`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `groupe`
--

INSERT INTO `groupe` (`id`, `gif`, `categorie`, `dashboard`) VALUES
(1, 1, NULL, 1),
(2, 1, 1, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `site`
--

CREATE TABLE IF NOT EXISTS `site` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(30) NOT NULL,
  `adresse` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `site`
--

INSERT INTO `site` (`id`, `nom`, `adresse`) VALUES
(1, 'giphy', 'giphy.com');

-- --------------------------------------------------------

--
-- Structure de la table `token`
--

CREATE TABLE IF NOT EXISTS `token` (
  `id_user` int(10) NOT NULL,
  `token` varchar(64) NOT NULL,
  PRIMARY KEY (`id_user`,`token`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `token`
--

INSERT INTO `token` (`id_user`, `token`) VALUES
(1, 'test');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(30) NOT NULL,
  `password` varchar(50) NOT NULL,
  `mail` varchar(100) NOT NULL,
  `role` int(11) NOT NULL COMMENT '0=admin; 1=utilisateur',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `login`, `password`, `mail`, `role`) VALUES
(1, 'admin', 'YWRtaW4=', 'benjamin.tessier@epsi.fr', 0),
(2, 'user1', 'user1', 'mail@mail.fr', 1),
(7, 'etheirion', '1234', 'nathan@badaud.fr', 1);

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `gif`
--
ALTER TABLE `gif`
  ADD CONSTRAINT `gif_ibfk_1` FOREIGN KEY (`site`) REFERENCES `site` (`id`),
  ADD CONSTRAINT `gif_user` FOREIGN KEY (`id_user`) REFERENCES `utilisateur` (`id`);

--
-- Contraintes pour la table `groupe`
--
ALTER TABLE `groupe`
  ADD CONSTRAINT `groupe_ibfk_1` FOREIGN KEY (`gif`) REFERENCES `gif` (`id`),
  ADD CONSTRAINT `groupe_ibfk_2` FOREIGN KEY (`categorie`) REFERENCES `categorie` (`id`),
  ADD CONSTRAINT `groupe_ibfk_3` FOREIGN KEY (`dashboard`) REFERENCES `dashboard` (`id`);

--
-- Contraintes pour la table `token`
--
ALTER TABLE `token`
  ADD CONSTRAINT `useridtoken` FOREIGN KEY (`id_user`) REFERENCES `utilisateur` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
