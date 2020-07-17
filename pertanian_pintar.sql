-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 17 Jul 2020 pada 08.27
-- Versi server: 10.4.11-MariaDB
-- Versi PHP: 7.2.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pertanian_pintar`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `montion_tanam`
--

CREATE TABLE `montion_tanam` (
  `id_tanaman` int(2) NOT NULL,
  `tanam` int(2) NOT NULL,
  `gcode` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `montion_tanam`
--

INSERT INTO `montion_tanam` (`id_tanaman`, `tanam`, `gcode`) VALUES
(1, 0, 'jashdhsbjdsbchbwhjcbcshbhsdhasbdjasdyhbwhdbhsbhsachwb'),
(2, 0, 'jashdhsbjdsbchbwhjcbcshbhsdhasbdjasdyhbwhdbhsbhsachwb'),
(3, 0, 'jashdhsbjdsbchbwhjcbcshbhsdhasbdjasdyhbwhdbhsbhsachwb'),
(4, 0, 'jashdhsbjdsbchbwhjcbcshbhsdhasbdjasdyhbwhdbhsbhsachwb'),
(5, 0, 'jashdhsbjdsbchbwhjcbcshbhsdhasbdjasdyhbwhdbhsbhsachwb'),
(6, 0, 'jashdhsbjdsbchbwhjcbcshbhsdhasbdjasdyhbwhdbhsbhsachwb');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tanaman`
--

CREATE TABLE `tanaman` (
  `id_tanaman` int(3) NOT NULL,
  `nama_tanaman` varchar(150) NOT NULL,
  `posisi` varchar(3) NOT NULL,
  `gcode` varchar(200) NOT NULL,
  `umur_tanaman` int(4) NOT NULL,
  `kadar_air` int(5) NOT NULL,
  `suhu` int(5) NOT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tanaman`
--

INSERT INTO `tanaman` (`id_tanaman`, `nama_tanaman`, `posisi`, `gcode`, `umur_tanaman`, `kadar_air`, `suhu`, `status`) VALUES
(0, 'sawi 01', '1', 'G21 G91 G0 X0 Y0 G0 Z100 F1000 G0 X106 Y9 F1000 G0 Z-44 F1000 G90 M8 G91 G0 Z43 F1000 G0 X-2 Y78 F1000 G0 Z-75 F1000 G90 M2 G91 G0 Z75 F100', 1, 0, 0, 'aktif'),
(1, 'sawi 02', '2', 'M8 G91 G0 Z43 F1000 G0 X-52 Y78 F1000 G0 Z-90 F1000 G90 M2 G91 G0 Z90 F1000 G0 X52 Y-78 F1000 G0 Z-44 F1000 G90', 25, 80, 90, 'aktif'),
(2, 'sawi 03', '3', 'M8 G91 G0 Z44 F1000 G0 X-2 Y136 F1000 G0 Z-75 F1000 G90 M2 G91 G0 Z75 F1000 G0 X2 Y-136 F1000 G0 Z-44 F1000 G90', 1, 0, 0, 'aktif'),
(3, 'sawi 04', '4', 'M8 G91 G0 Z44 F1000 G0 X-52 Y136 F1000 G0 Z-90 F1000 G90 M2 G91 G0 Z90 F1000 G0 X52 Y-136 F1000 G0 Z-44 F1000 G90', 7, 0, 0, 'kosong'),
(4, 'sawi 05', '5', 'M8 G91 nG0 Z44 F1000 G0 X-52 Y194 F1000 G0 Z-90 F1000 G90 M2 G91 G0 Z75 F1000 G0 X52 Y-194 F1000 G0 Z-44 F1000 G90 G91 G0 Z44 F1000 G0 X-106 Y-9 F1000', 1, 70, 28, 'aktif'),
(5, 'sawi 06', '6', 'M8 G91 G0 Z44 F1000 G0 X-52 Y194 F1000 G0 Z-90 F1000 G90 M2 G91 G0 Z75 F1000 G0 X52 Y-194 F1000 G0 Z-44 F1000 G90 G91  G0 Z44 F1000 G0 X-106 Y-9 F1000 G0 Z-100 F1000 G90 G21', 1, 0, 0, 'aktif');

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `id` int(3) NOT NULL,
  `username` varchar(50) NOT NULL,
  `pin` varchar(10) NOT NULL,
  `log` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`id`, `username`, `pin`, `log`) VALUES
(1, 'mustafi', '12345', ''),
(3, 'senja', '54321', '');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `montion_tanam`
--
ALTER TABLE `montion_tanam`
  ADD PRIMARY KEY (`id_tanaman`);

--
-- Indeks untuk tabel `tanaman`
--
ALTER TABLE `tanaman`
  ADD PRIMARY KEY (`id_tanaman`);

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `user`
--
ALTER TABLE `user`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
