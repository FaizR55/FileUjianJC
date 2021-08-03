-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 01, 2021 at 11:32 AM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `jpa`
--

-- --------------------------------------------------------

--
-- Table structure for table `dosen`
--

CREATE TABLE `dosen` (
  `id_dosen` bigint(20) NOT NULL,
  `nama_dosen` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `dosen`
--

INSERT INTO `dosen` (`id_dosen`, `nama_dosen`, `password`, `username`) VALUES
(1, 'dinda', 'prikitiew', 'dindaaa');

-- --------------------------------------------------------

--
-- Table structure for table `mahasiswa`
--

CREATE TABLE `mahasiswa` (
  `id_nim` bigint(20) NOT NULL,
  `jenis_kelamin` varchar(255) DEFAULT NULL,
  `nama_mahasiswa` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `mahasiswa`
--

INSERT INTO `mahasiswa` (`id_nim`, `jenis_kelamin`, `nama_mahasiswa`, `password`) VALUES
(1, 'Laki-laki', 'Bima', 'bimasehat');

-- --------------------------------------------------------

--
-- Table structure for table `matakuliah`
--

CREATE TABLE `matakuliah` (
  `id_matakuliah` bigint(20) NOT NULL,
  `nama_matakuliah` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `matakuliah`
--

INSERT INTO `matakuliah` (`id_matakuliah`, `nama_matakuliah`) VALUES
(1, 'Industri');

-- --------------------------------------------------------

--
-- Table structure for table `nilai`
--

CREATE TABLE `nilai` (
  `id_soal` bigint(20) NOT NULL,
  `nilai` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `nilai`
--

INSERT INTO `nilai` (`id_soal`, `nilai`) VALUES
(1, 20),
(2, 30);

-- --------------------------------------------------------

--
-- Table structure for table `pertanyaan`
--

CREATE TABLE `pertanyaan` (
  `id_pertanyaan` bigint(20) NOT NULL,
  `jawaban_1` varchar(255) DEFAULT NULL,
  `jawaban_2` varchar(255) DEFAULT NULL,
  `jawaban_3` varchar(255) DEFAULT NULL,
  `jawaban_4` varchar(255) DEFAULT NULL,
  `jawaban_benar` varchar(255) DEFAULT NULL,
  `pertanyaan` varchar(255) DEFAULT NULL,
  `jawaban_gambar` varchar(255) DEFAULT NULL,
  `soal_id` bigint(20) DEFAULT NULL,
  `detail_nilai` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pertanyaan`
--

INSERT INTO `pertanyaan` (`id_pertanyaan`, `jawaban_1`, `jawaban_2`, `jawaban_3`, `jawaban_4`, `jawaban_benar`, `pertanyaan`, `jawaban_gambar`, `soal_id`, `detail_nilai`) VALUES
(3, 'paru-paru', 'trakea', 'jantung', 'insang', 'insang', 'ikan bernafas dengan?', 'ikan', 2, 1),
(4, 'paru-paru', 'trakea', 'jantung', 'insang', 'trakea', 'burung bernafas dengan?', 'burung', 2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `plot_mata_kuliah`
--

CREATE TABLE `plot_mata_kuliah` (
  `id_plotmk` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `plot_mata_kuliah`
--

INSERT INTO `plot_mata_kuliah` (`id_plotmk`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `plot_mata_kuliah_lstdosen`
--

CREATE TABLE `plot_mata_kuliah_lstdosen` (
  `plotmk` bigint(20) NOT NULL,
  `dosen_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `plot_mata_kuliah_lstdosen`
--

INSERT INTO `plot_mata_kuliah_lstdosen` (`plotmk`, `dosen_id`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `plot_mata_kuliah_lstmahasiswa`
--

CREATE TABLE `plot_mata_kuliah_lstmahasiswa` (
  `plotmk` bigint(20) NOT NULL,
  `nim_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `plot_mata_kuliah_lstmahasiswa`
--

INSERT INTO `plot_mata_kuliah_lstmahasiswa` (`plotmk`, `nim_id`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `plot_mata_kuliah_lstmatakuliah`
--

CREATE TABLE `plot_mata_kuliah_lstmatakuliah` (
  `plotmk` bigint(20) NOT NULL,
  `mata_kuliah_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `plot_mata_kuliah_lstmatakuliah`
--

INSERT INTO `plot_mata_kuliah_lstmatakuliah` (`plotmk`, `mata_kuliah_id`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `soal`
--

CREATE TABLE `soal` (
  `id_soal` bigint(20) NOT NULL,
  `nama_soal` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `soal`
--

INSERT INTO `soal` (`id_soal`, `nama_soal`, `status`) VALUES
(2, 'Biologi', '2_Pertanyaan');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dosen`
--
ALTER TABLE `dosen`
  ADD PRIMARY KEY (`id_dosen`);

--
-- Indexes for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD PRIMARY KEY (`id_nim`);

--
-- Indexes for table `matakuliah`
--
ALTER TABLE `matakuliah`
  ADD PRIMARY KEY (`id_matakuliah`);

--
-- Indexes for table `nilai`
--
ALTER TABLE `nilai`
  ADD PRIMARY KEY (`id_soal`);

--
-- Indexes for table `pertanyaan`
--
ALTER TABLE `pertanyaan`
  ADD PRIMARY KEY (`id_pertanyaan`),
  ADD KEY `FKq6spd0kb6489e2f84kuvuaemg` (`detail_nilai`),
  ADD KEY `FKd6m65k3vr9bur3x5wt8q3flqh` (`soal_id`);

--
-- Indexes for table `plot_mata_kuliah`
--
ALTER TABLE `plot_mata_kuliah`
  ADD PRIMARY KEY (`id_plotmk`);

--
-- Indexes for table `plot_mata_kuliah_lstdosen`
--
ALTER TABLE `plot_mata_kuliah_lstdosen`
  ADD KEY `FKi4bjr203654qj5487c630x46w` (`dosen_id`),
  ADD KEY `FKebkjpxqmk8vw7ecdob4digbxo` (`plotmk`);

--
-- Indexes for table `plot_mata_kuliah_lstmahasiswa`
--
ALTER TABLE `plot_mata_kuliah_lstmahasiswa`
  ADD KEY `FKk69l6omwv6ah9q1uj4agkk2um` (`nim_id`),
  ADD KEY `FK7waoyc3ncocirudn9cdmbd2ej` (`plotmk`);

--
-- Indexes for table `plot_mata_kuliah_lstmatakuliah`
--
ALTER TABLE `plot_mata_kuliah_lstmatakuliah`
  ADD KEY `FKhejns0cu8qknvbv09lfdjvpn8` (`mata_kuliah_id`),
  ADD KEY `FKsvfbcy8dv78m1a12dsf2ffnce` (`plotmk`);

--
-- Indexes for table `soal`
--
ALTER TABLE `soal`
  ADD PRIMARY KEY (`id_soal`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `dosen`
--
ALTER TABLE `dosen`
  MODIFY `id_dosen` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  MODIFY `id_nim` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `matakuliah`
--
ALTER TABLE `matakuliah`
  MODIFY `id_matakuliah` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `nilai`
--
ALTER TABLE `nilai`
  MODIFY `id_soal` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `pertanyaan`
--
ALTER TABLE `pertanyaan`
  MODIFY `id_pertanyaan` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `plot_mata_kuliah`
--
ALTER TABLE `plot_mata_kuliah`
  MODIFY `id_plotmk` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `soal`
--
ALTER TABLE `soal`
  MODIFY `id_soal` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
