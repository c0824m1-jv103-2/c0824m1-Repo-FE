package com.example.module3.repository;

import com.example.module3.entity.NhanVien;
import com.example.module3.entity.PhongBan;
import com.example.module3.repository.imp.INhanVienRepository;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NhanVienRepository implements INhanVienRepository {
    private final String SELECT_NhanVien = "select n.*, pb.TenPhongBan from nhanvien n join phongban pb " + "on n.MaPhongBan = pb.MaPhongBan where pb.TenPhongBan like ?";

    @Override
    public List<NhanVien> findAllNhanVien(String TenPhongBan) {
        List<NhanVien> nhanViens = new ArrayList<NhanVien>();
        try (Connection connection = BaseRepository.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_NhanVien);)
        {
            preparedStatement.setString(1, "%" + TenPhongBan + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int MaNV = resultSet.getInt("MaNV");
                String HoTen = resultSet.getString("HoTen");
                LocalDate NgaySinh = resultSet.getDate("NgaySinh").toLocalDate();
                String GioiTinh = resultSet.getString("GioiTinh");
                String ChucVu = resultSet.getString("ChucVu");
                String Email = resultSet.getString("Email");
                String CCCD = resultSet.getString("CCCD");
                int MaPhongBan = resultSet.getInt("MaPhongBan");
                String tenPhongBan = resultSet.getString("TenPhongBan");
                PhongBan phongBan = new PhongBan(MaPhongBan, tenPhongBan);
                NhanVien nhanVien = new NhanVien(MaNV, HoTen, NgaySinh, GioiTinh, ChucVu, Email, CCCD, phongBan);
                nhanViens.add(nhanVien);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nhanViens;
    }

    @Override
    public List<NhanVien> findAllMaNV() {
        List<NhanVien> nhanViens = new ArrayList<>();
        try(Statement statement = BaseRepository.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from nhanvien");) {
            while (resultSet.next()) {
                int MaNV = resultSet.getInt("MaNV");
                nhanViens.add(new NhanVien(MaNV));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return nhanViens;
    }
}
