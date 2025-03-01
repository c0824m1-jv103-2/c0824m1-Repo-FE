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
    public void deleteNhanVien(int MaNV) {
        try (
                Connection connection = BaseRepository.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE_NhanVien);
        ) {
            preparedStatement.setInt(1, MaNV);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createNhanVien(NhanVien nhanVien) {
        try (
                Connection connection = BaseRepository.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NhanVien);
        ) {
            preparedStatement.setString(1, nhanVien.getHoTen());
            preparedStatement.setDate(2, java.sql.Date.valueOf(nhanVien.getNgaySinh()));
            preparedStatement.setString(3, nhanVien.getGioiTinh());
            preparedStatement.setString(4, nhanVien.getChucVu());
            preparedStatement.setString(5, nhanVien.getEmail());
            preparedStatement.setString(6, nhanVien.getCCCD());
            preparedStatement.setInt(7, nhanVien.getPhongBan().getMaPhongBan());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(NhanVien nhanVien) {
        try (
                Connection connection = BaseRepository.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_NhanVien);
        ) {
            preparedStatement.setString(1, nhanVien.getHoTen());
            preparedStatement.setDate(2, java.sql.Date.valueOf(nhanVien.getNgaySinh()));
            preparedStatement.setString(3, nhanVien.getGioiTinh());
            preparedStatement.setString(4, nhanVien.getChucVu());
            preparedStatement.setString(5, nhanVien.getEmail());
            preparedStatement.setString(6, nhanVien.getCCCD());
            preparedStatement.setInt(7, nhanVien.getPhongBan().getMaPhongBan());
            preparedStatement.setInt(8, nhanVien.getMaNV());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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

    @Override
    public NhanVien updateNhanVien(int MaNV) {
        try (
                Connection connection = BaseRepository.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_NHANVIEN);
        ) {
            preparedStatement.setInt(1, MaNV);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int MaNhanVien = resultSet.getInt("MaNV");
                String HoTen = resultSet.getString("HoTen");
                LocalDate NgaySinh = resultSet.getDate("NgaySinh").toLocalDate();
                String GioiTinh = resultSet.getString("GioiTinh");
                String ChucVu = resultSet.getString("ChucVu");
                String Email = resultSet.getString("Email");
                String CCCD = resultSet.getString("CCCD");
                int MaPhongBan = resultSet.getInt("MaPhongBan");
                NhanVien nhanVien = new NhanVien(MaNhanVien, HoTen, NgaySinh, GioiTinh, ChucVu, Email, CCCD);
                return nhanVien;
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
