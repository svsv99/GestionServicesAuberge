-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  sam. 27 mars 2021 à 10:47
-- Version du serveur :  10.3.16-MariaDB
-- Version de PHP :  7.3.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `serviceauberge`
--

-- --------------------------------------------------------

--
-- Structure de la table `chambre`
--

CREATE TABLE `chambre` (
  `idChambre` int(11) NOT NULL,
  `numChambre` varchar(250) NOT NULL,
  `typeChambre` varchar(250) NOT NULL,
  `descriptionChambre` varchar(250) NOT NULL,
  `prixChambre` int(11) NOT NULL,
  `statutChambre` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `chambre`
--

INSERT INTO `chambre` (`idChambre`, `numChambre`, `typeChambre`, `descriptionChambre`, `prixChambre`, `statutChambre`) VALUES
(1, 'CH004', 'Simple', 'Chambre simple pour une personne', 12000, 'Libre'),
(2, 'CH005', 'Double', 'chambre pour deux personnes', 20000, 'Libre'),
(3, 'CH-003', 'Simple', 'Chambre une personne', 12000, 'LIBRE');

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `idclient` int(11) NOT NULL,
  `matriculeClient` varchar(100) NOT NULL,
  `nomClient` varchar(100) NOT NULL,
  `prenomClient` varchar(100) NOT NULL,
  `adresseClient` varchar(100) NOT NULL,
  `telClient` varchar(100) NOT NULL,
  `emailClient` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`idclient`, `matriculeClient`, `nomClient`, `prenomClient`, `adresseClient`, `telClient`, `emailClient`, `username`, `password`) VALUES
(1, 'CLI_001', 'Salma', 'Djoumoi', 'Medina', '77889090', 'sasa@gmail.com', 'svsv', 'passer');

-- --------------------------------------------------------

--
-- Structure de la table `location`
--

CREATE TABLE `location` (
  `idLocation` int(11) NOT NULL,
  `numeroLocation` varchar(100) NOT NULL,
  `dateLocation` date NOT NULL,
  `dateDepart` date NOT NULL,
  `chambre` varchar(100) NOT NULL,
  `client` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `location`
--

INSERT INTO `location` (`idLocation`, `numeroLocation`, `dateLocation`, `dateDepart`, `chambre`, `client`) VALUES
(1, 'LO001', '2021-03-10', '2021-03-04', 'CH-003', 'Salma');

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

CREATE TABLE `reservation` (
  `idReservation` int(11) NOT NULL,
  `numReservation` varchar(250) NOT NULL,
  `dateReservation` date NOT NULL,
  `dateArrivee` date NOT NULL,
  `Chambre` varchar(250) NOT NULL,
  `Client` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `reservation`
--

INSERT INTO `reservation` (`idReservation`, `numReservation`, `dateReservation`, `dateArrivee`, `Chambre`, `Client`) VALUES
(1, 'Res004', '2021-03-01', '2021-03-17', 'CH-006', 'Mamadou Diop'),
(2, 'Res-005', '2021-02-09', '2021-03-02', 'CH-008', 'Honore Balsac'),
(3, 'RES-003', '2021-02-03', '2021-02-04', 'CH005', 'CLI_001');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `chambre`
--
ALTER TABLE `chambre`
  ADD PRIMARY KEY (`idChambre`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`idclient`);

--
-- Index pour la table `location`
--
ALTER TABLE `location`
  ADD PRIMARY KEY (`idLocation`);

--
-- Index pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`idReservation`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `chambre`
--
ALTER TABLE `chambre`
  MODIFY `idChambre` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=405;

--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `idclient` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=405;

--
-- AUTO_INCREMENT pour la table `location`
--
ALTER TABLE `location`
  MODIFY `idLocation` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=405;

--
-- AUTO_INCREMENT pour la table `reservation`
--
ALTER TABLE `reservation`
  MODIFY `idReservation` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=405;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
