-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 13, 2024 at 06:18 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bkshop`
--
CREATE DATABASE IF NOT EXISTS `bkshop` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `bkshop`;

-- --------------------------------------------------------

--
-- Table structure for table `danhmuc`
--

CREATE TABLE `danhmuc` (
  `MaDanhMuc` int(11) NOT NULL,
  `TenDanhMuc` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `danhmuc`
--

INSERT INTO `danhmuc` (`MaDanhMuc`, `TenDanhMuc`) VALUES
(1, 'Đồ Ăn'),
(2, 'Quần Áo'),
(3, 'Đồ điện tử'),
(4, 'Gia dụng');

-- --------------------------------------------------------

--
-- Table structure for table `sanpham`
--

CREATE TABLE `sanpham` (
  `MaSanPham` int(11) NOT NULL,
  `TenSanPham` varchar(255) NOT NULL,
  `Gia` decimal(10,2) NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `MoTa` text DEFAULT NULL,
  `MaDanhMuc` int(11) DEFAULT NULL,
  `Anh` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `sanpham`
--

INSERT INTO `sanpham` (`MaSanPham`, `TenSanPham`, `Gia`, `SoLuong`, `MoTa`, `MaDanhMuc`, `Anh`) VALUES
(1, 'Mứt dâu', 80000.00, 25, 'Mứt dâu tươi', 1, 'https://i.pinimg.com/564x/21/e3/62/21e362bc8cdd9c1066e65a6a2027c4c8.jpg'),
(2, 'Cà Chua', 2000.00, 73, 'Cà chua hái', 1, 'https://i.pinimg.com/564x/b6/e3/70/b6e370513035452e463b2a6587b022df.jpg'),
(3, 'Đồ bộ', 230000.00, 33, 'Quần áo đi ngủ', 2, 'https://i.pinimg.com/564x/5c/6c/32/5c6c32af3c3d8d8e3c5941fe42d8589c.jpg'),
(4, 'Flip phone', 1099000.00, 10, 'silver flip phone by/with sprint', 3, 'https://i.pinimg.com/564x/32/4f/11/324f11b37f893ca1527bef91b55b7ec9.jpg'),
(5, 'Casual Oufit', 500700.00, 18, 'Casual oufit for casual day', 2, 'https://i.pinimg.com/564x/1a/c2/18/1ac2186c1582a5a88816813fc3710940.jpg'),
(6, 'Flip flops', 46500.00, 11, 'Cute flip flops', 2, 'https://i.pinimg.com/564x/9e/9e/8f/9e9e8f4410d385b14a490df06f3c906a.jpg'),
(7, 'Ghế', 750000.00, 55, 'Ghế ngồi sofa', 4, 'https://i.pinimg.com/originals/0e/a8/47/0ea847d4cf8b8320d7e8016004d37464.gif');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `danhmuc`
--
ALTER TABLE `danhmuc`
  ADD PRIMARY KEY (`MaDanhMuc`);

--
-- Indexes for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`MaSanPham`),
  ADD KEY `MaDanhMuc` (`MaDanhMuc`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `danhmuc`
--
ALTER TABLE `danhmuc`
  MODIFY `MaDanhMuc` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `MaSanPham` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD CONSTRAINT `sanpham_ibfk_1` FOREIGN KEY (`MaDanhMuc`) REFERENCES `danhmuc` (`MaDanhMuc`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
