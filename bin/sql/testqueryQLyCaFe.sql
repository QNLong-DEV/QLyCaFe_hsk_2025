-- Bảng KhachHang
CREATE TABLE KhachHang (
    MaKH NVARCHAR(50) PRIMARY KEY,
    TenKH NVARCHAR(100),
    Sdt VARCHAR(15),
	LoaiKH NVARCHAR(50) CHECK (LoaiKH IN (N'Vãng lai', N'Tiềm năng', N'Thân thiết')),
    NgayDangKy DATE
);

-- Bảng DonHang
CREATE TABLE DonHang (
    MaDH NVARCHAR(50) PRIMARY KEY,
    MaKH NVARCHAR(50),
    MaNV NVARCHAR(50),
    NgayDatHang DATETIME,
    TongTien DECIMAL(18,2),
    FOREIGN KEY (MaKH) REFERENCES KhachHang(MaKH),
	FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV)
    
);

-- Bảng ChiTietDonHang
CREATE TABLE ChiTietDonHang (
    MaDH NVARCHAR(50),
    MaNuoc NVARCHAR(50),
    SoLuong INT,
    DonGia DECIMAL(18,2),
    ThanhTien DECIMAL(18,2),
    PRIMARY KEY (MaDH, MaNuoc),
    FOREIGN KEY (MaDH) REFERENCES DonHang(MaDH),
    FOREIGN KEY (MaNuoc) REFERENCES Nuoc(MaNuoc)
);
INSERT INTO KhachHang (MaKH, TenKH, Sdt, LoaiKH, NgayDangKy)
VALUES ('VL01', 'Vãng Lai', 'xxx', 'Vãng lai', GETDATE());

INSERT INTO KhachHang (MaKH, TenKH, Sdt, LoaiKH, NgayDangKy) VALUES
(N'KH001', N'Nguyễn Văn A', '0901000001', N'Vãng lai', '2024-01-10'),
(N'KH002', N'Trần Thị B', '0901000002', N'Tiềm năng', '2024-02-15'),
(N'KH003', N'Lê Văn C', '0901000003', N'Thân thiết', '2023-12-20'),
(N'KH004', N'Phạm Thị D', '0901000004', N'Vãng lai', '2024-03-05'),
(N'KH005', N'Hồ Văn E', '0901000005', N'Tiềm năng', '2024-01-22'),
(N'KH006', N'Đỗ Thị F', '0901000006', N'Thân thiết', '2023-11-11'),
(N'KH007', N'Vũ Văn G', '0901000007', N'Tiềm năng', '2024-03-17'),
(N'KH008', N'Bùi Thị H', '0901000008', N'Vãng lai', '2024-04-01'),
(N'KH009', N'Ngô Văn I', '0901000009', N'Thân thiết', '2023-10-25'),
(N'KH010', N'Hoàng Thị J', '0901000010', N'Vãng lai', '2024-02-01'),
(N'KH011', N'Nguyễn Văn K', '0901000011', N'Thân thiết', '2024-01-28'),
(N'KH012', N'Trịnh Thị L', '0901000012', N'Tiềm năng', '2023-09-14'),
(N'KH013', N'Đặng Văn M', '0901000013', N'Thân thiết', '2024-03-30'),
(N'KH014', N'Phan Thị N', '0901000014', N'Vãng lai', '2024-04-20'),
(N'KH015', N'Nguyễn Thị O', '0901000015', N'Tiềm năng', '2023-12-05'),
(N'KH016', N'Lâm Văn P', '0901000016', N'Thân thiết', '2024-01-12'),
(N'KH017', N'Tạ Thị Q', '0901000017', N'Vãng lai', '2024-03-11'),
(N'KH018', N'Cao Văn R', '0901000018', N'Thân thiết', '2024-02-26'),
(N'KH019', N'Tống Thị S', '0901000019', N'Tiềm năng', '2023-11-08'),
(N'KH020', N'Mai Văn T', '0901000020', N'Thân thiết', '2024-04-10');

