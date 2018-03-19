-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Feb 09, 2018 at 05:59 AM
-- Server version: 5.6.11
-- PHP Version: 5.5.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `museum`
--
CREATE DATABASE IF NOT EXISTS `museum` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `museum`;

-- --------------------------------------------------------

--
-- Table structure for table `jenis_koleksi`
--

CREATE TABLE IF NOT EXISTS `jenis_koleksi` (
  `id_jenis` int(2) NOT NULL AUTO_INCREMENT,
  `nama_jenis_koleksi` varchar(50) NOT NULL,
  PRIMARY KEY (`id_jenis`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

--
-- Dumping data for table `jenis_koleksi`
--

INSERT INTO `jenis_koleksi` (`id_jenis`, `nama_jenis_koleksi`) VALUES
(4, 'Geologika'),
(5, 'Biologika'),
(6, 'Etnografika'),
(7, 'Arkeologika'),
(8, 'Historika'),
(9, 'Numismatika / Heraldika'),
(10, 'Filologika'),
(11, 'Keramologika'),
(12, 'Seni Rupa'),
(13, 'Teknologika');

-- --------------------------------------------------------

--
-- Table structure for table `kategori`
--

CREATE TABLE IF NOT EXISTS `kategori` (
  `id_kategori` int(2) NOT NULL AUTO_INCREMENT,
  `id_lantai` int(1) NOT NULL,
  `nama_kategori` varchar(50) NOT NULL,
  PRIMARY KEY (`id_kategori`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `kategori`
--

INSERT INTO `kategori` (`id_kategori`, `id_lantai`, `nama_kategori`) VALUES
(1, 1, 'Zaman Prasejarah'),
(2, 1, 'Lingkungan Alam Lampung'),
(3, 1, 'Kebudayaan Hindu Budha'),
(4, 1, 'Kebudayaan Islam'),
(5, 1, 'Sumber Daya Alam'),
(6, 1, 'Zaman Kolonial'),
(7, 1, 'Keramik'),
(8, 2, 'Perlengkapan Adat Pepadun'),
(9, 2, 'Tenunan'),
(10, 2, 'Perlengkapan Adat Saibatin');

-- --------------------------------------------------------

--
-- Table structure for table `koleksi`
--

CREATE TABLE IF NOT EXISTS `koleksi` (
  `id_koleksi` int(5) NOT NULL AUTO_INCREMENT,
  `id_kategori` int(2) NOT NULL,
  `id_jenis` int(2) NOT NULL,
  `id_lantai` int(1) NOT NULL,
  `gambar` varchar(250) NOT NULL,
  `nama_koleksi` varchar(50) NOT NULL,
  `deskripsi` text NOT NULL,
  `asal_koleksi` varchar(50) NOT NULL,
  `lokasi` text NOT NULL,
  PRIMARY KEY (`id_koleksi`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `koleksi`
--

INSERT INTO `koleksi` (`id_koleksi`, `id_kategori`, `id_jenis`, `id_lantai`, `gambar`, `nama_koleksi`, `deskripsi`, `asal_koleksi`, `lokasi`) VALUES
(5, 2, 5, 1, '12.jpg', 'Gajah Sumatera', 'Gajah sumatera adalah subspesies dari gajah asia yang hanya berhabitat di pulau Sumatera. Gajah sumatera berpostur lebih kecil daripada subspesies gajah india. Gajah sumatera merupakan mamalia terbesar di Indonesia, beratnya mencapai 6 ton dan tumbuh setinggi 3,5 meter pada bahu. Periode kehamilan untuk bayi gajah sumatera adalah 22 bulan dengan umur rata-rata sampai 70 tahun. Herbivora raksasa ini sangat cerdas dan memiliki otak yang lebih besar dibandingkan dengan mamalia darat lain. Telinga yang cukup besar membantu gajah mendengar dengan baik dan membantu mengurangi panas tubuh. Belalainya digunakan untuk mendapatkan makanan dan air dengan cara memegang atau menggenggam bagian ujungnya yang digunakan seperti jari untuk meraup.', 'Lampung Timur', 'Lantai 1 Kiri'),
(6, 2, 5, 1, 'localhost/museum/gambar_koleksi/6_2_5.jpg', 'Beruang Madu', 'Beruang madu atau dalam bahasa latin disebut Helarctos malayanus merupakan spesies (jenis) beruang terkecil dari delapan jenis beruang yang ada di dunia, mempunyai panjang tubuh sekitar 1,4 meter dengan tinggi punggungnya sekitar 70 cm. Beruang madu dewasa mempunyai berat tubuh antara 50-65 kg.\nBeruang madu hidup di hutan-hutan dataran rendah, hutan perbukitan, dan perbukitan atas sampai ketinggian 1.500 meter. Penyebarannya mulai dari Bangladesh; Brunei Darussalam, Kamboja, China, India, Indonesia, Laos, Malaysia, Myanmar, Thailand, dan Vietnam. Di Indonesia, Beruang madu terdapat di Pulau Sumatera dan Kalimantan.\nBeruang madu walaupun termasuk ke dalam ordo karnivora (pemakan daging) tetapi bersifat omnivora (pemakan segala), antara lain binatang-binatang kecil, burung, ayam hutan, buah-buahan dan daun-daun tertentu terutama pucuk-pucuk palem.', 'Pesawaran', 'Lantai 1 Kiri'),
(7, 2, 5, 1, 'localhost/museum/gambar_koleksi/7_2_5.jpg', 'Trenggiling', 'Mamalia dari ordo Pholidota. Satu keluarga yang masih ada, Manidae, Spesies ini berbagai ukuran dari 30 100 cm (12-39 in). Trenggiling ditemukan secara alami di daerah tropis di seluruh Afrika dan Asia. binatang ini hidup di daerah hutan hujan tropis dataran rendah. Makanannya adalah serangga terutama semut dan rayap.', 'Tanggamus', 'Lantai 1 Kiri'),
(8, 2, 5, 1, 'localhost/museum/gambar_koleksi/8_2_5.jpg', 'Trenggiling', 'Mamalia dari ordo Pholidota. Satu keluarga yang masih ada, Manidae, Spesies ini berbagai ukuran dari 30 100 cm (12-39 in). Trenggiling ditemukan secara alami di daerah tropis di seluruh Afrika dan Asia. binatang ini hidup di daerah hutan hujan tropis dataran rendah. Makanannya adalah serangga terutama semut dan rayap.', 'Tanggamus', 'Lantai 1 Kiri');

-- --------------------------------------------------------

--
-- Table structure for table `lantai`
--

CREATE TABLE IF NOT EXISTS `lantai` (
  `id_lantai` int(1) NOT NULL AUTO_INCREMENT,
  `lantai` varchar(50) NOT NULL,
  PRIMARY KEY (`id_lantai`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `lantai`
--

INSERT INTO `lantai` (`id_lantai`, `lantai`) VALUES
(1, 'Lantai 1'),
(2, 'Lantai 2');

-- --------------------------------------------------------

--
-- Table structure for table `usename`
--

CREATE TABLE IF NOT EXISTS `usename` (
  `id_user` int(1) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `lantai`
--
ALTER TABLE `lantai`
  ADD CONSTRAINT `lantai_ibfk_1` FOREIGN KEY (`id_lantai`) REFERENCES `kategori` (`id_kategori`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
