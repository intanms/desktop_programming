-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jul 25, 2020 at 05:44 PM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `toko`
--

-- --------------------------------------------------------

--
-- Table structure for table `data_service`
--

CREATE TABLE `data_service` (
  `id_service` int(10) NOT NULL,
  `nm_services` varchar(30) NOT NULL,
  `harga` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `data_service`
--

INSERT INTO `data_service` (`id_service`, `nm_services`, `harga`) VALUES
(1, 'Ganti Oli', 40000),
(2, 'Ganti ban', 25000),
(4, 'Cuci stang', 2000),
(5, 'Cuci kaca', 2000),
(6, 'tambel ban', 15000);

-- --------------------------------------------------------

--
-- Table structure for table `isi`
--

CREATE TABLE `isi` (
  `id_services` int(5) NOT NULL,
  `no_services` varchar(10) NOT NULL,
  `id_service` int(10) NOT NULL,
  `jml_item` int(11) NOT NULL,
  `discount` int(10) NOT NULL,
  `jml_bayar` int(10) NOT NULL,
  `tgl_servis` date NOT NULL DEFAULT curdate(),
  `jam_servis` time NOT NULL DEFAULT curtime()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `isi`
--

INSERT INTO `isi` (`id_services`, `no_services`, `id_service`, `jml_item`, `discount`, `jml_bayar`, `tgl_servis`, `jam_servis`) VALUES
(1, 'S0001', 4, 2, 0, 4000, '2020-07-25', '20:27:01'),
(2, 'S0002', 4, 10, 0, 20000, '2020-07-25', '20:39:44'),
(3, 'S0003', 4, 5, 0, 10000, '2020-07-25', '21:34:21'),
(4, 'S0004', 2, 6, 10, 135000, '2020-07-25', '21:34:32');

-- --------------------------------------------------------

--
-- Table structure for table `isi_temp`
--

CREATE TABLE `isi_temp` (
  `id_txtemp2` int(5) NOT NULL,
  `no_services` varchar(10) NOT NULL,
  `nm_services` varchar(20) NOT NULL,
  `id_service` int(10) NOT NULL,
  `harga` int(10) NOT NULL,
  `jml_item` int(10) NOT NULL,
  `discount` int(10) NOT NULL,
  `jml_bayar` int(10) NOT NULL,
  `tanggal_servis` date NOT NULL DEFAULT curdate(),
  `jam_servis` time NOT NULL DEFAULT curtime()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `username` varchar(150) NOT NULL,
  `jb_tn` varchar(100) NOT NULL,
  `password` varchar(150) NOT NULL,
  `salt` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`username`, `jb_tn`, `password`, `salt`) VALUES
('admin', 'admin', '194acaa8bc400a0c681cdccd3163ac1b0a62a296303c5fd7a91a720a5993c87f', 'aee8c254a01f46df859113cffab2ec7e'),
('user', 'user', '47f04a7d942474cfc99a3a09da4d7dc6b5d6589aa678228c1ad8c85445a1095a', 'e3db1b7b273e42c183cb6fe75e81325b');

-- --------------------------------------------------------

--
-- Table structure for table `produk`
--

CREATE TABLE `produk` (
  `id_produk` int(10) NOT NULL,
  `nm_produk` varchar(150) DEFAULT NULL,
  `harga_produk` int(11) DEFAULT NULL,
  `modal_produk` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `produk`
--

INSERT INTO `produk` (`id_produk`, `nm_produk`, `harga_produk`, `modal_produk`) VALUES
(4, 'Oli', 15000, 14500),
(8, 'Sock Breaker', 30000, 25000),
(10, 'Jok', 100000, 90000),
(17, 'kampas rem', 50000, 45000);

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `id_transaksi` int(5) NOT NULL,
  `kode_transaksi` int(5) UNSIGNED ZEROFILL NOT NULL,
  `id_produk` int(5) NOT NULL,
  `total_item` int(3) NOT NULL,
  `tgl_transaksi` date NOT NULL DEFAULT current_timestamp(),
  `jam_transaksi` time NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`id_transaksi`, `kode_transaksi`, `id_produk`, `total_item`, `tgl_transaksi`, `jam_transaksi`) VALUES
(124, 00001, 4, 4, '2020-04-27', '12:47:15'),
(125, 00002, 8, 5, '2020-04-27', '12:57:12'),
(126, 00003, 10, 5, '2020-04-27', '12:57:23'),
(127, 00004, 2, 4, '2020-05-11', '08:25:30'),
(128, 00005, 7, 90, '2020-05-11', '08:25:55'),
(129, 00006, 10, 4, '2020-05-11', '11:03:40'),
(130, 00007, 12, 4, '2020-07-22', '16:20:44'),
(131, 00008, 4, 5, '2020-07-25', '21:33:51');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi_temp`
--

CREATE TABLE `transaksi_temp` (
  `id_txtemp` int(5) NOT NULL,
  `id_produk` int(5) NOT NULL,
  `nm_produk` varchar(100) NOT NULL,
  `harga_produk` int(10) NOT NULL,
  `total_item` int(3) NOT NULL,
  `tgl_transaksi` date NOT NULL DEFAULT current_timestamp(),
  `jam_transaksi` time NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `data_service`
--
ALTER TABLE `data_service`
  ADD PRIMARY KEY (`id_service`);

--
-- Indexes for table `isi`
--
ALTER TABLE `isi`
  ADD PRIMARY KEY (`id_services`);

--
-- Indexes for table `isi_temp`
--
ALTER TABLE `isi_temp`
  ADD PRIMARY KEY (`id_txtemp2`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `produk`
--
ALTER TABLE `produk`
  ADD PRIMARY KEY (`id_produk`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id_transaksi`);

--
-- Indexes for table `transaksi_temp`
--
ALTER TABLE `transaksi_temp`
  ADD PRIMARY KEY (`id_txtemp`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `data_service`
--
ALTER TABLE `data_service`
  MODIFY `id_service` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `isi`
--
ALTER TABLE `isi`
  MODIFY `id_services` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `isi_temp`
--
ALTER TABLE `isi_temp`
  MODIFY `id_txtemp2` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT for table `produk`
--
ALTER TABLE `produk`
  MODIFY `id_produk` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `id_transaksi` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=132;

--
-- AUTO_INCREMENT for table `transaksi_temp`
--
ALTER TABLE `transaksi_temp`
  MODIFY `id_txtemp` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