0901000001
INSERT INTO Nuoc (MaNuoc, TenNuoc, Gia, Loai, Img) VALUES
('N001', N'Cà Phê Bơ Arabica', 49000.00, N'Cà phê', 'caphe1.png'),
('N002', N'Cà Phê Đường Đen Sữa Đá', 45000.00, N'Cà phê', 'caphe2.png'),
('N003', N'Bạc Xỉu', 29000.00, N'Cà phê', 'caphe3.png'),
('N004', N'Bạc Xỉu Nóng', 39000.00, N'Cà phê', 'caphe4.png'),
('N005', N'Cà Phê Đen Nóng', 39000.00, N'Cà phê', 'caphe5.png'),
('N006', N'Cà Phê Đen Đá', 29000.00, N'Cà phê', 'caphe6.png'),
('N007', N'Cappuccino Nóng', 55000.00, N'Cà phê', 'caphe7.png'),
('N008', N'Espresso Nóng', 45000.00, N'Cà phê', 'caphe8.png'),
('N009', N'Caramel Macchiato Đá', 65000.00, N'Cà phê', 'caphe9.png'),
('N010', N'Caramel Macchiato Nóng', 55000.00, N'Cà phê', 'caphe10.png'),
('N011', N'Trà Xanh Latte (Nóng)', 49000.00, N'Trà xanh', 'traxanh1.png'),
('N012', N'Trà Xanh Latte', 45000.00, N'Trà xanh', 'traxanh2.png'),
('N013', N'Trà Xanh Espresso Marble', 49000.00, N'Trà xanh', 'traxanh3.png'),
('N014', N'Trà Xanh Latte Đậm Vị', 49000.00, N'Trà xanh', 'traxanh4.png'),
('N015', N'Trà Xanh Đường Đen', 55000.00, N'Trà xanh', 'traxanh5.png'),
('N016', N'Oolong Tứ Quý Vải', 49000.00, N'Trà trái cây', 'traicay1.png'),
('N017', N'Oolong Tứ Quý Kim Quất Trân Châu', 49000.00, N'Trà trái cây', 'traicay2.png'),
('N018', N'Oolong Tứ Quý Sen (Nóng)', 59000.00, N'Trà trái cây', 'traicay3.png'),
('N019', N'Oolong Tứ Quý Sen', 49000.00, N'Trà trái cây', 'traicay4.png'),
('N020', N'Trà Sữa Oolong Tứ Quý Sương Sáo', 55000.00, N'Trà sữa', 'trasua1.png'),
('N021', N'Trà Sữa Oolong Tứ Quý Bơ', 59000.00, N'Trà sữa', 'trasua2.png'),
('N022', N'Hồng Trà Sữa Trân Châu', 55000.00, N'Trà sữa', 'trasua3.png'),
('N023', N'Trà Sữa Oolong Nướng Sương Sáo', 55000.00, N'Trà sữa', 'trasua4.png'),
('N024', N'Hồng Trà Sữa Nóng', 55000.00, N'Trà sữa', 'trasua5.png'),
('N025', N'Frosty Choco Chip', 59000.00, N'Frosty', 'frosty1.png'),
('N026', N'Frosty Bánh Kem Dâu', 59000.00, N'Frosty', 'frosty2.png'),
('N027', N'Frosty Trà Xanh', 59000.00, N'Frosty', 'frosty3.png'),
('N028', N'Frosty Cà Phê Đường Đen', 59000.00, N'Frosty', 'frosty4.png');



select * from DonHang 
select * from NhanVien
select * from ChiTietDonHang
select * from KhachHang
select * from Nuoc
select * from BaoCao

DELETE FROM ChiTietDonHang;
DELETE FROM DonHang;
DELETE FROM KhachHang;
DELETE FROM Nuoc;

ALTER TABLE DonHang
ALTER COLUMN NgayDatHang DATETIME;

ALTER TABLE DonHang
ADD LoaiKH  NVARCHAR(50);

INSERT INTO DonHang (MaDH, MaKH, MaNV, NgayDatHang, TongTien, LoaiKH)
VALUES
('DH-15012024-10:15:30-KH1', 'KH1', 'NV001', '2024-01-15 10:15:30.000', 120000.00, 'Tiềm năng'),
('DH-20012024-14:45:10-KH2', 'KH2', 'NV002', '2024-01-20 14:45:10.000', 98000.00, 'Tiềm năng'),

('DH-05022024-09:05:45-KH3', 'KH3', 'NV003', '2023-02-05 09:05:45.000', 135000.00, 'Tiềm năng'),
('DH-18022024-16:25:55-KH4', 'KH4', 'NV004', '2022-02-18 16:25:55.000', 112000.00, 'Tiềm năng'),

('DH-10032024-11:35:20-KH5', 'KH5', 'NV005', '2022-03-10 11:35:20.000', 147500.00, 'Tiềm năng'),
('DH-23032024-17:55:50-KH6', 'KH6', 'NV006', '2024-03-23 17:55:50.000', 102000.00, 'Tiềm năng'),

('DH-07042024-08:10:00-KH7', 'KH7', 'NV007', '2022-04-07 08:10:00.000', 88000.00, 'Tiềm năng'),
('DH-22042024-13:40:30-KH8', 'KH8', 'NV008', '2023-04-22 13:40:30.000', 99000.00, 'Tiềm năng'),

('DH-03052024-15:20:40-KH7', 'KH7', 'NV009', '2023-05-03 15:20:40.000', 122500.00, 'Tiềm năng'),
('DH-17052024-19:00:15-KH7', 'KH7', 'NV010', '2022-05-17 19:00:15.000', 110000.00, 'Tiềm năng'),

('DH-12062024-09:45:25-KH3', 'KH3', 'NV011', '2024-06-12 09:45:25.000', 134000.00, 'Tiềm năng'),
('DH-25062024-18:30:35-KH3', 'KH3', 'NV012', '2024-06-25 18:30:35.000', 107500.00, 'Tiềm năng');


INSERT INTO ChiTietDonHang (MaDH, MaNuoc, SoLuong, DonGia, ThanhTien) VALUES
-- Đơn hàng DH-15012024-10:15:30-KH1
('DH-15012024-10:15:30-KH1', 'N001', 2, 49000.00, 98000.00), -- Cà Phê Bơ Arabica
('DH-15012024-10:15:30-KH1', 'N002', 1, 45000.00, 45000.00), -- Cà Phê Đường Đen Sữa Đá

-- Đơn hàng DH-20012024-14:45:10-KH2
('DH-20012024-14:45:10-KH2', 'N003', 1, 29000.00, 29000.00), -- Bạc Xỉu
('DH-20012024-14:45:10-KH2', 'N004', 2, 39000.00, 78000.00), -- Bạc Xỉu Nóng

-- Đơn hàng DH-05022024-09:05:45-KH3
('DH-05022024-09:05:45-KH3', 'N005', 3, 39000.00, 117000.00), -- Cà Phê Đen Nóng
('DH-05022024-09:05:45-KH3', 'N006', 1, 29000.00, 29000.00), -- Cà Phê Đen Đá

-- Đơn hàng DH-18022024-16:25:55-KH4
('DH-18022024-16:25:55-KH4', 'N007', 1, 55000.00, 55000.00), -- Cappuccino Nóng
('DH-18022024-16:25:55-KH4', 'N008', 1, 45000.00, 45000.00), -- Espresso Nóng

-- Đơn hàng DH-10032024-11:35:20-KH5
('DH-10032024-11:35:20-KH5', 'N009', 2, 65000.00, 130000.00), -- Caramel Macchiato Đá
('DH-10032024-11:35:20-KH5', 'N010', 1, 55000.00, 55000.00), -- Caramel Macchiato Nóng

-- Đơn hàng DH-23032024-17:55:50-KH6
('DH-23032024-17:55:50-KH6', 'N011', 2, 49000.00, 98000.00), -- Trà Xanh Latte (Nóng)
('DH-23032024-17:55:50-KH6', 'N012', 1, 45000.00, 45000.00), -- Trà Xanh Latte

-- Đơn hàng DH-07042024-08:10:00-KH7
('DH-07042024-08:10:00-KH7', 'N013', 1, 49000.00, 49000.00), -- Trà Xanh Espresso Marble
('DH-07042024-08:10:00-KH7', 'N014', 1, 49000.00, 49000.00), -- Trà Xanh Latte Đậm Vị

-- Đơn hàng DH-22042024-13:40:30-KH8
('DH-22042024-13:40:30-KH8', 'N015', 1, 55000.00, 55000.00), -- Trà Xanh Đường Đen
('DH-22042024-13:40:30-KH8', 'N016', 2, 49000.00, 98000.00), -- Oolong Tứ Quý Vải

-- Đơn hàng DH-03052024-15:20:40-KH7
('DH-03052024-15:20:40-KH7', 'N017', 1, 49000.00, 49000.00), -- Oolong Tứ Quý Kim Quất Trân Châu
('DH-03052024-15:20:40-KH7', 'N018', 2, 59000.00, 118000.00), -- Oolong Tứ Quý Sen (Nóng)

-- Đơn hàng DH-17052024-19:00:15-KH7
('DH-17052024-19:00:15-KH7', 'N019', 1, 49000.00, 49000.00), -- Oolong Tứ Quý Sen
('DH-17052024-19:00:15-KH7', 'N020', 1, 55000.00, 55000.00), -- Trà Sữa Oolong Tứ Quý Sương Sáo

-- Đơn hàng DH-12062024-09:45:25-KH3
('DH-12062024-09:45:25-KH3', 'N021', 2, 59000.00, 118000.00), -- Trà Sữa Oolong Tứ Quý Bơ
('DH-12062024-09:45:25-KH3', 'N022', 1, 55000.00, 55000.00); -- Hồng Trà Sữa Trân Châu

select Ngay, sum(TongDoanhThu) as DoanhThu, sum(TongSoDon) as TongSoDon from BaoCao group by Ngay order by Ngay

SELECT CAST(DH.NgayDatHang AS DATE) AS thoiGian,
		SUM(CTDH.SoLuong * CTDH.DonGia) AS tongDoanhThu,
		COUNT(DISTINCT DH.MaDH) AS tongDon
		FROM DonHang DH
					    JOIN ChiTietDonHang CTDH ON DH.MaDH = CTDH.MaDH
					    JOIN KhachHang KH ON DH.MaKH = KH.MaKH
					    WHERE KH.SDT = '0933354446'
					    GROUP BY CAST(DH.NgayDatHang AS DATE)
					    ORDER BY thoiGian ASC

SELECT 
    Nuoc.MaNuoc,
    Nuoc.TenNuoc,
    Nuoc.Gia,
    Nuoc.Loai,
    SUM(ChiTietDonHang.SoLuong) AS TongSoLuongDat,
    MONTH(DonHang.NgayDatHang) AS Thang
FROM ChiTietDonHang
JOIN Nuoc ON ChiTietDonHang.MaNuoc = Nuoc.MaNuoc
JOIN DonHang ON ChiTietDonHang.MaDH = DonHang.MaDH
WHERE DonHang.NgayDatHang BETWEEN '2025-01-01' AND '2025-12-31'  -- Điều chỉnh theo khoảng thời gian bạn muốn
GROUP BY Nuoc.MaNuoc, Nuoc.TenNuoc, Nuoc.Gia, Nuoc.Loai, MONTH(DonHang.NgayDatHang)
ORDER BY TongSoLuongDat DESC;


SELECT 
    Nuoc.MaNuoc,
    Nuoc.TenNuoc,
    Nuoc.Gia,
    Nuoc.Loai,
    SUM(ChiTietDonHang.SoLuong) AS TongSoLuongDat,
    YEAR(DonHang.NgayDatHang) AS Nam
FROM ChiTietDonHang
JOIN Nuoc ON ChiTietDonHang.MaNuoc = Nuoc.MaNuoc
JOIN DonHang ON ChiTietDonHang.MaDH = DonHang.MaDH
WHERE DonHang.NgayDatHang BETWEEN '2020-01-01' AND '2025-12-31'  
GROUP BY Nuoc.MaNuoc, Nuoc.TenNuoc, Nuoc.Gia, Nuoc.Loai, YEAR(DonHang.NgayDatHang) 
ORDER BY YEAR(DonHang.NgayDatHang) DESC, TongSoLuongDat DESC;

SELECT TOP 1 
    Nuoc.MaNuoc,
    Nuoc.TenNuoc,
    Nuoc.Gia,
    Nuoc.Loai,
    SUM(ChiTietDonHang.SoLuong) AS TongSoLuongDat,
    MONTH(DonHang.NgayDatHang) AS Thang,
    YEAR(DonHang.NgayDatHang) AS Nam
FROM ChiTietDonHang
JOIN Nuoc ON ChiTietDonHang.MaNuoc = Nuoc.MaNuoc
JOIN DonHang ON ChiTietDonHang.MaDH = DonHang.MaDH
Where Nuoc.Loai = N'Cà phê' AND MONTH(DonHang.NgayDatHang) = MONTH(GETDATE()) AND YEAR(DonHang.NgayDatHang) = YEAR(GETDATE())
GROUP BY Nuoc.MaNuoc, Nuoc.TenNuoc, Nuoc.Gia, Nuoc.Loai, MONTH(DonHang.NgayDatHang), YEAR(DonHang.NgayDatHang)
ORDER BY Nuoc.Loai ASC, TongSoLuongDat DESC;


SELECT DISTINCT Loai FROM Nuoc;

select * from DonHang where DonHang.



